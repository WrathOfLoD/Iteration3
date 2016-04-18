package com.wrathOfLoD.Models.Entity;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Commands.ActionCommandVendor;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.DieCommand;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.DropItemCommand;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Entity.EntityCanMoveVisitor.TerrestrialCanMoveVisitor;
import com.wrathOfLoD.Models.Entity.EntityCanMoveVisitor.CanMoveVisitor;
import com.wrathOfLoD.Models.Inventory.Inventory;
import com.wrathOfLoD.Models.Items.TakeableItem;
import com.wrathOfLoD.Models.LocationTracker.LocationTrackerManager;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.MapArea;
import com.wrathOfLoD.Models.Stats.Stats;
import com.wrathOfLoD.Models.Stats.StatsModifiable;
import com.wrathOfLoD.Models.Target.NPCTargetManager;
import com.wrathOfLoD.Models.Target.TargetManager;
import com.wrathOfLoD.Observers.ModelObservers.EntityObservable;
import com.wrathOfLoD.Observers.ModelObservers.EntityObserver;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.VisitorInterfaces.EntityVisitor;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by zach on 4/7/16.
 */
public abstract class Entity implements EntityObservable{
    private TargetManager targetManager = new NPCTargetManager();
    private String name;
    private Position position;
    private Stats stats;
    private Direction direction;
    private Inventory inventory;
    private boolean isActive = false;
    private ArrayList<EntityObserver> entityObservers;
    private CanMoveVisitor canMoveVisitor;

    /**
     * aggroLevel is 0 for non aggressive entities
     * 1 for aggressive ones
     */
    private int aggroLevel = 0;

    //TODO: change the default can move visitor to an instance of DefaultCanMoveVisitor or something
    public Entity(){
        this("Master Chief", new Position(0,0,0,0), new TerrestrialCanMoveVisitor());

    }

    public Entity(String name, Position position, CanMoveVisitor canMoveVisitor){
        this.name = name;
        this.position = position;
        this.inventory = new Inventory();
        this.stats = new Stats(this);
        this.direction = Direction.DOWN_SOUTH;
        entityObservers = new ArrayList<>();
        this.canMoveVisitor = canMoveVisitor;

    }

    /***** getter & setter for Entity *******/

    public Direction getDirection(){return this.direction; }

    public Inventory getInventory(){ return this.inventory; }

    public String getName() { return this.name; }

    public Position getPosition() { return this.position; }

    public Stats getStats() { return this.stats; }

    public void setActive(){
        isActive = true;
    }

    public void setInactive(){
        isActive = false;
    }

    public void setDirection(Direction newDirection){
        this.direction = newDirection;
    }

    public void setPosition(Position newPosition){
        hideTiles();
		this.position = newPosition;
		showTiles();
    }

    protected void setName(String name){ this.name = name; }

    public CanMoveVisitor getCanMoveVisitor() {
        return canMoveVisitor;
    }

    public void setCanMoveVisitor(CanMoveVisitor canMoveVisitor) {
        this.canMoveVisitor = canMoveVisitor;
    }

    /********* END Getters and Setters *********/

    public void move(Direction movingDirection){
        if(!isActive()){
            setActive();
            ActionCommand acm = ActionCommandVendor.createMovementCommand(this, movingDirection);
            //TODO: may need command's execute to return ticks to set entity inActive and not to notify observer
            acm.execute();
        }
    }

    public void fly(Direction movingDirection){
        if(!isActive()){
            setActive();
            ActionCommand acm = ActionCommandVendor.createFlyCommand(this, movingDirection);
            //TODO: may need command's execute to return ticks to set entity inActive and not to notify observer
            acm.execute();
        }
    }

	public abstract void hideTiles();

	public abstract void showTiles();

    public void insertItemToInventory(TakeableItem item){
        this.inventory.addItem(item);
    }

    //drops item to map by calling dropItemCommand
    public void dropItem(TakeableItem item){
        if(inventory.hasItem(item)){
            inventory.removeItem(item);
            ActionCommand dropItemCommand = new DropItemCommand(this,item);
            dropItemCommand.execute();
        }
    }

    public void heal(int healAmount){
        stats.modifyStats(StatsModifiable.createHealthStatsModifiable(healAmount));
    }

    public void takeDamage(int damageAmount){
        stats.modifyStats(StatsModifiable.createHealthStatsModifiable(-damageAmount));
    }

    public void loseMana(int mana){
        stats.modifyStats(StatsModifiable.createManaStatsModifiable(-mana));
    }


    public void doInteraction(Character character) {
        //the entity starts the interaction
        //what is an interaction?
    }

    public void gainExp(int exp) {
        StatsModifiable expStats = StatsModifiable.createExperienceStatsModifiable(exp);
        getStats().modifyStats(expStats);
    }

    public void levelUp() {
        //// TODO: check if this is correct!!!
    }

    public void die(){
        ActionCommand dieCommand = new DieCommand(this);
        dieCommand.execute();
        notifyObserversOnDie(this.getPosition());

        this.setActive();

//        System.out.println("LIFES LIVE: "+ getStats().getLivesLeft());
//        if(getStats().getLivesLeft() > 0) {
//            respawn();
//        }
        entityObservers.clear();


    }

    public boolean isActive() {
        return isActive;
    }

    public void accept(EntityVisitor ev){
        ev.visitEntity(this);
    }

    public TargetManager getTargetManager() {
        return targetManager;
    }

    protected void setTargetManager(TargetManager t){
        targetManager = t;
    }

    public Iterator<EntityObserver> getEntityObservers(){
        return entityObservers.iterator();
    }

    @Override
    public void registerObserver(EntityObserver eo) {
        entityObservers.add(eo);
    }

    @Override
    public void deregisterObserver(EntityObserver eo) {
        entityObservers.remove(eo);
    }

    //TODO: not sure if this is good
    public void notifyObserverOnMove(Position src, Position dest, Direction dir, int ticks) {
        for (EntityObserver eo : entityObservers) {
            eo.notifyMove(src, dest, dir, ticks);
        }
    }

    public void notifyObsersersOnDirectionChange(Direction dir) {
        for (EntityObserver eo: entityObservers)
            eo.notifyDirectionChange(dir);
    }


    public void notifyObserversOnDie(Position position){
        for(int i = 0; i < entityObservers.size(); i++){
            entityObservers.get(i).notifyDie(position);
        }
    }

    public void notifyObserverOnAtt(){
        for(int i = 0; i < entityObservers.size(); i++){
            entityObservers.get(i).notifyAttack();
        }
    }

    public void notifyObserverDoneAtt(){
        for(int i = 0; i < entityObservers.size(); i++){
            entityObservers.get(i).notifyDoneAttack();
        }
    }

    public void setAggroLevel(int aggro){
        this.aggroLevel = aggro;
    }

    public int getAggroLevel(){
        return aggroLevel;
    }

    public void respawn(){
        StatsModifiable modifiable = StatsModifiable.createHealthManaStatsModifiable(getStats().getMaxMana(), getStats().getMaxHealth());
        getStats().modifyStats(modifiable);

        notifyObserverOnMove(this.getPosition(), Map.getInstance().getActiveMapArea().getSpawnPoint(), direction, 0);
        this.setPosition(Map.getInstance().getActiveMapArea().getSpawnPoint());

        //LocationTrackerManager.getInstance().registerEntity(this);

        System.out.println("GESTS CLLLAFED??");
    }

}


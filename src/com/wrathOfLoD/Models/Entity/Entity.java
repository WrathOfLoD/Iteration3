package com.wrathOfLoD.Models.Entity;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Commands.ActionCommandVendor;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.DropItemCommand;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Inventory.Inventory;
import com.wrathOfLoD.Models.Items.TakeableItem;
import com.wrathOfLoD.Models.Stats.Stats;
import com.wrathOfLoD.Models.Stats.StatsModifiable;
import com.wrathOfLoD.Models.Target.NPCTargetManager;
import com.wrathOfLoD.Models.Target.TargetManager;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.VisitorInterfaces.EntityVisitor;

/**
 * Created by zach on 4/7/16.
 */
public abstract class Entity {
    private TargetManager targetManager = new NPCTargetManager();
    private String name;
    private Position position;
    private Stats stats;
    private Direction direction;
    private Inventory inventory;
    private boolean isActive = false;
    /**
     * aggroLevel is 0 for non aggressive entities
     * 1 for aggressive ones
     */
    private int aggroLevel = 0;

    public Entity(){
        this("Master Chief", new Position(0,0,0,0));
    }

    public Entity(String name, Position position){
        this.name = name;
        this.position = position;
        this.inventory = new Inventory();
        this.stats = new Stats(this);
        this.direction = Direction.DOWN_SOUTH;
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
        this.position = newPosition;
    }

    protected void setName(String name){ this.name = name; }

    /********* END Getters and Setters *********/

    public void move(Direction movingDirection){
        if(!isActive()){
            ActionCommand acm = ActionCommandVendor.createMovementCommand(this, movingDirection);
            setActive();
            acm.execute();
        }
    }

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
        stats.modifyStats(StatsModifiable.createHealthStatsModifiable(damageAmount));
    }

    public void loseMana(int mana){
        stats.modifyStats(StatsModifiable.createManaStatsModifiable(-mana));
    }


    public void doInteraction(Character character) {}

    public void gainExp(int exp) {
        StatsModifiable expStats = StatsModifiable.createExperienceStatsModifiable(exp);
        getStats().modifyStats(expStats);
    }

    public void levelUp() {}

    public void die(){}

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

    public void setAggroLevel(int aggro){
        this.aggroLevel = aggro;
    }

    public int getAggroLevel(){
        return aggroLevel;
    }
}


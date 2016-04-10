package com.wrathOfLoD.Models.Entity;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Commands.ActionCommandVendor;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Inventory.Inventory;
import com.wrathOfLoD.Models.Items.TakeableItem;
import com.wrathOfLoD.Models.Stats.Stats;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by zach on 4/7/16.
 */
public abstract class Entity {
    private String name;
    private Position position;
    private Stats stats;
    private Direction direction;
    private Inventory inventory;
    private boolean isActive = false;

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

    public void pickUpItem(TakeableItem item){
        //update the position to item to be the entities position ?? <= necessary
        item.updatePosition(this.getPosition());

        this.inventory.addItem(item);
    }

    public void dropItem(TakeableItem item){
        this.inventory.removeItem(item);
        //call command that item was dropped
    }

    public void doInteraction(Character character) {}

    public void gainExp(int exp) {}

    public void levelUp() {}

    public void die(){}

    public boolean isActive() {
        return isActive;
    }

}


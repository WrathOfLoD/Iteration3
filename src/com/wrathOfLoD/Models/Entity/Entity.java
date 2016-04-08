package com.wrathOfLoD.Models.Entity;

import com.wrathOfLoD.Commands.ActionCommand.ActionCommand;
import com.wrathOfLoD.Commands.ActionCommand.MovementCommand;
import com.wrathOfLoD.Commands.Vendors.ActionCommandVendor;
import com.wrathOfLoD.Models.Entity.Character.Character;
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
    private boolean isActive = false;


    public Entity(String name, Position position){
        this.name = name;
        this.position = position;
        this.stats = new Stats(this);
        this.direction = Direction.DOWN_SOUTH;
    }

    public void move(Direction movingDirection){
        if(!isActive()){
            ActionCommand acm = ActionCommandVendor.createMovementCommand(this, getPosition(), movingDirection, getStats().getMovement());
            setActive();
            acm.execute();
        }
    }

    public void doInteraction(Character character) {}


    public void gainExp(int exp) {}

    public void levelUp() {}

    public void die(){}


    /***** Getters and Setters ********/
    public boolean isActive() {
        return isActive;
    }

    public void setActive(){
        isActive = true;
    }

    public void setInactive(){
        isActive = false;
    }

    public Direction getDirection(){return this.direction; }

    public String getName() { return this.name; }

    public Stats getStats() { return this.stats; }

    public Position getPosition() { return this.position; }

    public void setDirection(Direction newDirection){
        this.direction = newDirection;
    }

    public void setPosition(Position newPosition){
        this.position = newPosition;
    }

    protected void setName(String name){ this.name = name; }

    /********* END Getters and Setters *********/

}


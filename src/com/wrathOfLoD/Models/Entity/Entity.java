package com.wrathOfLoD.Models.Entity;

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

    public Entity(String name, Position position){
        this.name = name;
        this.position = position;
        this.stats = new Stats(this);
        this.direction = Direction.DOWN_SOUTH;
    }

    //public void move(Direction d) {}

    public void doInteraction(Character character) {}

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

    public void gainExp(int exp) {}

    public void levelUp() {}

    public void die(){}

}


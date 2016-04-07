package com.wrathOfLoD.Models.Entity;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Stats.Stats;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by zach on 4/7/16.
 */
public abstract class Entity {
    private String name;
    private Position position;
    private Stats stats;
//     private Direction direction;

    public Entity(String name, Position position){
        this.name = name;
        this.position = position;
        this.stats = new Stats();
    }

//    public void move(Direction d) {
//
//    }

    public String getName(){ return this.name; }

    public Stats getStats(){ return this.stats; }

    public Position getPosition() { return this.position; }

    public void doInteration(Character character) {}

    public void gainExp(int exp) {}

    public void levelUp() {}


}


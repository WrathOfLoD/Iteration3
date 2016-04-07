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

    public Entity(String name, Stats stats, Position position){
        this.name = name;
        this.stats = stats;
        this.position = position;
    }

    public void move(Direction d) {}

    public void doInteraction(Character character) {}

    public String getName() { return this.name; }

    public Stats getStats() { return this.stats; }

    public Position getPosition() { return this.position; }

    public void gainExp(int exp) {}

    public void levelUp() {}
}


package com.wrathOfLoD.Models.Entity;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by zach on 4/7/16.
 */
public abstract class Entity {
    private Position position;
//     private Direction direction;

    public Entity() {

    }

//    public void move(Direction d) {
//
//    }

    public void doInteration(Character character) {}

    public void gainExp(int exp) {}

    public void levelUp() {}

    public Position getPosition() { return this.position; }
}


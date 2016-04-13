package com.wrathOfLoD.Models.Entity.Character;

import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.VisitorInterfaces.EntityVisitor;

/**
 * Created by zach on 4/7/16.
 */


public class Pet extends NPC {
    public Pet(String name, Position position, Occupation occupation) {
        super(name,position, occupation);
        this.setAggression(0);
        this.setGreed(10);
    }

    public void accept(EntityVisitor ev){
        ev.visitPet(this);
    }
}

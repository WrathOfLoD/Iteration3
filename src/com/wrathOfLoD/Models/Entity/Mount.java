package com.wrathOfLoD.Models.Entity;

//import com.sun.tools.classfile.TypeAnnotation;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Stats.Stats;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.VisitorInterfaces.EntityVisitor;

/**
 * Created by zach on 4/7/16.
 */
public class Mount extends Entity {
    private Character rider;

    public Mount(String name, Position position) {
        super(name, position);
    }

    public void mount(Character character) {}

    public void accept(EntityVisitor ev){
        ev.visitMount(this);
    }

}

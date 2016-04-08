package com.wrathOfLoD.Models.Entity.Character;

import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by zach on 4/7/16.
 */


public class Pet extends NPC {
    public Pet(String name, Position position, Occupation occupation) {
        super(name,position, occupation);
        setAggression(0);
        setGreed(10);
    }
}

package com.wrathOfLoD.Models.Entity.Character;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Occupation.Occupation;

/**
 * Created by zach on 4/7/16.
 */
public abstract class Character extends Entity {
    private Occupation occupation;

    public Character() {}

    public void interact(Entity entity) {}
//    public void interact(InteractiveItem item) {}

    public void attack() {}

}


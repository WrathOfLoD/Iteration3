package com.wrathOfLoD.Models.Entity.Character;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Items.InteractiveItem;
import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Models.Stats.Stats;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by zach on 4/7/16.
 */
public abstract class Character extends Entity {
    private Occupation occupation;

    public Character(String name, Stats stats, Position position) {
        super(name, stats, position);
    }

    public void interact(Entity entity) {}
    public void interact(InteractiveItem item) {}

    public void attack() {}

}


package com.wrathOfLoD.Models.Map.AreaEffect;


import com.wrathOfLoD.Models.Entity.Entity;

/**
 * Created by luluding on 4/16/16.
 */
public class InstantDeathAreaEffect extends AreaEffect{


    @Override
    public void interact(Entity entity) {
        entity.die();
    }
}

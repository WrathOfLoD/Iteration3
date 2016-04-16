package com.wrathOfLoD.Models.Map.AreaEffect;

import com.wrathOfLoD.Models.Entity.Entity;

/**
 * Created by luluding on 4/16/16.
 */
public class GainExpAreaEffect extends AreaEffect {
    private int exp;

    public GainExpAreaEffect(int exp){
        this.exp = exp;
    }

    @Override
    public void interact(Entity entity) {
        entity.gainExp(exp);
    }
}

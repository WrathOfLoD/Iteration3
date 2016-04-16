package com.wrathOfLoD.Models.Map.AreaEffect;

import com.wrathOfLoD.Models.Entity.Entity;

/**
 * Created by luluding on 4/16/16.
 */
public class HealDamageAreaEffect extends AreaEffect {
    private int healAmount;

    public HealDamageAreaEffect(int healAmount){
        this.healAmount = healAmount;
    }


    @Override
    public void interact(Entity entity) {
        entity.heal(healAmount);
    }
}

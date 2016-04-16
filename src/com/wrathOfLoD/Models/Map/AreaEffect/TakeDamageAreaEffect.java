package com.wrathOfLoD.Models.Map.AreaEffect;

import com.wrathOfLoD.Models.Entity.Entity;

/**
 * Created by luluding on 4/16/16.
 */
public class TakeDamageAreaEffect extends AreaEffect {
    private int damage;

    public TakeDamageAreaEffect(int damage){
        this.damage = damage;
    }

    @Override
    public void interact(Entity entity) {
        entity.takeDamage(damage);
    }
}

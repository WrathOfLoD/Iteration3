package com.wrathOfLoD.Models.RangedEffect.HitBox.HitBoxEffects;

import com.wrathOfLoD.Models.Entity.Entity;

import java.util.Iterator;
import java.util.List;

/**
 * Created by luluding on 4/12/16.
 */
public class HitBoxAttackEffect extends HitBoxEffect {
    private int damage;

    public HitBoxAttackEffect(int damage){
        this.damage = damage;
    }

    @Override
    public void doEffect(List<Entity> entities) {
        for(int i = 0; i < entities.size(); i++){
            entities.get(i).takeDamage(damage);
        }

    }
}

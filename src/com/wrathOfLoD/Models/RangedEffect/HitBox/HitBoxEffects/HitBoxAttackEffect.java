package com.wrathOfLoD.Models.RangedEffect.HitBox.HitBoxEffects;

import com.wrathOfLoD.Models.Entity.Entity;

import java.util.Iterator;

/**
 * Created by luluding on 4/12/16.
 */
public class HitBoxAttackEffect extends HitBoxEffect {
    private int damage;

    public HitBoxAttackEffect(int damage){
        this.damage = damage;
    }

    @Override
    public void doEffect(Iterator<Entity> entityIterator) {
        while(entityIterator.hasNext()){
            Entity e = entityIterator.next();
        }
    }
}

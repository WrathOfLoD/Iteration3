package com.wrathOfLoD.Models.RangedEffect.HitBox.HitBoxEffects;

import com.wrathOfLoD.Models.Entity.Entity;

import java.util.Iterator;

/**
 * Created by luluding on 4/12/16.
 */
public abstract class HitBoxEffect {

    public abstract void doEffect(Iterator<Entity> entityIterator);
}

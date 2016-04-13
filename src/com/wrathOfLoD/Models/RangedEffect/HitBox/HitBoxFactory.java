package com.wrathOfLoD.Models.RangedEffect.HitBox;

import com.wrathOfLoD.Utility.Position;

/**
 * Created by luluding on 4/9/16.
 */
public abstract class HitBoxFactory {
    public abstract HitBox createHitBox(int power, int accuracy, Position position);
}

package com.wrathOfLoD.Models.RangedEffect.HitBox.HitBoxFactories;

import com.wrathOfLoD.Models.RangedEffect.HitBox.HitBox;
import com.wrathOfLoD.Models.RangedEffect.HitBox.HitBoxEffects.HitBoxAttackEffect;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/15/16.
 */
public class RangedAttackHitBoxFactory extends HitBoxFactory{
    @Override
    public HitBox createHitBox(int power, int accuracy, Position position) {
        return new HitBox(power, accuracy, "LaserBeam", position, new HitBoxAttackEffect(power));
    }
}

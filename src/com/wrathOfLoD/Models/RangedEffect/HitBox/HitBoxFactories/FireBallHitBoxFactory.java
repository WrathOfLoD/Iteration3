package com.wrathOfLoD.Models.RangedEffect.HitBox.HitBoxFactories;

//import apple.laf.JRSUIConstants;
import com.wrathOfLoD.Models.RangedEffect.HitBox.HitBox;
import com.wrathOfLoD.Models.RangedEffect.HitBox.HitBoxEffects.HitBoxAttackEffect;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by luluding on 4/12/16.
 */
public class FireBallHitBoxFactory extends HitBoxFactory {
    @Override
    public HitBox createHitBox(int power, int accuracy, Position position) {
        return new HitBox(power, accuracy, "Fireball", position, new HitBoxAttackEffect(power));
    }
}

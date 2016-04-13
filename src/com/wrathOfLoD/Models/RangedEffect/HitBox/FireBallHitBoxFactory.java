package com.wrathOfLoD.Models.RangedEffect.HitBox;

//import apple.laf.JRSUIConstants;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by luluding on 4/12/16.
 */
public class FireBallHitBoxFactory extends HitBoxFactory{
    @Override
    public HitBox createHitBox(int power, int accuracy, Position position) {
        return new HitBox(power, accuracy, "FireBall", position, new HitBoxAttackEffect(power));
    }
}

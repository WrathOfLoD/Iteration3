package com.wrathOfLoD.Models.RangedEffect.REG;

import com.wrathOfLoD.Models.RangedEffect.HitBox.HitBoxFactory;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;

import java.util.List;

/**
 * Created by luluding on 4/9/16.
 */
public class PrismREG extends RangedEffectGenerator {
    private Direction facingDirection;

    public PrismREG(int totalDistance, Position entityLocation, int damage, int travelTime, HitBoxFactory hitBoxFactory, Direction facingDirection){
        super(totalDistance, entityLocation, damage, travelTime, hitBoxFactory);
        this.facingDirection = facingDirection;
    }



    @Override
    public List<Position> getEffectiveLocations(int radius, Position orignalPos) {
        return null;
    }
}

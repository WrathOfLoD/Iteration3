package com.wrathOfLoD.Models.RangedEffect.REG;

import com.wrathOfLoD.Models.RangedEffect.HitBox.HitBoxFactory;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luluding on 4/9/16.
 */
public class FanREG extends RangedEffectGenerator {
    private Direction facingDirection;

    public FanREG(int totalDistance, Position entityLocation, int damage, int travelTime, HitBoxFactory hitBoxFactory, Direction facingDirection){
        super(totalDistance, entityLocation, damage, travelTime, hitBoxFactory);
        this.facingDirection = facingDirection;
    }

    @Override
    public List<Position> getEffectiveLocations(int radius, Position orignalPos) {
        return Position.drawArc(orignalPos, facingDirection, false, radius);
    }
}

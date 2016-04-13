package com.wrathOfLoD.Models.RangedEffect.REG;

import com.wrathOfLoD.Models.RangedEffect.HitBox.HitBoxFactory;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luluding on 4/9/16.
 */
public class LineREG extends RangedEffectGenerator{
    private Direction facingDirection;
    private List<Position> targetPositions;

    public LineREG(int totalDistance, Position entityLocation, int damage, int travelTime, HitBoxFactory hitBoxFactory, Direction facingDirection, Position targetPosition){
        super(totalDistance, entityLocation, damage, travelTime, hitBoxFactory);
        this.facingDirection = facingDirection;
        this.targetPositions = Position.drawline(entityLocation, targetPosition, totalDistance, false);
    }

    //Ability checks whether there is a valid target and calls the correct constructor
    public LineREG(int totalDistance, Position entityLocation, int damage, int travelTime, HitBoxFactory hitBoxFactory, Direction facingDirection){
        super(totalDistance, entityLocation, damage, travelTime, hitBoxFactory);
        this.facingDirection = facingDirection;
        this.targetPositions = Position.drawLine(entityLocation, facingDirection, totalDistance, false);
    }


    @Override
    public List<Position> getEffectiveLocations(int radius, Position orignalPos) {

        //TODO: extract position one by one

        return null;
    }
}

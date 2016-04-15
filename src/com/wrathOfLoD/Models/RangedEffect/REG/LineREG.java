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
        //extract the position one by one
        //TODO: is this safe? (List returned by drawline(not including original pos) always has the length of total distance traveled?)

        if(!targetPositions.isEmpty() && radius <= targetPositions.size()){
            List<Position> pos = new ArrayList<>();
            pos.add(targetPositions.get(radius-1));
            return pos;
        }

        return null;
    }
}

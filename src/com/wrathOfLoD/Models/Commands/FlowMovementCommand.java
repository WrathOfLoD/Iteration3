package com.wrathOfLoD.Models.Commands;

import com.wrathOfLoD.GameClock.Fuseable;
import com.wrathOfLoD.GameClock.TimeModel;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/17/16.
 */
public class FlowMovementCommand extends ActionCommand implements Fuseable{
    private Entity entity;
    private Direction flowDirection;
    private int flowStrength;

    public  FlowMovementCommand(Entity entity, Direction flowDirection, int flowStrength){
        this.entity = entity;
        this.flowDirection = flowDirection;
        this.flowStrength = flowStrength;
    }

    @Override
    public void execute() {
        TimeModel.getInstance().registerFuseable(this, flowStrength);
        //todo: hook up correctly to View!!
    }

    @Override
    public void explode() {
        Position nextPos = entity.getPosition().getPosInDir(flowDirection);
        Map.getInstance().removeEntity(entity, entity.getPosition());
        Map.getInstance().addEntity(entity, nextPos);
    }
}

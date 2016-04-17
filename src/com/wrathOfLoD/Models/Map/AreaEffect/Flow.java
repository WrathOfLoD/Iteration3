package com.wrathOfLoD.Models.Map.AreaEffect;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Commands.FlowMovementCommand;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Utility.Direction;

/**
 * Created by matthewdiaz on 4/16/16.
 */
public class Flow extends AreaEffect {
    private Direction flowDirection;
    private int flowStrength;

    public Flow(Direction flowDirection, int flowStrength){
        this.flowDirection = flowDirection;
        this.flowStrength = flowStrength;
    }

    public Direction getFlowDirection() {
        return this.flowDirection;
    }

    public int getFlowStrength() {
        return this.flowStrength;
    }

    private void createFlowMovementCommand(Entity entity){
        ActionCommand flowMovementCommand = new FlowMovementCommand(entity, flowDirection, flowStrength);
        System.out.println("CREATE FLOW MOVEMNT");
        flowMovementCommand.execute();
    }

    @Override
    public void interact(Entity entity) {
        createFlowMovementCommand(entity);


    }
}

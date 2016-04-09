package com.wrathOfLoD.Models.Commands.EntityActionCommands;

import com.wrathOfLoD.Controllers.InputStates.Action.Action;
import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.LocationTracker.LocationTrackerManager;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by icavitt on 4/7/2016.
 */
public class MovementCommand extends ActionCommand {
    private Entity entity;
    private Position currentPosition;
    private Position destinationPosition;
    private Direction movingDirection;
    private int movementTicks; //how long it takes an Entity to move to a location


    public MovementCommand(Entity entity, Position currentPosition, Direction movingDirection, int movementSpeed){
        this.entity = entity;
        this.currentPosition = currentPosition;
        this.movingDirection = movingDirection;
        this.movementTicks = 60 - movementSpeed; //TODO: MAX TICKS - movement speed
        this.destinationPosition = this.currentPosition.getPosInDir(movingDirection);
    }

    @Override
    public void execute() {

        entity.setDirection(movingDirection);

        Map.getInstance().removeEntity(entity, currentPosition);
        Map.getInstance().addEntity(entity, destinationPosition);

        // Update Entity's location in LocationTrackerManager
        LocationTrackerManager.getInstance().updateLocation(entity);


        //TODO: Entity movement speed
        //TODO: register with time model
        //TODO: entity set active = false when done moving

    }
}

package com.wrathOfLoD.Commands.ActionCommand;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.LocationTracker.LocationTrackerManager;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.Tile;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;
import javafx.geometry.Pos;

/**
 * Created by luluding on 4/8/16.
 */
public class MovementCommand extends ActionCommand{

    private Position currentPosition;
    private Position destinationPosition;
    private Direction movingDirection;
    private int movementTicks; //how long it takes an Entity to move to a location


    public MovementCommand(Entity entity, Position currentPosition, Direction movingDirection, int movementSpeed){
        super(entity);
        this.currentPosition = currentPosition;
        this.movingDirection = movingDirection;
        this.movementTicks = 60 - movementSpeed; //TODO: MAX TICKS - movement speed
        this.destinationPosition = this.currentPosition.getPosInDir(movingDirection);
    }

    @Override
    public void execute() {

        getEntity().setDirection(movingDirection);

        Tile currentTile = Map.getInstance().getTile(currentPosition);
        Tile destTile = Map.getInstance().getTile(destinationPosition);
        currentTile.removeEntity(getEntity());
        destTile.add(getEntity());

        // Update Entity's location in LocationTrackerManager
        LocationTrackerManager.getInstance().updateLocation(this.getEntity());


        //TODO: Entity movement speed
        //TODO: register with time model
        //TODO: entity set active = false when done moving

    }
}

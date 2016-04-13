package com.wrathOfLoD.Models.Commands.EntityActionCommands;

import com.wrathOfLoD.Controllers.InputStates.Action.Action;
import com.wrathOfLoD.GameClock.Fuseable;
import com.wrathOfLoD.GameClock.Tickable;
import com.wrathOfLoD.GameClock.TimeModel;
import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.LocationTracker.LocationTrackerManager;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by icavitt on 4/7/2016.
 */
public class MovementCommand extends ActionCommand implements Fuseable{
    private Entity entity;
    private Position currentPosition;
    private Position destinationPosition;
    private Direction movingDirection;
    private int movementTicks; //how long it takes an Entity to move to a location


    public MovementCommand(Entity entity, Direction movingDirection){
        this.entity = entity;
        this.movingDirection = movingDirection;
    }

    @Override
    public void execute() {
        currentPosition = entity.getPosition();
        destinationPosition = currentPosition.getPosInDir(movingDirection);
        movementTicks = 60 - entity.getStats().getMovement(); //TODO: MAX SPEED - movement speed??
        System.out.println("DIR: " + movingDirection);

        //TODO: Check entity can move on a tile

        System.out.println("======= BEGINNING OF MOVEMENT CMD =========");
        System.out.println("Entity src pos: " + entity.getPosition().getQ() + ", " + entity.getPosition().getR() + ", " + entity.getPosition().getH());



        entity.setDirection(movingDirection);
        System.out.println("Entity dest direction: " + entity.getDirection());
        entity.setPosition(destinationPosition);

        /* TODO: uncomment ... now we have no map.. no maparea... etc
        //Map.getInstance().removeEntity(entity, currentPosition);
        //Map.getInstance().addEntity(entity, destinationPosition);

        // Update Entity's location in LocationTrackerManager
//        LocationTrackerManager.getInstance().updateLocation(entity);
        */

        TimeModel.getInstance().registerFuseable(this, movementTicks);
    }

    @Override
    public void explode() {
        entity.setActive();
        System.out.println("Entity dest pos: " + entity.getPosition().getQ() + ", " + entity.getPosition().getR() + ", " + entity.getPosition().getH());
        System.out.println("======= END OF MOVEMENT CMD =========");
    }

    public Direction getDirection() {
        return this.movingDirection;
    }
    public void setDirection(Direction dir) {
        this.movingDirection = dir;
    }

}

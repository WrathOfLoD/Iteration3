package com.wrathOfLoD.Models.Commands.EntityActionCommands;

import com.wrathOfLoD.Controllers.InputStates.Action.Action;
import com.wrathOfLoD.Controllers.InputStates.ActionVendor;
import com.wrathOfLoD.GameClock.Fuseable;
import com.wrathOfLoD.GameClock.Tickable;
import com.wrathOfLoD.GameClock.TimeModel;
import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Commands.ActionCommandVendor;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Entity.EntityCanMoveVisitor.CanMoveVisitor;
import com.wrathOfLoD.Models.LocationTracker.LocationTrackerManager;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by icavitt on 4/7/2016.
 */
public class MovementCommand extends ActionCommand implements Fuseable {
    private Entity entity;
    private Position currentPosition;
    private Position destinationPosition;
    private Direction movingDirection;
    private int movementTicks; //how long it takes an Entity to move to a location
    private CanMoveVisitor canMoveVisitor;


    public MovementCommand(Entity entity, Direction movingDirection){
        this.entity = entity;
        this.movingDirection = movingDirection;
        this.canMoveVisitor = entity.getCanMoveVisitor();
    }

    @Override
    public void execute() {
        if(entity.isActive())
            return;

        entity.setActive();

        currentPosition = entity.getPosition();
        movementTicks = 60 - entity.getStats().getMovement(); //TODO: MAX SPEED - movement speed??
        entity.setDirection(movingDirection);

    /* logic: check 1 tile above entity's direction (if can't move) -> check tile adjacent to entity (if can't move)-> check 1 tile below entity's direction (if can't move-> reject movement*/
        Position adjacentPos = currentPosition.getPosInDir(movingDirection);
        Position abovePos = new Position(adjacentPos.getQ(), adjacentPos.getR(), adjacentPos.getH()+1);
        Position belowPos = new Position(adjacentPos.getQ(), adjacentPos.getR(), adjacentPos.getH()-1);
        //TODO: handle if H=0 already


        if(Map.getInstance().hasTileAt(adjacentPos) && entity.getPosition().getH()+1 < Map.getInstance().getTilePillar(adjacentPos).getGroundLevel()){
            entity.setInactive();
            return;
        }

        //TODO: if h > 10 or h < 0 don't visitTile
        boolean canMoveAbove = false, canMoveAdjacent = false, canMoveBelow = false;


        int entityGroundLevel = entity.getPosition().getH();

        // Does the tile even exist?
        if (!Map.getInstance().hasTileAt(adjacentPos))
            return;

        int adjacentGroundLevel = Map.getInstance().getTilePillar(adjacentPos).getGroundLevel();

        if (adjacentGroundLevel == (entityGroundLevel + 1) && !(entityGroundLevel + 1 > 10)) {
            Map.getInstance().getTile(abovePos).accept(canMoveVisitor);
            canMoveAbove = canMoveVisitor.canMove();
            System.out.println("CANT MOVE UP!");
        } else if (adjacentGroundLevel == entityGroundLevel) {
            Map.getInstance().getTile(adjacentPos).accept(canMoveVisitor);
            canMoveAdjacent = canMoveVisitor.canMove();

        } else if (adjacentGroundLevel == entityGroundLevel - 1 && entityGroundLevel - 1 >= 0) {
            Map.getInstance().getTile(belowPos).accept(canMoveVisitor);  //TODO: make sure this is not TDAAAAAA!!!!!
            canMoveBelow = canMoveVisitor.canMove();
        }


        // Will contain the fallCommand (if the entity is going to fall)
        ActionCommand fallCommand = null;

        if(canMoveAbove) {
            if(abovePos.getH() > (entity.getPosition().getH()+1)){
                entity.setInactive();
                return;
            }
            destinationPosition = abovePos;
        }
        else if(canMoveAdjacent) {
            destinationPosition = adjacentPos;
        }
        else if(canMoveBelow) {
            destinationPosition = belowPos;
        }
        else{
            if (adjacentGroundLevel < entityGroundLevel - 1) {
                fallCommand = ActionCommandVendor.createFallCommand(entity, entityGroundLevel - adjacentGroundLevel);
                Position fallPosition = new Position(adjacentPos.getQ(), adjacentPos.getR(), adjacentGroundLevel);

                // TODO: 4/17/16 NEED TO CHECK IF THE FALL POSITION IS MOVABLE VIA THE CANMOVEVISITOR
                destinationPosition = fallPosition;
            } else {
                entity.setInactive();
                return;
            }
        }

//
        System.out.println("======= BEGINNING OF MOVEMENT CMD =========");
        System.out.println("Entity src pos: " + entity.getPosition().getQ() + ", " + entity.getPosition().getR() + ", " + entity.getPosition().getH());
        System.out.println("Entity dest pos: " + destinationPosition.getQ() + ", " + destinationPosition.getR() + ", " + destinationPosition.getH());
        System.out.println("Entity dest direction: " + entity.getDirection());

        entity.notifyObsersersOnDirectionChange(movingDirection);

        entity.notifyObserverOnMove(entity.getPosition(), destinationPosition, movingDirection, movementTicks);
        entity.setPosition(destinationPosition);


        Map.getInstance().removeEntity(entity, currentPosition);
        Map.getInstance().addEntity(entity, destinationPosition);

        // Update Entity's location in LocationTrackerManager
        LocationTrackerManager.getInstance().updateLocation(entity);

        TimeModel.getInstance().registerFuseable(this, movementTicks);

        if (fallCommand != null) {
            fallCommand.execute();
        }
    }

    @Override
    public void explode() {
        //entity.setActive();
        entity.setInactive();
//        System.out.println("Entity dest pos: " + entity.getPosition().getQ() + ", " + entity.getPosition().getR() + ", " + entity.getPosition().getH());
//        System.out.println("======= END OF MOVEMENT CMD =========");
    }

    public void setMovementTicks(int movementTicks) {
        this.movementTicks = movementTicks;
    }

    public Direction getDirection() {
        return this.movingDirection;
    }
    public void setDirection(Direction dir) {
        this.movingDirection = dir;
    }

    public Entity getEntity() {
        return entity;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public Position getDestinationPosition() {
        return destinationPosition;
    }

    public Direction getMovingDirection() {
        return movingDirection;
    }

    public int getMovementTicks() {
        return movementTicks;
    }

    public CanMoveVisitor getCanMoveVisitor() {
        return canMoveVisitor;
    }

    public void setDestinationPosition(Position destinationPosition) {
        this.destinationPosition = destinationPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }
}
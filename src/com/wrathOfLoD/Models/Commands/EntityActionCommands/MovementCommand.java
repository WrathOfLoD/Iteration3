package com.wrathOfLoD.Models.Commands.EntityActionCommands;

import com.wrathOfLoD.Controllers.InputStates.Action.Action;
import com.wrathOfLoD.GameClock.Fuseable;
import com.wrathOfLoD.GameClock.Tickable;
import com.wrathOfLoD.GameClock.TimeModel;
import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Entity.EntityCanMoveVisitor.CanMoveVisitor;
import com.wrathOfLoD.Models.LocationTracker.LocationTrackerManager;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;
import javafx.geometry.Pos;

import javax.swing.plaf.synth.SynthTextAreaUI;

/**
 * Created by icavitt on 4/7/2016.
 */
public class MovementCommand extends ActionCommand implements Fuseable{
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
        if(!entity.isActive()){
            entity.setActive();
            currentPosition = entity.getPosition();
            movementTicks = 60 - entity.getStats().getMovement(); //TODO: MAX SPEED - movement speed??
            entity.setDirection(movingDirection);

        /* logic: check 1 tile above entity's direction (if can't move) -> check tile adjacent to entity (if can't move)-> check 1 tile below entity's direction (if can't move-> reject movement*/
            Position adjacentPos = currentPosition.getPosInDir(movingDirection);
            Position abovePos = new Position(adjacentPos.getQ(), adjacentPos.getR(), adjacentPos.getH()+1);
            Position belowPos = new Position(adjacentPos.getQ(), adjacentPos.getR(), adjacentPos.getH()-1);
            //TODO: handle if H=0 already



            System.out.println("Entity src pos: " + entity.getPosition().getQ() + ", " + entity.getPosition().getR() + ", " + entity.getPosition().getH());
            //System.out.println("Entity dest pos: " + destinationPosition.getQ() + ", " + destinationPosition.getR() + ", " + destinationPosition.getH());
            System.out.println("Ground level: " + Map.getInstance().getTilePillar(entity.getPosition()).getGroundLevel());



            if(entity.getPosition().getH()+1 < Map.getInstance().getTilePillar(adjacentPos).getGroundLevel()){
                entity.setInactive();
                return;
            }
            //else if .. > ground Level, drop command


            //TODO: if h > 10 or h < 0 don't visitTile
            boolean canMoveAbove = false, canMoveAdjacent = false, canMoveBelow = false;

            if(abovePos.getH() < 10) {
                Map.getInstance().getTile(abovePos).accept(canMoveVisitor);
                canMoveAbove = canMoveVisitor.canMove();
            }

            Map.getInstance().getTile(adjacentPos).accept(canMoveVisitor);
            canMoveAdjacent = canMoveVisitor.canMove();

            if(belowPos.getH() >= Map.getInstance().getTilePillar(adjacentPos).getGroundLevel()) {
                Map.getInstance().getTile(belowPos).accept(canMoveVisitor);  //TODO: make sure this is not TDAAAAAA!!!!!
                canMoveBelow = canMoveVisitor.canMove();
            }



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
                entity.setInactive();
                return;
            }


            System.out.println("======= BEGINNING OF MOVEMENT CMD =========");
            System.out.println("Entity src pos: " + entity.getPosition().getQ() + ", " + entity.getPosition().getR() + ", " + entity.getPosition().getH());
            System.out.println("Entity dest pos: " + destinationPosition.getQ() + ", " + destinationPosition.getR() + ", " + destinationPosition.getH());
            System.out.println("Entity dest direction: " + entity.getDirection());
            entity.notifyObserverOnMove(entity.getPosition(), destinationPosition, movingDirection, movementTicks);
            entity.setPosition(destinationPosition);


            Map.getInstance().removeEntity(entity, currentPosition);
            Map.getInstance().addEntity(entity, destinationPosition);

            // Update Entity's location in LocationTrackerManager
            LocationTrackerManager.getInstance().updateLocation(entity);

            TimeModel.getInstance().registerFuseable(this, movementTicks);
        }

    }

    @Override
    public void explode() {
        //entity.setActive();
        entity.setInactive();
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

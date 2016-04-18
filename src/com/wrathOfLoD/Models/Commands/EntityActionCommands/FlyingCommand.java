package com.wrathOfLoD.Models.Commands.EntityActionCommands;

import com.wrathOfLoD.GameClock.Fuseable;
import com.wrathOfLoD.GameClock.TimeModel;
import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Commands.ActionCommandVendor;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.LocationTracker.LocationTrackerManager;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;
import javafx.geometry.Pos;

/**
 * Created by Ian on 4/17/2016.
 */
public class FlyingCommand extends MovementCommand implements Fuseable {

    public FlyingCommand(Entity entity, Direction movingDirection) {
        super(entity, movingDirection);
    }

    @Override
    public void execute() {
        setCurrentPosition(getEntity().getPosition());
        setMovementTicks(60 - getEntity().getStats().getMovement()); //TODO: MAX SPEED - movement speed??
        getEntity().setDirection(getMovingDirection());
        if(getDirection().equals(Direction.UP)){
            Position temp = new Position(getCurrentPosition().getQ(), getCurrentPosition().getR(), getCurrentPosition().getH()+1);
            Map.getInstance().getTile(temp).accept(getCanMoveVisitor());
            boolean canMove = getCanMoveVisitor().canMove();
            if(canMove){
                setDestinationPosition(temp);
            }
        }else if(getDirection().equals(Direction.DOWN)){
            Position temp = new Position(getCurrentPosition().getQ(), getCurrentPosition().getR(), getCurrentPosition().getH()-1);
            Map.getInstance().getTile(temp).accept(getCanMoveVisitor());
            boolean canMove = getCanMoveVisitor().canMove();
            if(canMove){
                setDestinationPosition(temp);
            }
        }else{
            Position adjacentPos = getCurrentPosition().getPosInDir(getMovingDirection());
            Position abovePos = new Position(adjacentPos.getQ(), adjacentPos.getR(), adjacentPos.getH()+1);
            Position belowPos = new Position(adjacentPos.getQ(), adjacentPos.getR(), adjacentPos.getH()-1);
            //TODO: handle if H=0 already


            if(Map.getInstance().hasTileAt(adjacentPos) && getEntity().getPosition().getH()+1 < Map.getInstance().getTilePillar(adjacentPos).getGroundLevel()){
                getEntity().setInactive();
                return;
            }

            //TODO: if h > 10 or h < 0 don't visitTile
            boolean canMoveAbove = false, canMoveAdjacent = false, canMoveBelow = false;


            int entityGroundLevel = getEntity().getPosition().getH();

            // Does the tile even exist?
            if (!Map.getInstance().hasTileAt(adjacentPos))
                return;

            int adjacentGroundLevel = Map.getInstance().getTilePillar(adjacentPos).getGroundLevel();

            if (adjacentGroundLevel == (entityGroundLevel + 1) && !(entityGroundLevel + 1 > 10)) {
                Map.getInstance().getTile(abovePos).accept(getCanMoveVisitor());
                canMoveAbove = getCanMoveVisitor().canMove();
                System.out.println("CANT MOVE UP!");
            } else if (adjacentGroundLevel == entityGroundLevel) {
                Map.getInstance().getTile(adjacentPos).accept(getCanMoveVisitor());
                canMoveAdjacent = getCanMoveVisitor().canMove();

            } else if (adjacentGroundLevel == entityGroundLevel - 1 && entityGroundLevel - 1 >= 0) {
                Map.getInstance().getTile(belowPos).accept(getCanMoveVisitor());  //TODO: make sure this is not TDAAAAAA!!!!!
                canMoveBelow = getCanMoveVisitor().canMove();
            }


            // Will contain the fallCommand (if the entity is going to fall)
            ActionCommand fallCommand = null;

            if(canMoveAbove) {
                if(abovePos.getH() > (getEntity().getPosition().getH()+1)){
                    getEntity().setInactive();
                    return;
                }
                setDestinationPosition(abovePos);
            }
            else if(canMoveAdjacent) {
                setDestinationPosition(adjacentPos);
            }
            else if(canMoveBelow) {
                setDestinationPosition(belowPos);
            }
            else{
                setDestinationPosition(belowPos);
//                if (adjacentGroundLevel < entityGroundLevel - 1) {
//                    fallCommand = ActionCommandVendor.createFallCommand(getEntity(), entityGroundLevel - adjacentGroundLevel);
//                    Position fallPosition = new Position(adjacentPos.getQ(), adjacentPos.getR(), adjacentGroundLevel);
//
//                    // TODO: 4/17/16 NEED TO CHECK IF THE FALL POSITION IS MOVABLE VIA THE CANMOVEVISITOR
//                    set = fallPosition;
//                } else {
//                    entity.setInactive();
//                    return;
//                }
            }
        }
        Position adjacentPos = getCurrentPosition().getPosInDir(getMovingDirection());
        int adjacentGroundLevel = Map.getInstance().getTilePillar(adjacentPos).getGroundLevel();
        if(getDestinationPosition().getH() < adjacentGroundLevel){
            setDestinationPosition(new Position(getDestinationPosition().getQ(), getDestinationPosition().getR(), getDestinationPosition().getH()+1));
        }
        System.out.println("======= BEGINNING OF MOVEMENT CMD =========");
        System.out.println("Entity src pos: " + getEntity().getPosition().getQ() + ", " + getEntity().getPosition().getR() + ", " + getEntity().getPosition().getH());
        System.out.println("Entity dest pos: " + getDestinationPosition().getQ() + ", " + getDestinationPosition().getR() + ", " + getDestinationPosition().getH());
        System.out.println("Entity dest direction: " + getEntity().getDirection());
        getEntity().notifyObserverOnMove(getEntity().getPosition(), getDestinationPosition(), getMovingDirection(), getMovementTicks());
        getEntity().setPosition(getDestinationPosition());


        Map.getInstance().removeEntity(getEntity(), getCurrentPosition());
        Map.getInstance().addEntity(getEntity(), getDestinationPosition());

        // Update Entity's location in LocationTrackerManager
        LocationTrackerManager.getInstance().updateLocation(getEntity());
        //TODO: COMMENT OUT

        TimeModel.getInstance().registerFuseable(this, getMovementTicks());
    }

}

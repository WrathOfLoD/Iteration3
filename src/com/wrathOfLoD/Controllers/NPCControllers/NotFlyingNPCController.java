package com.wrathOfLoD.Controllers.NPCControllers;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Target.EntityTarget;
import com.wrathOfLoD.Models.Target.Target;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;
import javafx.geometry.Pos;

/**
 * Created by Ian on 4/16/2016.
 */
public class NotFlyingNPCController extends NPCController{

    public NotFlyingNPCController(Entity e){
        super(e);
    }

    @Override
    protected void think(Target target) {
        if( (getControlledEntity().getAggroLevel() == 0 && target instanceof EntityTarget) || target.equals(null)){
            //idle
        }
        else{
            if(target.getPosition().getHorizontalDist(getControlledEntity().getPosition()) > 1){
                moveTowardsTarget(target.getPosition());
            }
            else{
                if(target instanceof EntityTarget){
                    attack(target);
                }
                else{
                    moveOn(target);
                }
            }
        }
    }

    @Override
    protected void moveTowardsTarget(Position position) {
        Direction dir  = Position.getDirectionFromPostoPos(getControlledEntity().getPosition(), position);
        switch(dir){
            case UP_NORTH:
                dir = Direction.NORTH;
                break;
            case UP_NORTH_EAST:
                dir = Direction.NORTH_EAST;
                break;
            case UP_NORTH_WEST:
                dir = Direction.NORTH_WEST;
                break;
            case DOWN_NORTH:
                dir = Direction.NORTH;
                break;
            case DOWN_NORTH_EAST:
                dir = Direction.NORTH_EAST;
                break;
            case DOWN_NORTH_WEST:
                dir = Direction.NORTH_WEST;
                break;
            case UP_SOUTH:
                dir = Direction.SOUTH;
                break;
            case UP_SOUTH_EAST:
                dir = Direction.SOUTH_EAST;
                break;
            case UP_SOUTH_WEST:
                dir = Direction.SOUTH_WEST;
                break;
            case DOWN_SOUTH:
                dir = Direction.SOUTH;
                break;
            case DOWN_SOUTH_EAST:
                dir = Direction.SOUTH_EAST;
                break;
            case DOWN_SOUTH_WEST:
                dir = Direction.SOUTH_WEST;
                break;
            default:
                dir = dir;
                break;
        }
        /**
         * the following won't work for ground entities...for now theyll just get stuck
         */
//        Position currentPosition = getControlledEntity().getPosition();
//        while(currentPosition.getDistance(getControlledEntity().getPosition()) == 0){
//            getControlledEntity().move(dir);
//            dir = adjustDir(dir);
//        }
        getControlledEntity().move(dir);
    }
//    @Override
//    protected Direction adjustDir(Direction dir){
//        switch (dir){
//            case NORTH:
//                dir = Direction.NORTH_EAST;
//                break;
//            case NORTH_EAST:
//                dir = Direction.SOUTH_EAST;
//                break;
//            case SOUTH_EAST:
//                dir = Direction.SOUTH;
//                break;
//            case SOUTH:
//                dir = Direction.SOUTH_WEST;
//                break;
//            case
//        }
//    }

    @Override
    protected void attack(Target target) {
        Direction dir  = Position.getDirectionFromPostoPos(getControlledEntity().getPosition(), target.getPosition());
        switch(dir){
            case UP_NORTH:
                dir = Direction.NORTH;
                break;
            case UP_NORTH_EAST:
                dir = Direction.NORTH_EAST;
                break;
            case UP_NORTH_WEST:
                dir = Direction.NORTH_WEST;
                break;
            case DOWN_NORTH:
                dir = Direction.NORTH;
                break;
            case DOWN_NORTH_EAST:
                dir = Direction.NORTH_EAST;
                break;
            case DOWN_NORTH_WEST:
                dir = Direction.NORTH_WEST;
                break;
            case UP_SOUTH:
                dir = Direction.SOUTH;
                break;
            case UP_SOUTH_EAST:
                dir = Direction.SOUTH_EAST;
                break;
            case UP_SOUTH_WEST:
                dir = Direction.SOUTH_WEST;
                break;
            case DOWN_SOUTH:
                dir = Direction.SOUTH;
                break;
            case DOWN_SOUTH_EAST:
                dir = Direction.SOUTH_EAST;
                break;
            case DOWN_SOUTH_WEST:
                dir = Direction.SOUTH_WEST;
                break;
            default:
                dir = dir;
                break;
        }
        getControlledEntity().setDirection(dir);
        getControlledEntity().attack();
    }

    @Override
    protected void moveOn(Target target) {
        moveTowardsTarget(target.getPosition());
    }
}

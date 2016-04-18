package com.wrathOfLoD.Controllers.NPCControllers;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Target.EntityTarget;
import com.wrathOfLoD.Models.Target.Target;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;
import javafx.geometry.Pos;

/**
 * Created by Ian on 4/16/2016.
 */
public class FlyingNPCController extends NPCController {

    public FlyingNPCController(Entity e){
        super(e);
    }

    @Override
    protected void think(Target target) {
        if(target != null && !getControlledEntity().isDead()){
            if( (getControlledEntity().getAggroLevel() == 0 && target instanceof EntityTarget)){
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
    }

    @Override
    protected void moveTowardsTarget(Position position) {
        Direction dir  = Position.getDirectionFromPostoPos(getControlledEntity().getPosition(), position);
//        dir = Direction.UP;
        Position myPos = getControlledEntity().getPosition();
        int dist = myPos.getDistance(myPos);
        while(dist == 0 && !getControlledEntity().isActive()){
            getControlledEntity().fly(dir);
            dir = adjustDirection(dir, myPos);
            dist = myPos.getDistance(getControlledEntity().getPosition());
        }
    }

    /**
     * The desired direction it wanted to move in failed so try a different 1
     * there is probably a better way to do this but this should work for now
     * @param dir
     * @param pos
     * @return
     */
    private Direction adjustDirection(Direction dir, Position pos) {
        //if it couldn't move fly up to top so it will go around everything
        if(pos.getH() != 9){
            dir = Direction.UP;
        }
        //if we are at the top and still stuck try moving to a side
        else{
            switch (dir){
                case NORTH:
                case DOWN_NORTH:
                    dir = Direction.NORTH_EAST;
                    break;
                case NORTH_EAST:
                case DOWN_NORTH_EAST:
                    dir = Direction.SOUTH_EAST;
                    break;
                case SOUTH_EAST:
                case DOWN_SOUTH_EAST:
                    dir = Direction.SOUTH;
                    break;
                case SOUTH:
                case DOWN_SOUTH:
                    dir = Direction.SOUTH_WEST;
                    break;
                case SOUTH_WEST:
                case DOWN_SOUTH_WEST:
                    dir = Direction.NORTH_WEST;
                    break;
            }
        }
        return dir;
    }

    @Override
    protected void attack(Target target) {
        Direction dir = Position.getDirectionFromPostoPos(getControlledEntity().getPosition(), target.getPosition());
        getControlledEntity().setDirection(dir);
        getControlledEntity().attack();
    }

    @Override
    protected void moveOn(Target target) {
        moveTowardsTarget(target.getPosition());
    }
}

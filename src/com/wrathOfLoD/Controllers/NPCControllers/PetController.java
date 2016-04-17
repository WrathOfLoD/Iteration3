package com.wrathOfLoD.Controllers.NPCControllers;

import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Entity.Character.NPC;
import com.wrathOfLoD.Models.Entity.Character.Pet;
import com.wrathOfLoD.Models.Target.EntityTarget;
import com.wrathOfLoD.Models.Target.Target;

/**
 * Created by Ian on 4/16/2016.
 */
public class PetController extends NotFlyingNPCController {
    public PetController(Pet p){
        super(p);
    }

    @Override
    protected void think(Target target) {
        if(target != null){
            if( (getControlledEntity().getAggroLevel() == 0 && target instanceof EntityTarget)){
                //idle
            }
            else{
                if(target.getPosition().getHorizontalDist(getControlledEntity().getPosition()) > 1){
                    moveTowardsTarget(target.getPosition());
                }
                else{
                    if(target instanceof EntityTarget && (!target.getTarget().equals(Avatar.getInstance()))){
                        attack(target);
                    }
                    else{
                        moveOn(target);
                    }
                }
            }
        }
        }
}

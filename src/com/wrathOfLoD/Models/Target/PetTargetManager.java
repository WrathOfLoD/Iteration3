package com.wrathOfLoD.Models.Target;

import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Entity.Character.NPC;
import com.wrathOfLoD.Models.Entity.Entity;

/**
 * Created by Ian on 4/16/2016.
 */
public class PetTargetManager extends NPCTargetManager {
    public PetTargetManager(){
        super();
    }

    @Override
    public void updateMyList(EntityTarget entityTarget){
        if(entityTarget.getTarget() instanceof NPC){
            if(entityTarget.getTarget().getAggroLevel() == 1){
                addToTargetList(entityTarget);
            }
        }
        if(entityTarget.getTarget() instanceof Avatar){
            EntityTarget target = new EntityTarget(Avatar.getInstance());
            target.setPriority(-1);
            addToTargetList(target);
        }
        updateActiveTarget();
    }

    @Override
    public void updateActiveTarget() {
        setActiveTarget(getHighestPriorityTarget());
    }


}

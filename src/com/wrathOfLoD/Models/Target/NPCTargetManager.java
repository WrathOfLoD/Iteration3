package com.wrathOfLoD.Models.Target;

import com.wrathOfLoD.Models.Entity.Character.NPC;
import com.wrathOfLoD.Models.Items.Item;

/**
 * Created by matthewdiaz on 4/9/16.
 */
public class NPCTargetManager extends TargetManager{
    public NPCTargetManager(){
        super();
    }

    @Override
    public void updateMyList(ItemTarget itemTarget) {
        addToTargetList(itemTarget);
        updateActiveTarget();
    }

    @Override
    public void updateMyList(EntityTarget entityTarget){
        if(entityTarget.getTarget() instanceof NPC){
            if(entityTarget.getTarget().getAggroLevel() == 0){
                addToTargetList(entityTarget);
            }
        }
    }

    @Override
    public void updateActiveTarget() {
        setActiveTarget(getHighestPriorityTarget());
    }

    @Override
    public void deregisterItem(Item i) {
        removeFromTargetList(i);
        updateActiveTarget();
    }
}

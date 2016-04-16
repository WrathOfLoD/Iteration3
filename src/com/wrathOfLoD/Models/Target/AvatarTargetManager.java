package com.wrathOfLoD.Models.Target;

import com.wrathOfLoD.Models.Entity.Character.Pet;
import com.wrathOfLoD.Models.Items.Item;

/**
 * Created by matthewdiaz on 4/9/16.
 */
public class AvatarTargetManager extends TargetManager {
    public AvatarTargetManager(){
        super();
    }

    /**
     * do nothing, avatart target manager doesnt need to know items
     * @param itemTarget
     */
    @Override
    public void updateMyList(ItemTarget itemTarget) {

    }

    @Override
    public void updateActiveTarget() {
        if(getActiveTarget() == null && totalTargets() != 0){
            Target targ = getTargetFromSet(0);
            if(targ.getTarget() instanceof Pet){
                Target temp = getTargetFromSet(1);
                if(temp != null){
                    targ = temp;
                }
            }
        }
        else if(getActiveTarget() != null){
            //do nothing
        }
    }

    /**
     * do nothing we never added items to the avatar target list
     * @param i
     */
    @Override
    public void deregisterItem(Item i) {

    }

    /**
     * gets the highest priority target if active target isn't set, and sets active target to it
     * if it is set cycles to the next highest priority target, and sets active target to it
     */
    public void cycleActiveTarget(){
        if(totalTargets() != 0){
            if(!getActiveTarget().equals(null) && totalTargets() != 1){
                int nextIndex = getIndexofTarget(getActiveTarget()) % (totalTargets() - 1);
                setActiveTarget(getTargetFromSet(nextIndex));
            }
            else{
                setActiveTarget(getHighestPriorityTarget());
            }
        }
        setActiveTarget(null);
    }
}

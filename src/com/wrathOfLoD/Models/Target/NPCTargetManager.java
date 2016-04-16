package com.wrathOfLoD.Models.Target;

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
    }

    @Override
    public void updateActiveTarget() {
        setActiveTarget(getHighestPriorityTarget());
    }

    @Override
    public void deregisterItem(Item i) {
        removeFromTargetList(i);
    }
}

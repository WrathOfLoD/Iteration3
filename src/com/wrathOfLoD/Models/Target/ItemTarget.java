package com.wrathOfLoD.Models.Target;

import com.wrathOfLoD.Models.Items.Item;

/**
 * Created by zach on 4/7/16.
 */
public class ItemTarget extends Target {
    private final Item target;

    public ItemTarget(Item target) {
        setPriority(target.getValue());

        this.target = target;
    }

    public Item getTarget(){
        return target;
    }
}

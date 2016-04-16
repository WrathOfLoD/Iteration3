package com.wrathOfLoD.Models.Target;

import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by zach on 4/7/16.
 */
public class ItemTarget extends Target {
    private final Item target;

    public ItemTarget(Item target, Position pos) {
        setPriority(target.getValue());

        this.target = target;
        setPosition(pos);
    }

    public Item getTarget(){
        return target;
    }
}

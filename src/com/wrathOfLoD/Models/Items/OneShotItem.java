package com.wrathOfLoD.Models.Items;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.VisitorInterfaces.ItemVisitor;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public class OneShotItem extends Item{
    public OneShotItem(String name){ super(name);}

    @Override
    public void encounter(Entity entity){

    }

    public void accept(ItemVisitor iv){
        iv.visitOneshotItem(this);
    }
}

package com.wrathOfLoD.Models.Items;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public class OneShotItem extends Item{

    public OneShotItem(Position position, String name){
        super(position, name);
    }

    @Override
    public void encounter(Entity entity){

    }
}
package com.wrathOfLoD.Models.Items;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public class ObstacleItem extends Item{
    public ObstacleItem(Position position, String name){
        super(position, name);
    }

    @Override
    public void encounter(Entity entity){

    }
}

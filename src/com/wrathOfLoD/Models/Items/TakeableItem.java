package com.wrathOfLoD.Models.Items;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public abstract class TakeableItem extends Item{
    public TakeableItem(Position position, String name){
        super(position, name);
    }

    @Override
    public void encounter(Entity entity){
        ((Character)(entity)).pickUpItem(this);
    }

    public abstract void use(Character character);

}

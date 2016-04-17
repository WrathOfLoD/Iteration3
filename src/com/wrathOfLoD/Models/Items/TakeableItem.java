package com.wrathOfLoD.Models.Items;

import com.wrathOfLoD.Models.Commands.EntityActionCommands.PickUpItemCommand;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Observers.ModelObservers.MapItemObserver;
import com.wrathOfLoD.VisitorInterfaces.ItemVisitor;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public abstract class TakeableItem extends Item{
    public TakeableItem(String name ){super(name);}

    @Override
    public void encounter(Entity entity){
        PickUpItemCommand pickUpItemCommand = new PickUpItemCommand(entity, this);
        pickUpItemCommand.execute();
        System.out.println("PICK UP CALLED?");
        for(MapItemObserver mio : getMapItemObservers()){
            mio.notifyDestroy();
        }
    }

    public abstract void use(Character character);

    public void accept(ItemVisitor iv){
        iv.visitTakeable(this);
    }
}

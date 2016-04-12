package com.wrathOfLoD.VisitorInterfaces;

import com.wrathOfLoD.Models.Inventory.Equipment;
import com.wrathOfLoD.Models.Inventory.Inventory;
import com.wrathOfLoD.Models.Items.EquippableItems.EquippableItem;

/**
 * Created by icavitt on 4/12/2016.
 */
//to use this interface in any useful way you'll likely have to implement the itemvisitor
//interface as well...if we consistently have to do both could add visit takeable here
// along with other needed ones
public interface HeldItemVisitor {

    public void visitInventory(Inventory inventory);
    public void visitEquipment(Equipment equipment);

}

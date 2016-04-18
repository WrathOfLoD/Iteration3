package com.wrathOfLoD.Controllers.InputStates;

import com.wrathOfLoD.Models.Inventory.Equipment;
import com.wrathOfLoD.Models.Inventory.Inventory;

/**
 * Created by echristiansen on 4/18/2016.
 */
public class EquipmentState extends InputState {

    private Equipment equipment;

    public EquipmentState(Equipment equipment) {
        this.equipment = equipment;
        this.setActiveActionSet(equipment.getActionSet());
    }

}

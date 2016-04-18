package com.wrathOfLoD.Models.Commands;

import com.wrathOfLoD.Controllers.InputStates.Action.Action;
import com.wrathOfLoD.Controllers.InputStates.EquipmentState;
import com.wrathOfLoD.Controllers.MainController;
import com.wrathOfLoD.Main;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Inventory.Equipment;

/**
 * Created by zach on 4/18/16.
 */
public class SwitchToEquipmentStateCommand extends ActionCommand {
    private Equipment equipment;
    public SwitchToEquipmentStateCommand(Character e) {
        this.equipment = e.getEquipment();
    }

    @Override
    public void execute() {
        MainController.getInstance().setActiveState(new EquipmentState(equipment));
    }
}

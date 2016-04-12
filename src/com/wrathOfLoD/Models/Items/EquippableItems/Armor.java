package com.wrathOfLoD.Models.Items.EquippableItems;

import com.wrathOfLoD.Models.Commands.EntityActionCommands.EquipItemCommands.EquipArmorCommand;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.EquipItemCommands.EquipItemCommand;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.UnequipItemCommands.UnequipArmorCommand;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.UnequipItemCommands.UnequipItemCommand;
import com.wrathOfLoD.Models.Stats.StatsModifiable;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Models.Entity.Character.Character;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public class Armor extends EquippableItem{

    public Armor(String name, StatsModifiable stats){
        super( name, stats);
    }

    @Override
    protected void equip(Character character){
        EquipItemCommand equipArmorCommand = new EquipArmorCommand(character, this);
        equipArmorCommand.execute();
    }

    @Override
    public void unequip(Character character){
        UnequipItemCommand unequipArmorCommand = new UnequipArmorCommand(character, this);
        unequipArmorCommand.execute();
    }
}

package com.wrathOfLoD.Models.Items.EquippableItems;

import com.wrathOfLoD.Models.Commands.EntityActionCommands.EquipItemCommands.EquipHelmCommand;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.EquipItemCommands.EquipItemCommand;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.UnequipItemCommands.UnequipHelmCommand;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.UnequipItemCommands.UnequipItemCommand;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Stats.StatsModifiable;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/9/16.
 */
public class Helm extends EquippableItem{
    public Helm(String name, StatsModifiable stats){
        super( name, stats);
    }

    public Helm(String name) { // TODO: 4/12/2016 edit this? here for lsp conformance and testing  
        super(name);
    }

    @Override
    protected void equip(Character character){
        EquipItemCommand equipHelmCommand = new EquipHelmCommand(character, this);
        equipHelmCommand.execute();
    }

    @Override
    public void unequip(Character character){
        UnequipItemCommand unequipHelmCommand = new UnequipHelmCommand(character, this);
        unequipHelmCommand.execute();
    }
}
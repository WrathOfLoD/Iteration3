package com.wrathOfLoD.Models.Items.EquippableItems;

import com.wrathOfLoD.Models.Commands.EntityActionCommands.EquipItemCommands.EquipGreavesCommand;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.EquipItemCommands.EquipItemCommand;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.UnequipItemCommands.UnequipGreavesCommand;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.UnequipItemCommands.UnequipItemCommand;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Stats.StatsModifiable;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/9/16.
 */
public class Greaves extends EquippableItem{
    public Greaves(String name, StatsModifiable stats){
        super( name, stats);
    }

    public Greaves(Position position, String name, StatsModifiable stats){
        super(position, name, stats);
    }

    @Override
    protected void equip(Character character){
        EquipItemCommand equipGreavesCommand = new EquipGreavesCommand(character, this);
        equipGreavesCommand.execute();
    }

    @Override
    public void unequip(Character character){
        UnequipItemCommand unequipGreavesCommand = new UnequipGreavesCommand(character, this);
        unequipGreavesCommand.execute();
    }
}
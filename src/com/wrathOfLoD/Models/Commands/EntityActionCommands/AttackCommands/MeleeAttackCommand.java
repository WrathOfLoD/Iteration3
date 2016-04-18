package com.wrathOfLoD.Models.Commands.EntityActionCommands.AttackCommands;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.Tile;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by matthewdiaz on 4/13/16.
 */
public class MeleeAttackCommand extends AttackCommand {
    public MeleeAttackCommand(Character character, int coolDown, int windUp, int skillLevel) {
        super(character, coolDown, windUp, skillLevel);
    }

    @Override
    protected void windUpHook(Position characterPosition, Direction characterFacingDirection, int attackDamage) {
        if(getCharacter().isActive())
            return;

        getCharacter().setActive();
        Position attackedPosition = characterPosition.getPosInDir(characterFacingDirection);
        Tile attackedTile = Map.getInstance().getTile(attackedPosition);
        System.out.println("ATT");

        List<Entity> entities = attackedTile.getEntitiesList();
        for (int i = 0; i < entities.size(); i++){
            entities.get(i).takeDamage(attackDamage);
        }

    }
}

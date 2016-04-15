package com.wrathOfLoD.Models.Commands.EntityActionCommands.AttackCommands;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.Tile;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;

import java.util.Iterator;

/**
 * Created by matthewdiaz on 4/13/16.
 */
public class MeleeAttackCommand extends AttackCommand {
    public MeleeAttackCommand(Character character, int coolDown, int windUp, int skillLevel) {
        super(character, coolDown, windUp, skillLevel);
    }

    @Override
    protected void windUpHook(Position characterPosition, Direction characterFacingDirection, int attackDamage) {
        Position attackedPosition = characterPosition.getPosInDir(characterFacingDirection);
        Tile attackedTile = Map.getInstance().getTile(attackedPosition);
        Iterator<Entity> listOfEntities = attackedTile.getEntities();
        while(listOfEntities.hasNext()){
            Entity entity = listOfEntities.next();
            entity.takeDamage(attackDamage);
        }
    }
}

package com.wrathOfLoD.Models.Ability.Abilities.EnchantmentAbilites;

import com.wrathOfLoD.GameClock.TimeModel;
import com.wrathOfLoD.Models.Ability.Abilities.TimedAbility;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.Tile;
import com.wrathOfLoD.Models.Skill.SummonerSkillManager;
import com.wrathOfLoD.Utility.ModelConfig;
import com.wrathOfLoD.Utility.Position;

import java.util.Iterator;

/**
 * Created by matthewdiaz on 4/18/16.
 */
public abstract class EnchantmentAbility extends TimedAbility {
    private SummonerSkillManager ssm;

    public EnchantmentAbility(Character character, int windup, int coolDown) {
        super(character, windup, coolDown, ModelConfig.getMidManaCost());
        ssm = (SummonerSkillManager) getCharacter().getSkillManager();
    }

    public EnchantmentAbility(int unlockingLevel, Character character, int windup,int coolDown){
        super(unlockingLevel, character, windup, coolDown, ModelConfig.getMidManaCost());
        ssm = (SummonerSkillManager) getCharacter().getSkillManager();
    }

    @Override
    public boolean shouldDoAbility() {
        return checkCanCastAbility(ssm.getEnchantmentLevel());
    }

    protected int calculateAbilityLevelBoost(){
        return 2 * ssm.getEnchantmentLevel();
    }

    protected abstract void doEnchantment(Entity foe);

    @Override
    public void windUpHook(){
        Position foePosition = getCharacter().getPosition().getPosInDir(getCharacter().getDirection());

        Tile foeTile = Map.getInstance().getTile(foePosition);
        Iterator<Entity> iter = foeTile.getEntities();
        while(iter.hasNext()){
            Entity foe = iter.next();
            doEnchantment(foe);
        }
    }
}

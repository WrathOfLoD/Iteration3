package com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SneakWeapons;

import com.wrathOfLoD.Models.Commands.EntityActionCommands.AttackCommands.AttackCommand;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.AttackCommands.MeleeAttackCommand;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.AttackCommands.RangedAttackCommand;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.Weapon;
import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Models.Skill.SkillManager;
import com.wrathOfLoD.Models.Skill.SneakSkillManager;
import com.wrathOfLoD.Models.Stats.StatsModifiable;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public class RangedWeapon extends Weapon implements SneakWeapon {
    public RangedWeapon(String name, StatsModifiable stats, int coolDown, int windUp) {
        super(name, stats, coolDown, windUp);
    }
    @Override
    protected boolean occupationCheckHook(Occupation o) {
        return o.canEquip(this);
    }

    @Override
    protected int getSkillHook(SkillManager skillManager){
        SneakSkillManager smasherSkillManager = (SneakSkillManager)skillManager;
        return smasherSkillManager.getRangedWeaponLevel();
    }


    @Override
    public void attack(Character character, SkillManager skillManager){
        int weaponSkillLevel = getSkillHook(skillManager);
        AttackCommand rangedAttackCommand = new RangedAttackCommand(character, getCoolDown(), getWindUp(), weaponSkillLevel);
        rangedAttackCommand.execute();
    }
}


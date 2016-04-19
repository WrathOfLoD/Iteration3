package com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SneakWeapons;

import com.wrathOfLoD.Models.Commands.EntityActionCommands.AttackCommands.AttackCommand;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.AttackCommands.RangedAttackCommand;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.Weapon;
import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Models.Skill.SkillManager;
import com.wrathOfLoD.Models.Skill.SneakSkillManager;
import com.wrathOfLoD.Models.Stats.StatsModifiable;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public class RangedWeapon extends Weapon implements SneakWeapon {
    private int shootingRange;
    private int travelTimeOfBeam;

    public RangedWeapon(String name, StatsModifiable stats, int coolDown, int windUp) {
        super(name, stats, coolDown, windUp);
        this.shootingRange = 4;
        this.travelTimeOfBeam = 10;
    }

    public RangedWeapon(String name, StatsModifiable stats, int coolDown, int windUp, int shootingRange, int travelTimeOfBeam) {
        super(name, stats, coolDown, windUp);
        this.shootingRange = shootingRange;
        this.travelTimeOfBeam = travelTimeOfBeam;
    }

    public int getShootingRange(){
        return shootingRange;
    }

    public int getTravelTimeOfBeam(){
        return travelTimeOfBeam;
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
        AttackCommand rangedAttackCommand =
                new RangedAttackCommand(
                        character,
                        getCoolDown(),
                        getWindUp(),
                        weaponSkillLevel,
                        getShootingRange(),
                        getTravelTimeOfBeam());

        rangedAttackCommand.execute();
    }
}


package com.wrathOfLoD.Models.Entity.Character;

import com.wrathOfLoD.Controllers.InputStates.Action.Action;
import com.wrathOfLoD.Controllers.InputStates.ActionVendor;
import com.wrathOfLoD.Models.Ability.Abilities.Ability;
import com.wrathOfLoD.Models.ActionsHolder;
import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Commands.ActionCommandVendor;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.DieCommand;
import com.wrathOfLoD.Models.Commands.FogOfWarActionCommands.InvisibleTilesCommand;
import com.wrathOfLoD.Models.Commands.FogOfWarActionCommands.VisibleTilesCommand;
import com.wrathOfLoD.Models.Entity.EntityCanMoveVisitor.TerrestrialCanMoveVisitor;
import com.wrathOfLoD.Models.Inventory.Equipment;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.TwoHandWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.Weapon;
import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Models.Skill.SkillManager;
import com.wrathOfLoD.Models.Stats.StatsModifiable;
import com.wrathOfLoD.Models.Target.AvatarTargetManager;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.VisitorInterfaces.EntityVisitor;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zach on 4/7/16.
 */

public class Avatar extends Character implements ActionsHolder {
    private static Avatar avatar = null;
    private Set<Action> actionSet;

    private Avatar() {
        super();
        setTargetManager(new AvatarTargetManager());
    }

    public static Avatar getInstance(){
        if (avatar == null) {

            avatar = new Avatar();
            avatar.initializeActionSet();
        }

        return avatar;
    }

    public void configureAvatar(String name, Position position, Occupation occupation){
        this.setName(name);
        this.setPosition(position);
        this.setOccupation(occupation);
        SkillManager skillManager = occupation.createSkillManager();
        this.setSkillManager(skillManager);
        Weapon defaultWeapon = occupation.createWeapon();
        this.setEquipment(new Equipment(defaultWeapon));
        setCanMoveVisitor(new TerrestrialCanMoveVisitor());

        StatsModifiable hardinessStatsModifiable = StatsModifiable.createHardinessStatsModifiable(30);
        getStats().modifyStats(hardinessStatsModifiable);
        StatsModifiable healthModifiable = StatsModifiable.createHealthStatsModifiable(getStats().getMaxHealth());
        getStats().modifyStats(healthModifiable);

        StatsModifiable intellect = StatsModifiable.createIntellectStatsModifiable(100);
        getStats().modifyStats(intellect);
        StatsModifiable mana = StatsModifiable.createManaStatsModifiable(getStats().getMaxMana());
        getStats().modifyStats(mana);
    }

    public void configureAvatar(String name, Position position, Occupation occupation, SkillManager skillManager){
        this.setName(name);
        this.setPosition(position);
        this.setOccupation(occupation);
        this.setSkillManager(skillManager);
        Weapon defaultWeapon = occupation.createWeapon();
        this.setEquipment(new Equipment(defaultWeapon));
        setCanMoveVisitor(new TerrestrialCanMoveVisitor());

        StatsModifiable hardinessStatsModifiable = StatsModifiable.createHardinessStatsModifiable(30);
        getStats().modifyStats(hardinessStatsModifiable);
        StatsModifiable healthModifiable = StatsModifiable.createHealthStatsModifiable(getStats().getMaxHealth());
        getStats().modifyStats(healthModifiable);

        StatsModifiable intellect = StatsModifiable.createIntellectStatsModifiable(100);
        getStats().modifyStats(intellect);
        StatsModifiable mana = StatsModifiable.createManaStatsModifiable(getStats().getMaxMana());
        getStats().modifyStats(mana);
    }

	@Override
	public void hideTiles(){
		InvisibleTilesCommand iTC = new InvisibleTilesCommand(getPosition());
		iTC.execute();
	}

	@Override
	public void showTiles(){
		VisibleTilesCommand vTC = new VisibleTilesCommand(getPosition());
		vTC.execute();
	}

    @Override
    public Set<Action> getActionSet() {
        return this.actionSet;
    }

    @Override
    public void initializeActionSet() {
        this.actionSet = new HashSet<>();
        // Add default Avatar Movement actions
        this.addToActionSet(ActionVendor.createMoveNorthAction());
        this.addToActionSet(ActionVendor.createMoveNorthEastAction());
        this.addToActionSet(ActionVendor.createMoveNorthWestAction());
        this.addToActionSet(ActionVendor.createMoveSouthAction());
        this.addToActionSet(ActionVendor.createMoveSouthEastAction());
        this.addToActionSet(ActionVendor.createMoveSouthWestAction());
        // open inventory
        this.addToActionSet(ActionVendor.createOpenInventoryAction(this));
        this.addToActionSet(ActionVendor.createMountAction(this));
        this.addToActionSet(ActionVendor.createAttackAction(this));

//        this.addToActionSet(ActionVendor.createAttackAction(this));
    }

    @Override
    public void setActionSet(Set<Action> actionSet) {
        this.actionSet = actionSet;
    }

    @Override
    public void addToActionSet(Action action) {
        this.actionSet.add(action);
    }

    public void accept(EntityVisitor ev){
        ev.visitAvatar(this);
    }

    @Override
    public void die(){
        ActionCommand dieCommand = new DieCommand(this);
        dieCommand.execute();
        notifyObserversOnDie(this.getPosition());

        System.out.println("LIFES LIVE: "+ getStats().getLivesLeft());
        if(getStats().getLivesLeft() > 0) {
            respawn();
        }

        //todo: Notify GameOver!
    }

    //TODO: need a way to swap ability when equip
    @Override
    public void equipAbility1(Ability ability){
        super.equipAbility1(ability);
        this.addToActionSet(ActionVendor.createFirstAbility(ability));
    }

    public void equipAbility2(Ability ability){
        super.equipAbility2(ability);
        this.addToActionSet(ActionVendor.createSecondAbility(ability));
    }

    public void equipAbility3(Ability ability){
        super.equipAbility3(ability);
        this.addToActionSet(ActionVendor.createThirdAbility(ability));
    }

    public void equipAbility4(Ability ability){
        super.equipAbility4(ability);
        this.addToActionSet(ActionVendor.createFourthAbility(ability));
    }

    public void equipAbility5(Ability ability){
        super.equipAbility5(ability);
        this.addToActionSet(ActionVendor.createFifthAbility(ability));
    }

    public void equipAbility6(Ability ability){
        super.equipAbility6(ability);
        this.addToActionSet(ActionVendor.createSixthAbility(ability));
    }


}

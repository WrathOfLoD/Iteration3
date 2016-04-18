package com.wrathOfLoD.Models.Entity.Character;

import com.wrathOfLoD.Models.Ability.AbilityManager;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Entity.EntityCanMoveVisitor.CanMoveVisitor;
import com.wrathOfLoD.Models.Inventory.Equipment;
import com.wrathOfLoD.Models.Items.EquippableItems.EquippableItem;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.Weapon;
import com.wrathOfLoD.Models.Items.InteractiveItem;
import com.wrathOfLoD.Models.Items.TakeableItem;
import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Models.Occupation.Smasher;
import com.wrathOfLoD.Models.Skill.SkillManager;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.VisitorInterfaces.EntityVisitor;

/**
 * Created by zach on 4/7/16.
 */
public abstract class Character extends Entity {
    private Occupation occupation;
    private Equipment equipment;
    private AbilityManager abilityManager;
    private SkillManager skillManager;



    public Character(){
        super();
        this.occupation = new Smasher();
        Weapon defaultWeapon = this.occupation.createWeapon();
        this.equipment = new Equipment(defaultWeapon);
        this.abilityManager = new AbilityManager(this);
        this.skillManager = this.occupation.createSkillManager();
        this.abilityManager.unlockAbilities(getStats().getLevel());
    }

    public Character(String name, Position position, Occupation occupation, CanMoveVisitor canMoveVisitor){
        super(name,position,canMoveVisitor);
        this.occupation = occupation;
        this.abilityManager = new AbilityManager(this);
        Weapon defaultWeapon = this.occupation.createWeapon();
        this.equipment = new Equipment(defaultWeapon);
        this.abilityManager.unlockAbilities(getStats().getLevel());
        this.skillManager = this.occupation.createSkillManager();
    }

    /***** getter & setter for Character *******/

    public Equipment getEquipment(){ return this.equipment; }

    public Occupation getOccupation(){ return this.occupation; }

    public AbilityManager getAbilityManager(){ return this.abilityManager; }

    public SkillManager getSkillManager(){ return this.skillManager; }

    protected void setOccupation(Occupation newOccupation){ this.occupation = newOccupation; }

    protected void setEquipment(Equipment equipment){ this.equipment = equipment; }

    protected void setSkillManager(SkillManager skillManager){
        this.skillManager = skillManager;
    }

    /********* END Getters and Setters *********/

    //NOTE: interact is only for dialog!!! attack() is for attacking
    public void interact(Entity entity) {
        //you interact with some else
        entity.doInteraction(this);
    }
    public void interact(InteractiveItem item) {
        item.doInteraction(this);
    }

    public void use(TakeableItem item){
        item.use(this);
    }

    public void unequip(EquippableItem item){
        item.unequip(this);
    }

    public void attack() {
        if(!isActive()){
            setActive();
            Weapon currentWeaponEquip = this.equipment.getWeapon();
            currentWeaponEquip.attack(this, this.skillManager);
        }
    }

    public void levelUp(){
        super.levelUp();
        abilityManager.unlockAbilities(getStats().getLevel());
        //occupation.levelUp();
    }

    public void doAbility(int abilityNum){
        if(!isActive()){
            setActive();
            abilityManager.doAbility(abilityNum);
        }
    }

//    public void equipAbility(Ability ability, int abilityNum){
//        abilityManager.setActiveAbility(ability, abilityNum);
//    }

    public void accept(EntityVisitor ev){
        ev.visitCharacter(this);
    }

}


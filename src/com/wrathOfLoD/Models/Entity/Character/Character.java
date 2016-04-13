package com.wrathOfLoD.Models.Entity.Character;

import com.wrathOfLoD.Models.Ability.AbilityManager;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Inventory.Equipment;
import com.wrathOfLoD.Models.Items.ConsumableItems.PermanentConsumable;
import com.wrathOfLoD.Models.Items.ConsumableItems.TemporaryConsumable;
import com.wrathOfLoD.Models.Items.EquippableItems.EquippableItem;
import com.wrathOfLoD.Models.Items.InteractiveItem;
import com.wrathOfLoD.Models.Items.TakeableItem;
import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Models.Occupation.Smasher;
import com.wrathOfLoD.Models.Skill.SkillManager;
import com.wrathOfLoD.Models.Stats.Stats;
import com.wrathOfLoD.Models.Target.TargetManager;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.VisitorInterfaces.EntityVisitor;

/**
 * Created by zach on 4/7/16.
 */
public abstract class Character extends Entity {
    private Occupation occupation;
    private Equipment equipment;
    private TargetManager targetManager;
    private AbilityManager abilityManager;
    private SkillManager skillManager;

    public Character(){
        super();
        this.occupation = new Smasher();
        this.equipment = new Equipment();
        this.targetManager = new TargetManager();
        this.abilityManager = new AbilityManager(getOccupation());
        this.skillManager = this.occupation.createSkillManager();
        this.abilityManager.unlockAbilities(getStats().getLevel());
    }

    public Character(String name, Position position, Occupation occupation){
        super(name,position);
        this.abilityManager = new AbilityManager(getOccupation());
        this.occupation = occupation;
        this.equipment = new Equipment();
        this.targetManager = new TargetManager();
        this.abilityManager.unlockAbilities(getStats().getLevel());
        this.skillManager = this.occupation.createSkillManager();
    }

    /***** getter & setter for Character *******/

    public Equipment getEquipment(){ return this.equipment; }

    public Occupation getOccupation(){ return this.occupation; }

    public TargetManager getTargetManager(){ return this.targetManager; }

    public AbilityManager getAbilityManager(){ return this.abilityManager; }

    public SkillManager getSkillManager(){ return this.skillManager; }

    protected void setOccupation(Occupation newOccupation){ this.occupation = newOccupation; }

    protected void setEquipment(Equipment equipment){ this.equipment = equipment; }

    /********* END Getters and Setters *********/

    public void interact(Entity entity) {}
    public void interact(InteractiveItem item) {}

    public void use(TakeableItem item){
        item.use(this);
    }

    public void unequip(EquippableItem item){
        item.unequip(this);
    }

    public void attack() {}

    public void levelUp(){
        super.levelUp();
        abilityManager.unlockAbilities(getStats().getLevel());
    }

    public void doAbility(int abilityNum){
        abilityManager.doAbility(abilityNum);
    }

    public void accept(EntityVisitor ev){
        ev.visitCharacter(this);
    }

}


package com.wrathOfLoD.Models.Entity.Character;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Inventory.Equipment;
import com.wrathOfLoD.Models.Inventory.Inventory;
import com.wrathOfLoD.Models.Items.InteractiveItem;
import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Models.Occupation.Smasher;
import com.wrathOfLoD.Models.Target.TargetManager;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by zach on 4/7/16.
 */
public abstract class Character extends Entity {
    private Occupation occupation;
    private Equipment equipment;
    private Inventory inventory;
    private TargetManager targetManager;

    public Character(String name, Position position) {
        super(name,position);
        this.occupation = new Smasher();
        this.equipment = new Equipment();
        this.inventory = new Inventory();
        this.targetManager = new TargetManager();
    }

    public Character(String name, Position position, Occupation occupation){
        super(name,position);
        this.occupation = occupation;
        this.equipment = new Equipment();
        this.inventory = new Inventory();
        this.targetManager = new TargetManager();
    }

    public Character(){

    }
    public Equipment getEquipment(){ return this.equipment; }

    public Inventory getInventory(){ return this.inventory; }

    public Occupation getOccupation(){ return this.occupation; }

    public TargetManager getTargetManager(){ return this.targetManager; }

    public void interact(Entity entity) {}
    public void interact(InteractiveItem item) {}

    public void attack() {}

}


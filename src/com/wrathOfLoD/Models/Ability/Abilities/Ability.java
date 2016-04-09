package com.wrathOfLoD.Models.Ability.Abilities;

/**
 * Created by zach on 4/7/16.
 */
public abstract class Ability {

    private int unlockLevel;


    public Ability() {
        setUnlockLevel(0);
    }

    public Ability(int unlockLevel){
        setUnlockLevel(unlockLevel);
    }


    public abstract void doAbility();





    public int getUnlockLevel() {
        return unlockLevel;
    }

    private void setUnlockLevel(int level){
        this.unlockLevel = level;
    }

}

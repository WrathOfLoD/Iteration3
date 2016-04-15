package com.wrathOfLoD.Models.Ability.Abilities;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Entity.Entity;

/**
 * Created by zach on 4/7/16.
 */
public abstract class Ability {

    private int unlockLevel;
    private int manaCost;
    private Character character;

    public Ability(Character character, int manaCost) {
        setUnlockLevel(0);
        this.character = character;
        this.manaCost = manaCost;
    }

    public Ability(int unlockLevel, Character character, int manaCost){
        setUnlockLevel(unlockLevel);
        this.character = character;
        this.manaCost = manaCost;
    }


    public void doAbility(){ //TM
        if(shouldDoAbility()){
            character.loseMana(manaCost);
            doAbilityHook();
        }
    }


    public abstract boolean shouldDoAbility();
    public abstract void doAbilityHook();


    public boolean checkCanCastAbility(int skillLevel){
        int accuIncFactor = 10;
        int accuracy = skillLevel * accuIncFactor; //max = 100
        if(accuracy > 100)
            accuracy = 100;

        int randomNum = (int)(Math.random() * 102) + 1; //generate a randomNum from 1 to 102 -> even at high level, still small chance of failing
        if(randomNum <= accuracy)
            return true;

        return false;
    }


    /********** GETTER & SETTERS ******************/
    public int getUnlockLevel() {
        return unlockLevel;
    }

    private void setUnlockLevel(int level){
        this.unlockLevel = level;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

}

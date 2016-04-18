package com.wrathOfLoD.Models.Ability;

import com.wrathOfLoD.Models.Ability.Abilities.Ability;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Occupation.Occupation;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by zach on 4/7/16.
 */
public class AbilityManager {
    private Character character;
    private Occupation occupation;
    private ArrayList<Ability> unlockedAbilities; //TODO: view should know both unlocked and locked, Controller should only know unlocked
    private ArrayList<Ability> lockedAbilities;
    private int maxNumActiveAbilities = 4;
    private Ability[] activeAbilities = new Ability[maxNumActiveAbilities];
    public Ability[] getActiveAbilities() {
        return activeAbilities;
    }
    public ArrayList<Ability> getUnlockedAbilities() {
        return unlockedAbilities;
    }
    public ArrayList<Ability> getLockedAbilities() {
        return lockedAbilities;
    }

    public AbilityManager(Character character) {
        this.character = character;
        this.occupation = character.getOccupation();
        unlockedAbilities = new ArrayList<>();
        lockedAbilities = new ArrayList<>();
        occupation.addAbilities(this);
        //In Character, after AbilityManager is created, call unlockAbilities on AbilityManager
    }

    public Character getCharacter(){
        return this.character;
    }

    public void unlockAbilities(int characterLevel){
        Iterator<Ability> lockedABIter = lockedAbilities.iterator();
        while(lockedABIter.hasNext()){
            Ability ab = lockedABIter.next();
            if(ab.getUnlockLevel() <= characterLevel){
                unlockedAbilities.add(ab);
                lockedABIter.remove();
            }
        }

        //Notify observer
    }

    public void addAbilities(Ability ability){
        lockedAbilities.add(ability);

        //Notify observer
    }


    //TODO: controller make sure to only able to let user cursor loop through the unlockedAbilityList
    public boolean setActiveAbility(Ability ability, int abilityNum){
        //if(!unlockedAbilities.contains(ability) && abilityNum > maxNumActiveAbilities)
        //    return false;

        if(abilityNum >= maxNumActiveAbilities)
            return false;

        activeAbilities[abilityNum] = ability;
        return true;
    }


    public void doAbility(int abilityNum){
        if(abilityNum < maxNumActiveAbilities)
            activeAbilities[abilityNum].doAbility();
    }
}

package com.wrathOfLoD.Models.Ability;

import com.wrathOfLoD.Models.Ability.Abilities.Ability;
import com.wrathOfLoD.Models.Occupation.Occupation;

import java.util.ArrayList;

/**
 * Created by zach on 4/7/16.
 */
public class AbilityManager {
    private Occupation occupation;

    private ArrayList<Ability> unlockedAbilities;
    private ArrayList<Ability> lockedAbilities;

    private Ability[] activeAbilities = new Ability[4];

    public AbilityManager(Occupation occupation) {
        this.occupation = occupation;
        unlockedAbilities = new ArrayList<>();
        lockedAbilities = new ArrayList<>();
        occupation.addAbilities(this);
        //In Character, after AbilityManager is created, call unlockAbilities on AbilityManager
    }

    







}

package com.wrathOfLoD.Models.Occupation;

import com.wrathOfLoD.Models.Stats.Stats;

/**
 * Created by zach on 4/7/16.
 */
public abstract class Occupation {
//    public StatsAddable statsAddable;

    public Occupation() {}

//    public boolean canEquip(SmasherWeapon weapon) {}
//    public boolean canEquip(SneakWeapon weapon) {}
//    public boolean canEquip(SummonerWeapon weapon) {}
    public void levelUp(Stats stats) {}
}

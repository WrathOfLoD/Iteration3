package com.wrathOfLoD.GameLaunching.Vendors;

import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SummonerWeapons.StaffWeapon;
import com.wrathOfLoD.Models.Stats.StatsModifiable;

/**
 * Created by luluding on 4/15/16.
 */
public class ItemVendor {

    public StaffWeapon createTestStaff(){
        return new StaffWeapon("Stafffff", StatsModifiable.createWeaponBonusStatsModifiable(1), 2, 5);
    }


}

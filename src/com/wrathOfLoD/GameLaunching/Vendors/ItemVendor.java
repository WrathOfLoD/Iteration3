package com.wrathOfLoD.GameLaunching.Vendors;

import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.TwoHandWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SummonerWeapons.StaffWeapon;
import com.wrathOfLoD.Models.LocationTracker.LocationTracker;
import com.wrathOfLoD.Models.LocationTracker.LocationTrackerManager;
import com.wrathOfLoD.Models.Map.MapArea;
import com.wrathOfLoD.Models.Stats.StatsModifiable;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by luluding on 4/15/16.
 */
public class ItemVendor {

    public static StaffWeapon createTestStaff(){
        return new StaffWeapon("Stafffff", StatsModifiable.createWeaponBonusStatsModifiable(1), 2, 5);
    }

    public static TwoHandWeapon createHammer(MapArea ma, Position position){
        TwoHandWeapon hammer = new TwoHandWeapon("hammer");
        ma.addItem(hammer, position);
        LocationTrackerManager.getInstance().registerItem(hammer,ma,position);
        return hammer;
    }

}

package com.wrathOfLoD.Views.StatsView;

import com.wrathOfLoD.Models.Stats.Stats;

import java.util.ArrayList;

/**
 * Created by echristiansen on 4/13/2016.
 */
public class StatsViewObjectFactory {

    public static ArrayList<StatsViewObject> generateStatsViewObjects(Stats stats) {
        ArrayList<StatsViewObject> svoList = new ArrayList<>();
        StatsViewObject svo;

        svo = new StatsViewObject("Level", stats.getLevel());
        svoList.add(svo);

        svo = new StatsViewObject("Max Health", stats.getMaxHealth());
        svoList.add(svo);

        svo = new StatsViewObject("Max Mana", stats.getMaxMana());
        svoList.add(svo);
        //base stats

        //strength
        svo = new StatsViewObject("Strength", stats.getStrength());
        svoList.add(svo);
        //agility
        svo = new StatsViewObject("Agility", stats.getAgility());
        svoList.add(svo);
        //
        svo = new StatsViewObject("Intellect", stats.getIntellect());
        svoList.add(svo);
        //

        svo = new StatsViewObject("Hardiness", stats.getHardiness());
        svoList.add(svo);

        svo = new StatsViewObject("Movement", stats.getMovement());
        svoList.add(svo);

        svo = new StatsViewObject("Offensive Rating", stats.getOffensiveRating());
        svoList.add(svo);
        //defensive rating
        svo = new StatsViewObject("Defensive Rating", stats.getDefensiveRating());
        svoList.add(svo);
        //Armor rating
        svo = new StatsViewObject("Armor Rating", stats.getArmorRating());
        svoList.add(svo);
        //life

        return svoList;

    }
}

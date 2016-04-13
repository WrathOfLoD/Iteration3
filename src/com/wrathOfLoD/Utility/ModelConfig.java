package com.wrathOfLoD.Utility;

/**
 * Created by luluding on 4/12/16.
 */
public class ModelConfig {

    private static final int AVATAR_VISIBLE_RADIUS = 5;
    private static final int LOW_MANA_COST = 2;
    private static final int MID_MANA_COST = 4;
    private static final int HIGH_MANA_COST = 6;



    public static int getAvatarVisibleRadius(){
        return AVATAR_VISIBLE_RADIUS;
    }

    public static int getLowManaCost(){
        return LOW_MANA_COST;
    }

    public static int getMidManaCost(){
        return MID_MANA_COST;
    }

    public static int getHighManaCost(){
        return HIGH_MANA_COST;
    }

}

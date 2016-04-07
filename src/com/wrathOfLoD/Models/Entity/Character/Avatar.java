package com.wrathOfLoD.Models.Entity.Character;

import com.wrathOfLoD.Utility.Direction;

/**
 * Created by zach on 4/7/16.
 */
public class Avatar extends Character {
    private static Avatar instance = new Avatar();

    private Avatar(){
    }
    public static Avatar getInstance(){
        return instance;
    }

    
}

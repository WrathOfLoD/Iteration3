package com.wrathOfLoD.Models.Entity.Character;

import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Models.Occupation.Smasher;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by zach on 4/7/16.
 */

public class Avatar extends Character {
    private static Avatar avatar = null;

    private Avatar(){
        super("Master Chief", new Position(0,0,0,0), new Smasher());
    }

    public static Avatar getInstance(){
        if(avatar == null)
            avatar = new Avatar();

        return avatar;
    }

    public void avatarInit(String name, Position position, Occupation occupation){
        this.setName(name);
        this.setPosition(position);
        this.setOccupation(occupation);
    }
}

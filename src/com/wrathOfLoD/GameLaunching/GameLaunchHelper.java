package com.wrathOfLoD.GameLaunching;

import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Map.Map;

/**
 * Created by icavitt on 4/12/2016.
 */
public abstract class GameLaunchHelper {
    private LevelFactory levelFactory;
    //no area view amanger been created yet so this is commented out
//    public areaViewManager getAreaViewManager();

    public abstract Map createMap();
    public abstract Avatar createAvatar();
    public abstract void populateMap();

    public LevelFactory getLevelFactory(){
        return levelFactory;
    }

    public void setLevelFactory(LevelFactory lv){
        levelFactory = lv;
    }
}

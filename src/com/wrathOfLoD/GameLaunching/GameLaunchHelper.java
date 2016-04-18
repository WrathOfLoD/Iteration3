package com.wrathOfLoD.GameLaunching;

import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.MapArea;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.AreaView.AreaView;

/**
 * Created by icavitt on 4/12/2016.
 */
public abstract class GameLaunchHelper {
    private LevelFactory levelFactory;

    public abstract Map createMap();
    public abstract AreaView getAreaView();
    public abstract Avatar createAvatar();
    public abstract void populateMap();
    public abstract void setActiveCameraView(MapArea mapArea);

    public LevelFactory getLevelFactory(){
        return levelFactory;
    }


    public void setLevelFactory(LevelFactory lv){
        levelFactory = lv;
    }
}

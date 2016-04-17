package com.wrathOfLoD.GameLaunching;

import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Views.AreaView.AreaView;

/**
 * Created by icavitt on 4/12/2016.
 */
public class NewGameHelper extends GameLaunchHelper{

    public NewGameHelper(){
        setLevelFactory(new LevelFactory("test_map"));
    }

    @Override
    public Map createMap() {
        getLevelFactory().generateMap();
        return Map.getInstance();
    }

    @Override
    public AreaView getAreaView() {
        return getLevelFactory().getAreaView();
    }

    @Override
    public Avatar createAvatar() {
        return Avatar.getInstance();
    }

    public void populateMap(){
        getLevelFactory().populateMap();
    }

}

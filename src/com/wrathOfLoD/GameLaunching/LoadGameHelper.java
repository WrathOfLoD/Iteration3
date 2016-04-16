package com.wrathOfLoD.GameLaunching;

import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.SaveLoad.Loader;

/**
 * Created by icavitt on 4/12/2016.
 */

public class LoadGameHelper extends GameLaunchHelper {
    private String saveFile;
    private Loader loader;
    LoadGameHelper(String saveFile){
        loader = new Loader(saveFile);
        setLevelFactory(new LevelFactory(loader.getLevelName()));
    }

    @Override
    public Map createMap() {
        getLevelFactory().generateMap();
        return Map.getInstance();
    }
    //this should be called after populateMap, the load function will handle properly creat
    //ing avatar in this case
    @Override
    public Avatar createAvatar() {
        return Avatar.getInstance();
    }

    @Override
    public void populateMap() {
        loader.load(Map.getInstance());
    }
}

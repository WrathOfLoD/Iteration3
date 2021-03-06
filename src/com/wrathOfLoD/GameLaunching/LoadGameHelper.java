package com.wrathOfLoD.GameLaunching;

import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.MapArea;
import com.wrathOfLoD.SaveLoad.Loader;
import com.wrathOfLoD.Views.AreaView.AreaView;

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

    @Override
    public AreaView getAreaView() {
        return null;
    }


    @Override
    public Avatar createAvatar() {
        return Avatar.getInstance();
    }

    @Override
    public void populateMap() {
        loader.load(Map.getInstance());
    }

    @Override
    public void setActiveCameraView(MapArea mapArea) {
        getLevelFactory().setActiveCV(mapArea); //TODO: is this right for load?
    }
}

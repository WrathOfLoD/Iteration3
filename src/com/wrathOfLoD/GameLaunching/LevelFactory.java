package com.wrathOfLoD.GameLaunching;

import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Views.AreaView.AreaView;

/**
 * Created by icavitt on 4/12/2016.
 */
public class LevelFactory {
    private Map map;
//    dont have areaviewmanager created yet so this is commented for the moment
//    private AreaViewManager avm;
    private String levelName;

    public LevelFactory(String levelName){
        this.levelName = levelName;
    }

    public void generateMap(){
        switch (levelName){
            case "test_map" :
                createTestMap();
                break;
            default:
                System.out.println("The map you are requesting doesnt exist");
        }
    }

    public void populateMap(){
        switch (levelName){
            case "test_map" :
                populateTestMap();
                break;
            default:
                System.out.println("The map you are requesting to populate doesn't exist");
        }
    }
    //not set yet add to this as wanted for putting things on test map
    private void populateTestMap() {




    }
    //not set yet add to this as wanted for creating the map ,mapareas, and the tiles in them as well as area effects or other static things that will be on the map
    private void createTestMap() {



    }
}

package com.wrathOfLoD.SaveLoad;

import com.wrathOfLoD.Models.Map.Map;

/**
 * Created by icavitt on 4/12/2016.
 */
public class Loader {
    private String fileName;

    public Loader(String fileName){
        this.fileName = fileName;
    }

    // will be used for getting the name of the level saved later, may not be needed
    //for now just returns test_map
    public String getLevelName(){
        return "test_map";
    }
//    this will go through the save file and add to the map everything that should be on it
//    with the proper state
    public void load(Map map){

    }
}

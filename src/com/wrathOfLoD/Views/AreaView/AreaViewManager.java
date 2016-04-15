package com.wrathOfLoD.Views.AreaView;

import com.wrathOfLoD.Models.Map.MapArea;


import java.util.HashMap;

/**
 * Created by luluding on 4/15/16.
 */
public class AreaViewManager {

    private HashMap<MapArea, AreaView> areaViewList;
    private AreaView activeAE;

    public AreaViewManager(){
        areaViewList = new HashMap<>();
    }

    public void addAreaView(MapArea ma, AreaView ae){
        areaViewList.put(ma, ae);
    }

    public void setActiveAE(MapArea ma){
        activeAE = areaViewList.get(ma);
    }

    public AreaView getActiveAE(){
        return activeAE;
    }

}

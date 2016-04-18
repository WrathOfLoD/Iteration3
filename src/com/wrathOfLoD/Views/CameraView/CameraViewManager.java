package com.wrathOfLoD.Views.CameraView;

import com.wrathOfLoD.Models.Map.MapArea;
import com.wrathOfLoD.Views.AreaView.AreaView;

import java.util.HashMap;

/**
 * Created by luluding on 4/16/16.
 */
public class CameraViewManager {

    private HashMap<MapArea, CameraView> cameraViewList;
    private CameraView activeCV;

    public CameraViewManager(){
        cameraViewList = new HashMap<>();
    }

    public void addCameraView(MapArea ma, CameraView cv){
        cameraViewList.put(ma, cv);
    }

    public void setActiveCV(MapArea ma){
        activeCV = cameraViewList.get(ma);
    }

    public CameraView getActiveCV(){
        return activeCV;
    }

    public CameraView getCV(MapArea mapArea){
        return cameraViewList.get(mapArea);
    }

}

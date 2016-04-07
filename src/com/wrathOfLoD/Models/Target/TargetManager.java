package com.wrathOfLoD.Models.Target;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zach on 4/7/16.
 */
public class TargetManager {
    private Target activeTarget;
    private Set<Target> targetSet;

    public TargetManager() {
        this.targetSet = new LinkedHashSet<>();
    }

    public Target getActiveTarget() {
        return this.activeTarget;
    }

    /**
     * @desc Register this TM with the LocTrack
     */
    public void registerWithLocationTracker() {

    }

    // TODO: 4/7/16 Add MapItem here when implemented
    /**
     * @desc Add new lists of Targets/MapItems to our list
     * @param tList - List of targets
     * @param mList - List of MapItems
     */
//    public void updateMyList(List<Target> tList, List<MapItem> mList) {
//    }


}

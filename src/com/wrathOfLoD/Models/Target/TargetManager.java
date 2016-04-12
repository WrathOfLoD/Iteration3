package com.wrathOfLoD.Models.Target;

import com.wrathOfLoD.Models.Items.Item;

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

    /**
     * @desc Add new lists of Targets/Items to our list
     * @param tList - List of targets
     * @param mList - List of Items
     */
    public void updateMyList(List<Target> tList, List<Item> mList) {
    }


}

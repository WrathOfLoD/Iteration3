package com.wrathOfLoD.Models.Target;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Models.LocationTracker.LocationTrackerManager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zach on 4/7/16.
 */
public abstract class TargetManager {
    private Target activeTarget;
    private TargetOrderedList targetSet;

    public TargetManager() {
        this.targetSet = new TargetOrderedList();
    }

    public Target getActiveTarget() {
        return this.activeTarget;
    }

    /**
     * @desc Register this TM with the LocTrack
     */
    public void registerWithLocationTracker() {
    }

    public abstract void updateMyList(ItemTarget itemTarget);

    public void updateMyList(EntityTarget entityTarget){
        addToTargetList(entityTarget);
        updateActiveTarget();
    }

    /**
     * this automatically updates the active target of the target manager
     */
    public abstract void updateActiveTarget();
    public abstract void deregisterItem(Item i);

    public void deregisterEntity(Entity e){
        removeFromTargetList(e);
        if(e.equals(getActiveTarget())){
            setActiveTarget(null);
            updateActiveTarget();
        }
    }
    protected void setActiveTarget(Target target){
        activeTarget = target;
    }
    protected void addToTargetList(Target target){
        targetSet.add(target);
    }
//    protected void removeFromTargetList(Target target){
//        targetSet.remove(target);
////    }
    protected void removeFromTargetList(Entity e){
        targetSet.remove(e);
    }
    protected void removeFromTargetList(Item i){
        targetSet.remove(i);
    }
    protected Target getHighestPriorityTarget(){
        return targetSet.getFront();
    }
    protected Target getTargetFromSet(int i){
        return targetSet.getTarget(i);
    }
    protected int totalTargets(){
        return targetSet.size();
    }
    protected int getIndexofTarget(Target t){
        return targetSet.getIndex(t);
    }
    /**
     * custom class to keep track of targets
     */
    private class TargetOrderedList{
        ArrayList<Target> targetList = new ArrayList<>();

        /**
         * If there is an element in the list return the one with the highest priority
         * else returns null
         * @return
         */
        public Target getFront(){
            if(targetList.get(0) != null)
                return targetList.get(0);
            return null;
        }

        /**
         * if there are at least 3 elements in the list returns the an array with the ones with the highest priority
         * if there are less than 3 elements in the list array size is equal to the number of elements it returns
         * if there are no elements in it returns null
         * @return
         */
        public Target[] getFrontThree(){
            if(targetList.size() >= 3){
                Target[] targets = new Target[3];
                for(int i = 0; i != 3; ++i){
                    targets[i] = targetList.get(i);
                }
                return targets;
            }
            else if(targetList.size() > 0){
                return targetList.toArray(new Target[targetList.size()]);
            }
            else{
                return null;
            }
        }

        /**
         * if the element at the specified index exits returns it
         * if it doesn't return null
         * @param i
         * @return
         */
        public Target getTarget(int i){
            if(targetList.get(i) != null){
                return targetList.get(i);
            }
            return null;
        }

        /**
         * removes the specified target from the list if it exists
         * @param target
         */

        /**
         * the following remove all the targets that reference the entity or item from the list if they exist
         * @param e
         */
        public void remove(Entity e){
            for(Target t : targetList){
                if(t.getTarget().equals(e)){
                    targetList.remove(t);
                }
            }
        }
        public void remove(Item i){
            for(Target t : targetList){
                if(t.getTarget().equals(i)){
                    targetList.remove(t);
                }
            }
        }

        /**
         * adds the target to the list iff the item or entity the target references isn't already referenced by another target in the list
         * basically prevents duplicate targets being added to the list but equality is decided but the thing they reference
         * @param target
         */
        public void add(Target target){
            boolean existsAlready = false;
            for(Target t : targetList){
                if(t.getTarget().equals(target.getTarget())){
                    t.setPosition(target.getPosition());
                    return;
                }
            }
            for(int i = 0; i != targetList.size(); ++i){
                if(target.getPriority() >= targetList.get(i).getPriority()){
                    targetList.add(i,target);
                    return;
                }
            }
            targetList.add(target);
        }

        /**
         * returns the size of the list
         * @return
         */
        public int size(){
            return targetList.size();
        }

        public int getIndex(Target t){
            return targetList.indexOf(t);
        }
    }
}

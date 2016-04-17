package com.wrathOfLoD.Models.Skill;

/**
 * Created by luluding on 4/7/16.
 */
public class SneakSkillManager extends SkillManager {
    private Skill pickPocket;
    private Skill removeTrap;
    private Skill detectTrap;
    private Skill creep;
    private Skill rangedWeapon;

    public SneakSkillManager(){
        super();
        pickPocket = new Skill(getDefaultSkillLevel());
        detectTrap = new Skill(getDefaultSkillLevel());
        removeTrap = new Skill(getDefaultSkillLevel());
        creep = new Skill(getDefaultSkillLevel());
        rangedWeapon = new Skill(getDefaultSkillLevel());
    }

    public SneakSkillManager(int bindWoundsLevel, int bargainLevel, int observationLevel, int pickPocketLevel, int removeTrapLevel, int detectTrapLevel, int creepLevel, int rangedWeaponLevel){
        super(bindWoundsLevel, bargainLevel, observationLevel);
        pickPocket = new Skill(pickPocketLevel);
        detectTrap = new Skill(detectTrapLevel);
        removeTrap = new Skill(removeTrapLevel);
        creep = new Skill(creepLevel);
        rangedWeapon = new Skill(rangedWeaponLevel);
    }


    /***** getter & setter for skills *******/

    public int getPickPocketLevel(){
        return pickPocket.getSkillLevel();
    }

    public int getDetectTrapLevel(){ return detectTrap.getSkillLevel(); }

    public int getRemoveTrapLevel(){
        return removeTrap.getSkillLevel();
    }

    public int getCreepLevel(){
        return creep.getSkillLevel();
    }

    public int getRangedWeaponLevel(){
        return rangedWeapon.getSkillLevel();
    }

    public boolean updatePickPocketLeve(int level){
        if(!updateAvailableSkillPoints(level))
            return false;

        pickPocket.updateSkillLevel(level);
        return true;
    }

    public boolean updateRemoveTrapLeve(int level){
        if(!updateAvailableSkillPoints(level))
            return false;

        removeTrap.updateSkillLevel(level);
        return true;
    }

    public boolean updateCreepLevel(int level){
        if(!updateAvailableSkillPoints(level))
            return false;

        creep.updateSkillLevel(level);
        return true;
    }

    public boolean updateRangedWeaponLevel(int level){
        if(!updateAvailableSkillPoints(level))
            return false;

        rangedWeapon.updateSkillLevel(level);
        return true;
    }

    /****************************************/


}

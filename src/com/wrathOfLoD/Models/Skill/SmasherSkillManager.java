package com.wrathOfLoD.Models.Skill;

/**
 * Created by luluding on 4/7/16.
 */
public class SmasherSkillManager extends SkillManager{

    private Skill oneHandedWeapon;
    private Skill twoHandedWeapon;
    private Skill brawling;

    public SmasherSkillManager(){
        super();
        oneHandedWeapon = new Skill(getDefaultSkillLevel());
        twoHandedWeapon = new Skill(getDefaultSkillLevel());
        brawling = new Skill(getDefaultSkillLevel());
    }

    public SmasherSkillManager(int bindWoundsLevel, int bargainLevel, int observationLevel, int oneHandedWeaponLevel, int twoHandedWeaponLevel, int brawlingLevel){
        super(bindWoundsLevel, bargainLevel, observationLevel);
        oneHandedWeapon = new Skill(oneHandedWeaponLevel);
        twoHandedWeapon = new Skill(twoHandedWeaponLevel);
        brawling = new Skill(brawlingLevel);
    }

    /***** getter & setter for skills *******/

    public int getOneHandedLevel(){
        return oneHandedWeapon.getSkillLevel();
    }

    public int getTwoHandedLevel(){
        return twoHandedWeapon.getSkillLevel();
    }

    public int getBrawlingLevel(){
        return brawling.getSkillLevel();
    }

    public boolean updateOneHandedLevel(int level){
        if(!updateAvailableSkillPoints(level))
            return false;

        oneHandedWeapon.updateSkillLevel(level);
        return true;
    }

    public boolean updateTwoHandedLevel(int level){
        if(!updateAvailableSkillPoints(level))
            return false;

        twoHandedWeapon.updateSkillLevel(level);
        return true;
    }

    public boolean updateBrawlingLevel(int level){
        if(!updateAvailableSkillPoints(level))
            return false;

        brawling.updateSkillLevel(level);
        return true;
    }

    /****************************************/






}

package com.wrathOfLoD.Models.Skill;

/**
 * Created by luluding on 4/7/16.
 */
public class SummonerSkillManager extends SkillManager {

    private Skill enchantment;
    private Skill boon;
    private Skill bane;
    private Skill staff;

    public SummonerSkillManager(){
        super();
        enchantment = new Skill(getDefaultSkillLevel());
        boon = new Skill(getDefaultSkillLevel());
        bane = new Skill(getDefaultSkillLevel());
        staff = new Skill(getDefaultSkillLevel());
    }

    public SummonerSkillManager(int bindWoundsLevel, int bargainLevel, int observationLevel, int enchantmentLevel, int boonLevel, int baneLevel, int staffLevel){
        super(bindWoundsLevel, bargainLevel, observationLevel);
        enchantment = new Skill(enchantmentLevel);
        boon = new Skill(boonLevel);
        bane = new Skill(baneLevel);
        staff = new Skill(staffLevel);
    }

    /***** getter & setter for skills *******/

    public int getEnchantmentLevel(){
        return enchantment.getSkillLevel();
    }

    public int getBoonLevel(){
        return boon.getSkillLevel();
    }

    public int getBaneLevel(){
        return bane.getSkillLevel();
    }

    public int getStaffLevel(){
        return staff.getSkillLevel();
    }

    public boolean updateEnchantmentLevel(int level){
        if(!updateAvailableSkillPoints(level))
            return false;

        enchantment.updateSkillLevel(level);
        return true;
    }

    public boolean updateBoonLevel(int level){
        if(!updateAvailableSkillPoints(level))
            return false;

        boon.updateSkillLevel(level);
        return true;
    }

    public boolean updateBaneLevel(int level){
        if(!updateAvailableSkillPoints(level))
            return false;

        bane.updateSkillLevel(level);
        return true;
    }

    public boolean updateStaffLevel(int level){
        if(!updateAvailableSkillPoints(level))
            return false;

        staff.updateSkillLevel(level);
        return true;
    }

    /****************************************/

}

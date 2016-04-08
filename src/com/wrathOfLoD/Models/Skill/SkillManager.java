package com.wrathOfLoD.Models.Skill;

import com.sun.tools.internal.ws.wsdl.document.schema.SchemaKinds;

/**
 * Created by luluding on 4/7/16.
 */
public abstract class SkillManager {
    private int availableSkillPoints = 5; //default

    private int defaultSkillLevel = 1;

    //shared skills
    private Skill bindWounds;
    private Skill bargain;
    private Skill observation;

    public SkillManager(){
        bindWounds = new Skill(defaultSkillLevel);
        bargain = new Skill(defaultSkillLevel);
        observation = new Skill(defaultSkillLevel);
    }

    public SkillManager(int bindWoundsLevel, int bargainLevel, int observationLevel){
        bindWounds = new Skill(bindWoundsLevel);
        bargain = new Skill(bargainLevel);
        observation = new Skill(observationLevel);
    }


    protected boolean updateAvailableSkillPoints(int spWanted){
        if(spWanted > availableSkillPoints)
            return false;

        this.availableSkillPoints -= spWanted;
        return true;
    }


    /***** getter & setter for skills *******/

    public int getBindWoundsLevel(){
        return bindWounds.getSkillLevel();
    }

    public int getBargainLevel(){
        return bargain.getSkillLevel();
    }

    public int getObservationLevel(){
        return observation.getSkillLevel();
    }

    public boolean updateBindWoundsLevel(int level){
        if(!updateAvailableSkillPoints(level))
            return false;

        bindWounds.updateSkillLevel(level);
        return true;
    }

    public boolean updateBargainLevel(int level){
        if(!updateAvailableSkillPoints(level))
            return false;

        bargain.updateSkillLevel(level);
        return true;
    }

    public boolean updateObservationLevel(int level){
        if(!updateAvailableSkillPoints(level))
            return false;

        observation.updateSkillLevel(level);
        return true;
    }

    /****************************************/



    public int getAvailableSkillPoints(){
        return availableSkillPoints;
    }

    public void gainSkillPoints(int skillPoints){
        availableSkillPoints += skillPoints;
    }

    protected int getDefaultSkillLevel(){
        return defaultSkillLevel;
    }

}

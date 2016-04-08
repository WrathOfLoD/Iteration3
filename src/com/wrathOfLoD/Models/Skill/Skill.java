package com.wrathOfLoD.Models.Skill;

/**
 * Created by luluding on 4/7/16.
 */
public class Skill {
    private int skillLevel;

    public Skill(int skillLevel){
        this.skillLevel = skillLevel;
    }

    public int getSkillLevel(){
        return skillLevel;
    }

    public void updateSkillLevel(int skillPoint){
        skillLevel += skillPoint;
    }

}

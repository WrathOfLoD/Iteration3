package com.wrathOfLoD.Models.Ability.Abilities;

import com.wrathOfLoD.Models.Entity.Entity;

/**
 * Created by zach on 4/7/16.
 */
public abstract class Ability {

    private int unlockLevel;
    private int windup;
    private int coolDown; //total time it takes to do the ability
    private int manaCost;
    private Entity entity;


    public Ability(Entity entity, int windup,int coolDown, int manaCost) {
        setUnlockLevel(0);
        this.entity = entity;
        this.windup = windup;
        this.coolDown = coolDown;
        this.manaCost = manaCost;
    }

    public Ability(int unlockLevel, Entity entity, int windup,int coolDown, int manaCost){
        setUnlockLevel(unlockLevel);
        this.entity = entity;
        this.windup = windup;
        this.coolDown = coolDown;
        this.manaCost = manaCost;
    }


    public abstract void doAbility();



    /********** GETTER & SETTERS ******************/
    public int getUnlockLevel() {
        return unlockLevel;
    }

    private void setUnlockLevel(int level){
        this.unlockLevel = level;
    }

    public int getWindup() {
        return windup;
    }

    public void setWindup(int windup) {
        this.windup = windup;
    }

    public int getCoolDown() {
        return coolDown;
    }

    public void setCoolDown(int coolDown) {
        this.coolDown = coolDown;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

}

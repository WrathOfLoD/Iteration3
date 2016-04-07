package com.wrathOfLoD.Models.Stats;

/**
 * Created by luluding on 4/7/16.
 */
public class StatsModifiable {

    private int strength;
    private int agility;
    private int intellect;
    private int hardiness;
    private int movement;
    private int currentMana;
    private int currentHealth;

    public StatsModifiable(){

    }

    //can either use this constructor to pass in interested stats or can use the setters to set specific stats
    public StatsModifiable(int strength, int agility, int intellect, int hardiness, int movement, int currentMana, int currentHealth){
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
        this.hardiness = hardiness;
        this.movement = movement;
        this.currentMana = currentMana;
        this.currentHealth = currentHealth;
    }


    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public int getHardiness() {
        return hardiness;
    }

    public void setHardiness(int hardiness) {
        this.hardiness = hardiness;
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }
}

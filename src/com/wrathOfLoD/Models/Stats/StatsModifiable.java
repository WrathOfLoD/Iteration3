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
    private int weaponBonus;
    private int armorBonus;
    private int currentExperience;

    private StatsModifiable(int strength, int agility, int intellect, int hardiness, int movement, int currentMana, int currentHealth, int weaponBonus, int armorBonus, int currentExperience){
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
        this.hardiness = hardiness;
        this.movement = movement;
        this.currentMana = currentMana;
        this.currentHealth = currentHealth;
        this.weaponBonus = weaponBonus;
        this.armorBonus = armorBonus;
        this.currentExperience = currentExperience;
    }


    /************** static methods *****************/
    public static StatsModifiable createStrengthStatsModifiable(int strength){
        return new StatsModifiable(strength,0,0,0,0,0,0,0,0,0);
    }

    public static StatsModifiable createAgilityStatsModifiable(int agility){
        return new StatsModifiable(0,agility,0,0,0,0,0,0,0,0);
    }

    public static StatsModifiable createIntellectStatsModifiable(int intellect){
        return new StatsModifiable(0,0,intellect,0,0,0,0,0,0,0);
    }

    public static StatsModifiable createHardinessStatsModifiable(int hardiness){
        return new StatsModifiable(0,0,0,hardiness,0,0,0,0,0,0);
    }

    public static StatsModifiable createMovementStatsModifiable(int movement){
        return new StatsModifiable(0,0,0,0,movement,0,0,0,0,0);
    }

    public static StatsModifiable createManaStatsModifiable(int mana){
        return new StatsModifiable(0,0,0,0,0,mana,0,0,0,0);
    }

    public static StatsModifiable createHealthStatsModifiable(int health){
        return new StatsModifiable(0,0,0,0,0,0,health,0,0,0);
    }

    public static StatsModifiable createWeaponBonusStatsModifiable(int weaponBonus){
        return new StatsModifiable(0,0,0,0,0,0,0,weaponBonus,0,0);
    }

    public static StatsModifiable createArmorBonusStatsModifiable(int armorBonus){
        return new StatsModifiable(0,0,0,0,0,0,0,0,armorBonus,0);
    }

    public static StatsModifiable createExperienceStatsModifiable(int exp){
        return new StatsModifiable(0,0,0,0,0,0,0,0,0,exp);
    }

    public static StatsModifiable createGenericStatsModifiable(int strength, int agility, int intellect, int hardiness, int movement){
        return new StatsModifiable(strength, agility, intellect, hardiness, movement,0,0,0,0,0);
    }

    public static StatsModifiable createHealthManaStatsModifiable(int mana, int health){
        return new StatsModifiable(0,0,0,0,0,mana,health,0,0,0);
    }

    public static StatsModifiable createWeaponArmorStatsModifiable(int weaponBonus, int armorBonus){
        return new StatsModifiable(0,0,0,0,0,0,0,weaponBonus,armorBonus,0);
    }
    /************** end static methods *****************/




    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntellect() {
        return intellect;
    }

    public int getHardiness() {
        return hardiness;
    }

    public int getMovement() {
        return movement;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getWeaponBonus() {
        return weaponBonus;
    }

    public int getArmorBonus() {
        return armorBonus;
    }

    public int getCurrentExperience(){
        return currentExperience;
    }


}

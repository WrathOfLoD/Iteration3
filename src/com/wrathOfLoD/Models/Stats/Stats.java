package com.wrathOfLoD.Models.Stats;

import com.wrathOfLoD.Models.Entity.Entity;

import java.util.ArrayList;

/**
 * Created by luluding on 4/7/16.
 */
public class Stats {
    private Entity owner;


    //Primary Stats
    private int strength;
    private int agility;
    private int intellect;
    private int hardiness;
    private int currentExperience;
    private int movement;
    private int currentMana;
    private int currentHealth;
    private int livesLeft;

    //Extra from weapon and armor
    private int weaponBonus; //base dmg of weapon
    private int armorBonus; //base


    //Derived Stats
    private int maxLife = 5; //default 5 - doesn't need to be calculated
    private int level; //doesn't need to be calculated

    private int maxMana;
    private int maxHealth;
    private int offensiveRating;
    private int defensiveRating;
    private int armorRating;
    private int experienceToNextLevel;

    private ArrayList<StatsModifiable> temporaryStats;


    public Stats(Entity owner){
        this.owner = owner;

        //will be modified depending on occupation upon creating
        setStrength(1);
        setAgility(1);
        setIntellect(1);
        setHardiness(1);
        setCurrentExperience(0);
        setMovement(20);
        setCurrentMana(maxMana);
        setCurrentHealth(maxHealth);
        setLivesLeft(maxLife);

        setWeaponBonus(0);
        setArmorBonus(0);
        setLevel(1);

        calculateDerivedStats();

        temporaryStats = new ArrayList();
    }

    /************** Calculate derived Stats **************/
    //TODO: need to redo formula for game balance
    private void calculateDerivedStats(){
        calculateMaxMana();
        calculateMaxHealth();
        calculateOffensiveRating();
        calculateDefensiveRating();
        calculateArmorRating();
        calculateExpNeededForNextLevel();
    }

    private void calculateMaxMana(){
        maxMana = level*2 + intellect*3;
    }

    private void calculateMaxHealth(){
        maxHealth = level*2 + hardiness*3;
    }

    private void calculateOffensiveRating(){
        offensiveRating = strength*2 + level*2 + weaponBonus;
    }

    private void calculateDefensiveRating(){
        defensiveRating = level*2 + agility*2;
    }

    //armor absorbs a fixed amount of damage; based on equipped armor and hardiness. umm.....?
    private void calculateArmorRating(){
        armorRating = armorBonus*2 + hardiness*2;
    }

    private void calculateExpNeededForNextLevel(){
        experienceToNextLevel = (int)Math.pow(level, 2);
    }

    /************** DONE Calculate derived Stats **************/



    public void addTemporaryStats(StatsModifiable statsModifiable){
        modifyStats(statsModifiable);
        temporaryStats.add(statsModifiable);
    }

    public boolean removeTemporaryStats(StatsModifiable statsModifiable){

        if(!temporaryStats.remove(statsModifiable))
            return false;

        setStrength(getStrength() - statsModifiable.getStrength());
        setAgility(getAgility() - statsModifiable.getAgility());
        setIntellect(getIntellect() - statsModifiable.getIntellect());
        setHardiness(getHardiness() - statsModifiable.getHardiness());
        setMovement(getMovement() - statsModifiable.getMovement());
        setCurrentMana(getCurrentMana() - statsModifiable.getCurrentMana());
        setCurrentHealth(getCurrentHealth() - statsModifiable.getCurrentHealth());
        setWeaponBonus(getWeaponBonus() - statsModifiable.getWeaponBonus());
        setArmorBonus(getArmorBonus() - statsModifiable.getArmorBonus());
        setCurrentExperience(getCurrentExperience() - statsModifiable.getCurrentExperience());

        calculateDerivedStats();

        return true;
    }


    public void modifyStats(StatsModifiable statsModifiable){
        setStrength(getStrength() + statsModifiable.getStrength());
        setAgility(getAgility() + statsModifiable.getAgility());
        setIntellect(getIntellect() + statsModifiable.getIntellect());
        setHardiness(getHardiness() + statsModifiable.getHardiness());
        setMovement(getMovement() + statsModifiable.getMovement());
        setCurrentMana(getCurrentMana() + statsModifiable.getCurrentMana());
        setCurrentHealth(getCurrentHealth() + statsModifiable.getCurrentHealth());
        setWeaponBonus(getWeaponBonus() + statsModifiable.getWeaponBonus());
        setArmorBonus(getArmorBonus() + statsModifiable.getArmorBonus());
        setCurrentExperience(getCurrentExperience() + statsModifiable.getCurrentExperience());

        calculateDerivedStats();
    }



    /****************** Setters and Getters *********************/
    public int getStrength() {
        return strength;
    }

    private void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    private void setAgility(int agility) {
        if(agility <= 0)
            this.agility = 0;
        else
            this.agility = agility;
    }

    public int getIntellect() {
        return intellect;
    }

    private void setIntellect(int intellect) {
        if(intellect <= 0)
            this.intellect = 0;
        else
            this.intellect = intellect;
    }

    public int getHardiness() {
        return hardiness;
    }

    private void setHardiness(int hardiness) {
        if(hardiness <= 0)
            this.hardiness = 0;
        else
            this.hardiness = hardiness;
    }

    public int getCurrentExperience() {
        return currentExperience;
    }

    private void setCurrentExperience(int exp) {

        if(exp >= experienceToNextLevel){
            currentExperience = exp - experienceToNextLevel;
            setLevel(getLevel() + 1);
            calculateDerivedStats();
            owner.levelUp();
        }else{
            currentExperience = exp;
        }
    }

    public int getMovement() {
        return movement;
    }

    private void setMovement(int movement) {
        if(movement <= 0)
            this.movement = 0;
        else
            this.movement = movement;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    private void setCurrentMana(int currentMana) {
        if(currentMana <= 0)
            this.currentMana = 0;
        else if(currentMana > maxMana)
            this.currentMana = maxMana;
        else
            this.currentMana = currentMana;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    private void setCurrentHealth(int currentHealth) {
        if(currentHealth <= 0){
            this.currentHealth = 0;
            setLivesLeft(getLivesLeft()-1);
        }else{
            this.currentHealth = currentHealth;
        }
    }

    public int getLivesLeft() {
        return livesLeft;
    }

    private void setLivesLeft(int livesLeft) {
        if(livesLeft <= 0){
            this.livesLeft = 0;
            owner.die();
        }else {
            this.livesLeft = livesLeft;
        }
    }

    public int getWeaponBonus() {
        return weaponBonus;
    }

    private void setWeaponBonus(int weaponBonus) {
        if(weaponBonus <= 0)
            this.weaponBonus = 0;
        else
            this.weaponBonus = weaponBonus;
    }

    public int getArmorBonus() {
        return armorBonus;
    }

    private void setArmorBonus(int armorBonus) {
        if(armorBonus <= 0)
            this.armorBonus = 0;
        else
            this.armorBonus = armorBonus;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public int getLevel() {
        return level;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getOffensiveRating() {
        return offensiveRating;
    }

    public int getDefensiveRating() {
        return defensiveRating;
    }

    public int getArmorRating() {
        return armorRating;
    }

    public int getExperienceToNextLevel() {
        return experienceToNextLevel;
    }

    public ArrayList<StatsModifiable> getTemporaryStats() {
        return temporaryStats;
    }

    /****************** END Setters and Getters *********************/


}

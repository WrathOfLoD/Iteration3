package com.wrathOfLoD.Models.Stats;

import java.util.ArrayList;

/**
 * Created by luluding on 4/7/16.
 */
public class Stats {
    private String name;

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


    //Derived Stats
    private int maxLife = 5; //default 5
    private int level;
    private int maxMana;
    private int maxHealth;
    private int offensiveRating;
    private int defensiveRating;
    private int armorRating;
    private int experienceToNextLevel;

    private ArrayList<StatsModifiable> temporaryStats;


    public Stats(String entityName){
        name = entityName;
        level = 1;
        livesLeft = maxLife;
        temporaryStats = new ArrayList<>();
    }

    private void calculateDerivedStats(){
        //level
        //maxMana
        //maxHealth
        //offensiveRating
        //defensiveRating
        //armorRating;
        //experienceToNextLevel




    }


    public void gainExperience(int exp){ //TODO: pass in entity
        //TODO: call entity. level up if level up

    }








    public void addTemporaryStats(StatsModifiable statsModifiable){
        agility += statsModifiable.getAgility(); //TODO: use setter/getter instead!!!!!
        intellect += statsModifiable.getIntellect();
        hardiness += statsModifiable.getHardiness();
        movement += statsModifiable.getMovement();
        currentMana += statsModifiable.getCurrentMana();
        currentHealth += statsModifiable.getCurrentHealth();

        temporaryStats.add(statsModifiable);

        //calculate derived stats
    }

    public boolean removeTemporaryStats(StatsModifiable statsModifiable){

        if(!temporaryStats.remove(statsModifiable))
            return false;

        agility -= statsModifiable.getAgility();
        intellect -= statsModifiable.getIntellect();
        hardiness -= statsModifiable.getHardiness();
        movement -= statsModifiable.getMovement();
        currentMana -= statsModifiable.getCurrentMana();
        currentHealth -= statsModifiable.getCurrentHealth();

        //calculate derived stats

        return true;
    }


    public void addPermanentStats(StatsModifiable statsModifiable){
        agility += statsModifiable.getAgility();
        intellect += statsModifiable.getIntellect();
        hardiness += statsModifiable.getHardiness();
        movement += statsModifiable.getMovement();
        currentMana += statsModifiable.getCurrentMana();
        currentHealth += statsModifiable.getCurrentHealth();
    }






}

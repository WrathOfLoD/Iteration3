package com.wrathOfLoD.Models.Entity.Character;

import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by zach on 4/7/16.
 */
public class NPC extends Character {
    private int aggression;
    private int greed;
    private Position homePosition;

    public NPC(String name, Position pos, Occupation occupation){
        super(name, pos, occupation);
        this.aggression = 0;
        this.greed = 0;
        this.homePosition = pos;
    }

    public NPC(String name, Position pos, Occupation occupation, int aggression, int greed){
        super(name, pos, occupation);
        this.aggression = aggression;
        this.greed = greed;
        this.homePosition = pos;
    }

    public int getAggression(){
        return this.aggression;
    }

    public int getGreed(){
        return this.greed;
    }

    public Position getHomePosition(){
        return this.homePosition;
    }

    public void setAggression(int newAggression){
        this.aggression = newAggression;
    }

    public void setGreed(int newGreed){
        this.aggression = newGreed;
    }
}

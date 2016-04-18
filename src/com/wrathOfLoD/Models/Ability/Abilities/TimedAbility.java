package com.wrathOfLoD.Models.Ability.Abilities;

import com.wrathOfLoD.GameClock.Fuseable;
import com.wrathOfLoD.GameClock.Tickable;
import com.wrathOfLoD.GameClock.TimeModel;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Entity.Entity;

/**
 * Created by luluding on 4/13/16.
 */

//uses wind up and cool down
public abstract class TimedAbility extends Ability implements Tickable{

    private int windup;
    private int coolDown; //total time it takes to do the ability
    private int currentTick;

    public TimedAbility(Character character, int windup, int coolDown, int manaCost) {
        super(character, manaCost);
        this.windup = windup;
        this.coolDown = coolDown;
        this.currentTick = 0;
    }

    public TimedAbility(int unlockLevel, Character character, int windup,int coolDown, int manaCost){
        super(unlockLevel, character, manaCost);
        this.windup = windup;
        this.coolDown = coolDown;
        this.currentTick = 0;
    }


    public void doAbilityHook(){
        this.currentTick = 0;
        TimeModel.getInstance().registerTickable(this);
    }

    public abstract void windUpHook();
    //public abstract void coolDownHook();


    public void tick(){
        currentTick++;
        if(currentTick == windup){
            getCharacter().notifyObserverOnAtt();
            windUpHook();
        }else if(currentTick == coolDown){
            TimeModel.getInstance().deregisterTickable(this);
            getCharacter().setInactive();
            getCharacter().notifyObserverDoneAtt();
        }
    }


    /********** Getter and Setter *****************/
    public int getWindup() {
        return windup;
    }

    public void setWindup(int windup) {
        this.windup = windup;
    }

    public int getCoolDown() {
        return coolDown;
    }

    protected int getCurrentTick(){ return this.currentTick; }

    public void setCoolDown(int coolDown) {
        this.coolDown = coolDown;
    }

}

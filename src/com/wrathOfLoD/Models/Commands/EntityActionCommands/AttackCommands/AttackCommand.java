package com.wrathOfLoD.Models.Commands.EntityActionCommands.AttackCommands;

import com.wrathOfLoD.GameClock.Tickable;
import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Entity.Character.Character;

/**
 * Created by matthewdiaz on 4/13/16.
 */
public class AttackCommand extends ActionCommand implements Tickable{
    private Character character;
    private int skillLevel;
    private int currentTick;
    private int windUp;
    private int coolDown;

    public AttackCommand(Character character, int coolDown, int windUp, int skillLevel){
        this.character = character;
        this.coolDown = coolDown;
        this.windUp = windUp;
        this.skillLevel = skillLevel;
        this.currentTick = 0;
    }

    protected Character getCharacter(){
        return this.character;
    }

    protected int getCoolDown(){
        return this.coolDown;
    }

    protected int getWindUp(){
        return this.windUp;
    }

    protected int getSkillLevel(){
        return this.skillLevel;
    }

    @Override
    public void execute() {

    }

    @Override
    public void tick() {
        currentTick++;
//        if(currentTick == windup){
//            windUpHook();
//        }else if(currentTick == coolDown){
//            TimeModel.getInstance().deregisterTickable(this);
//            getCharacter().setInactive();
//        }

    }
}

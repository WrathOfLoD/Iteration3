package com.wrathOfLoD.Models.Commands.EntityActionCommands.AttackCommands;

import com.wrathOfLoD.GameClock.Tickable;
import com.wrathOfLoD.GameClock.TimeModel;
import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/13/16.
 */
public abstract class AttackCommand extends ActionCommand implements Tickable{
    private Character character;
    private int currentTick;
    private int windUp;
    private int coolDown;
    private int skillLevel;

    public AttackCommand(Character character, int coolDown, int windUp, int skillLevel){
        this.character = character;
        this.coolDown = coolDown;
        this.windUp = windUp;
        this.currentTick = 0;
        this.skillLevel = skillLevel;
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

    protected int getSkillLevel(){ return this.skillLevel; }

    protected abstract void windUpHook(Position characterPosition, Direction characterFacingDirection, int attackDamage);

    @Override
    public void execute() {

        TimeModel.getInstance().registerTickable(this);
    }

    @Override
    public void tick() {
        currentTick++;
        if(currentTick == windUp){
            character.notifyObserverOnAtt();
            int offensiveRating = this.character.getStats().getOffensiveRating();
            int attackDamage = offensiveRating + (skillLevel * 2);
            windUpHook(this.character.getPosition(), this.character.getDirection(), attackDamage);
        }else if(currentTick == coolDown){
            getCharacter().setInactive();
            character.notifyObserverDoneAtt();

            TimeModel.getInstance().deregisterTickable(this);
        }
    }
}

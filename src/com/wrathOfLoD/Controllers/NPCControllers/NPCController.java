package com.wrathOfLoD.Controllers.NPCControllers;

import com.wrathOfLoD.GameClock.Tickable;
import com.wrathOfLoD.Models.Entity.Character.NPC;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Target.NPCTargetManager;
import com.wrathOfLoD.Models.Target.Target;
import com.wrathOfLoD.Models.Target.TargetManager;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/9/16.
 */
public abstract class NPCController implements Tickable{
    private NPC controlledEntity;
    private TargetManager targetManager;

    public NPCController(Entity controlledEntity){
        this.controlledEntity = (NPC)controlledEntity;
        this.targetManager = controlledEntity.getTargetManager();
    }

    public void tick(){
        think(targetManager.getActiveTarget());
    }

    protected abstract void think(Target target);
    protected abstract void moveTowardsTarget(Position position);
    protected abstract void attack(Target target);
    protected abstract void moveOn(Target target);
//    protected abstract Direction adjustDir(Direction dir);

    protected NPC getControlledEntity(){
        return controlledEntity;
    }

}

package com.wrathOfLoD.Models.Commands.EntityActionCommands;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Entity.Entity;

/**
 * Created by zach on 4/17/16.
 */
public class FallCommand extends ActionCommand {
    private Entity entity;
    private int fallDistance;

    public FallCommand(Entity entity, int fallDistance) {
        this.entity = entity;
        this.fallDistance = fallDistance;
    }

    @Override
    public void execute() {
        System.out.println("FALLLIING!!");
    }
}

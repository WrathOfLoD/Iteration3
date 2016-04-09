package com.wrathOfLoD.Commands.ActionCommand;

import com.wrathOfLoD.Models.Entity.Entity;

/**
 * Created by luluding on 4/8/16.
 */
public class DieCommand extends ActionCommand{

    public DieCommand(Entity entity){
        super(entity);
    }

    @Override
    public void execute() {
        // TODO: MAKE SURE TO CALL LTM.deregister(entity)
    }
}

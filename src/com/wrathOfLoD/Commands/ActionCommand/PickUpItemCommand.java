package com.wrathOfLoD.Commands.ActionCommand;

import com.wrathOfLoD.Models.Entity.Entity;

/**
 * Created by matthewdiaz on 4/9/16.
 */
public class PickUpItemCommand extends ActionCommand {
    private Entity entity;

    public PickUpItemCommand(Entity entity){
        super(entity);
    }


    public Entity getEntity() {
        return entity;
    }

    protected void setEntity(Entity entity) {
        this.entity = entity;
    }

    public void execute(){

    }

}

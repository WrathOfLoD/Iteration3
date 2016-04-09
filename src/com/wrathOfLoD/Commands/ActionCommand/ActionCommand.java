package com.wrathOfLoD.Commands.ActionCommand;

import com.wrathOfLoD.Models.Entity.Entity;

/**
 * Created by luluding on 4/8/16.
 */
public abstract class ActionCommand {
    private Entity entity;

    public ActionCommand(Entity entity){
        this.entity = entity;
    }

    /***** getter & setter for ActionCommand *******/

    public Entity getEntity() {
        return entity;
    }

    protected void setEntity(Entity entity) {
        this.entity = entity;
    }

    /********* END Getters and Setters *********/

    public abstract void execute();

}

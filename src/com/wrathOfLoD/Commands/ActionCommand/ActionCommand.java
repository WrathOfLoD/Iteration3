package com.wrathOfLoD.Commands.ActionCommand;

import com.wrathOfLoD.Models.Entity.Entity;
import sun.corba.EncapsInputStreamFactory;

/**
 * Created by luluding on 4/8/16.
 */
public abstract class ActionCommand {
    private Entity entity;

    public abstract void execute();

    public Entity getEntity() {
        return entity;
    }

    protected void setEntity(Entity entity) {
        this.entity = entity;
    }


}

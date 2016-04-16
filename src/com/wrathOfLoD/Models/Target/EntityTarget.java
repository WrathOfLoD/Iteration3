package com.wrathOfLoD.Models.Target;

import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Entity.Character.Pet;
import com.wrathOfLoD.Models.Entity.Entity;

/**
 * Created by zach on 4/7/16.
 */
public class EntityTarget extends Target {
    private final Entity target;

    public EntityTarget(Entity target) {
        if(target instanceof Avatar){
            setPriority(1000);
        }
        else if(target instanceof Pet){
            setPriority(999);
        }
        else{
            setPriority(998);
        }
        this.target = target;
    }

    public Entity getTarget() {
        return target;
    }
}

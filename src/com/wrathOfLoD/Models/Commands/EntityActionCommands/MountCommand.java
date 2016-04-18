package com.wrathOfLoD.Models.Commands.EntityActionCommands;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Entity.CanMountVisitor;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Entity.Mount;
import com.wrathOfLoD.Models.LocationTracker.LocationTrackerManager;
import com.wrathOfLoD.Models.Map.Map;

import java.util.List;

/**
 * Created by matthewdiaz on 4/16/16.
 */
public class MountCommand extends ActionCommand{
    private Mount mount;
    private Character mountedCharacter;

    public MountCommand(Character mountedCharacter){
//        this.mount = mount;
        this.mountedCharacter = mountedCharacter;
    }

    @Override
    public void execute() {
        // TODO: 4/18/16 get tile in direction and see if mount is there 
        List<Entity> entityList = Map.getInstance().getTile(mountedCharacter.getPosition().getPosInDir(mountedCharacter.getDirection())).getEntitiesList();

        CanMountVisitor canMountVisitor = new CanMountVisitor();

        for (int i = 0; i < entityList.size(); i++) {
            canMountVisitor.visitEntity(entityList.get(i));
            if (canMountVisitor.isCanMount()) {
                System.out.println("Found mount!");

                this.mount = (Mount)entityList.get(i);
                System.out.println("mount is: " + this.mount);
                break;
            }
        }

        if (this.mount == null)
            return;

        this.mount.mount(this.mountedCharacter);

        // Reset mount for the command
        this.mount = null;

//        Map.getInstance().removeEntity(mountedCharacter, mountedCharacter.getPosition());

        //not sure if we deregister the Character
//        LocationTrackerManager.getInstance().deregisterEntity(mountedCharacter);

    }
}

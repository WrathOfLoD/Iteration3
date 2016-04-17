package com.wrathOfLoD.Models.Commands.EntityActionCommands;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Entity.Mount;
import com.wrathOfLoD.Models.LocationTracker.LocationTrackerManager;
import com.wrathOfLoD.Models.Map.Map;

/**
 * Created by matthewdiaz on 4/16/16.
 */
public class MountCommand extends ActionCommand{
    private Mount mount;
    private Character mountedCharacter;

    public MountCommand(Mount mount, Character mountedCharacter){
        this.mount = mount;
        this.mountedCharacter = mountedCharacter;
    }

    @Override
    public void execute() {
        Map.getInstance().removeEntity(mountedCharacter, mountedCharacter.getPosition());
        //not sure if we deregister the Character
        LocationTrackerManager.getInstance().deregisterEntity(mountedCharacter);

        //todo: notify the view
        //todo: change controller of mount so that mountedCharacter can controll

    }
}

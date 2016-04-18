package com.wrathOfLoD.Models.Map.AreaEffect;

import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Entity.Character.NPC;
import com.wrathOfLoD.Models.Entity.Character.Pet;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Entity.Mount;
import com.wrathOfLoD.VisitorInterfaces.EntityVisitor;

/**
 * Created by luluding on 4/18/16.
 */
public class CanTeleportVisitor implements EntityVisitor {
    private boolean canTeleport = false;

    public boolean getCanTeleport(){
        return canTeleport;
    }

    @Override
    public void visitEntity(Entity entity) {
        canTeleport = false;
    }

    @Override
    public void visitCharacter(Character character) {
        canTeleport = false;
    }

    @Override
    public void visitAvatar(Avatar avatar) {
        canTeleport = true;
    }

    @Override
    public void visitNPC(NPC npc) {
        canTeleport = false;
    }

    @Override
    public void visitPet(Pet pet) {
        canTeleport = false;
    }

    @Override
    public void visitMount(Mount mount) {
        canTeleport = false;
    }
}

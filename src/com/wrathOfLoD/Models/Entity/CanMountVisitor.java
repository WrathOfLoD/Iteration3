package com.wrathOfLoD.Models.Entity;

import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Entity.Character.NPC;
import com.wrathOfLoD.Models.Entity.Character.Pet;
import com.wrathOfLoD.VisitorInterfaces.EntityVisitor;

/**
 * Created by zach on 4/18/16.
 */
public class CanMountVisitor implements EntityVisitor {
    private boolean canMount = false;


    public boolean isCanMount() { return this.canMount; }
    public void visitEntity(Entity e) {
        canMount = false;
        e.accept(this);
    }

    @Override
    public void visitCharacter(Character character) {
        canMount = false;
    }

    @Override
    public void visitAvatar(Avatar avatar) {
        canMount = false;
    }

    @Override
    public void visitNPC(NPC npc) {
        canMount = false;
    }

    @Override
    public void visitPet(Pet pet) {
        canMount = false;
    }

    @Override
    public void visitMount(Mount mount) {
        canMount = true;
    }
}

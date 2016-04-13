package com.wrathOfLoD.VisitorInterfaces;

import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Entity.Character.NPC;
import com.wrathOfLoD.Models.Entity.Character.Pet;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Entity.Mount;

/**
 * Created by icavitt on 4/12/2016.
 */
public interface EntityVisitor {

    public void visitEntity(Entity entity);
    public void visitCharacter(Character character);
    public void visitAvatar(Avatar avatar);
    public void visitNPC(NPC npc);
    public void visitPet(Pet pet);
    public void visitMount(Mount mount);

}

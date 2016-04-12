package com.wrathOfLoD.VisitorInterfaces;

import com.wrathOfLoD.Models.Ability.Abilities.Ability;
import com.wrathOfLoD.Models.Ability.AbilityManager;
import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Models.Skill.SkillManager;
import com.wrathOfLoD.Models.Stats.Stats;

/**
 * Created by icavitt on 4/12/2016.
 */
//this will likely be used along with entity visitor for full functionality
public interface EntityPropertyVisitor {

    public void visitStats(Stats stats);
    public void visitSkillManager(SkillManager skillManager);
    public void visitAbilityManager(AbilityManager abilityManager);
    public void visitOccupation(Occupation occupation);

}

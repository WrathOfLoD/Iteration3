package com.wrathOfLoD.Views.SkillView;

import com.wrathOfLoD.Models.Ability.AbilityManager;
import com.wrathOfLoD.Views.StaticView;

import java.awt.*;

/**
 * Created by echristiansen on 4/16/2016.
 */
public class AbilityView extends StaticView {

    private AbilityManager abilityManager;

    public AbilityManager getAbilityManager() {
        return abilityManager;
    }
    public void setAbilityManager(AbilityManager abilityManager) {
        this.abilityManager = abilityManager;
    }

    public AbilityView(AbilityManager abilityManager) {
        setAbilityManager(abilityManager);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);


    }

}

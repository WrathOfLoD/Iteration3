package com.wrathOfLoD.Views.AbilityView;

import com.wrathOfLoD.Models.Ability.AbilityManager;
import com.wrathOfLoD.Views.View;

/**
 * Created by Mistiansen on 4/15/16.
 */
public class AbilityView extends View {

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




}

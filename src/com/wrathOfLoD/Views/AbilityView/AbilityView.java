package com.wrathOfLoD.Views.AbilityView;

import com.wrathOfLoD.Models.Ability.Abilities.Ability;
import com.wrathOfLoD.Models.Ability.AbilityManager;
import com.wrathOfLoD.Observers.Observer;
import com.wrathOfLoD.Views.ContentDisplayStructure.ContentDisplayStructure;
import com.wrathOfLoD.Views.ItemDisplayView.Slot.AbilitySlot;
import com.wrathOfLoD.Views.ItemDisplayView.Slot.Slot;
import com.wrathOfLoD.Views.StaticView;

import java.awt.*;

/**
 * Created by Mistiansen on 4/15/16.
 */
public class AbilityView extends StaticView implements Observer {

    private AbilityManager abilityManager;

    public AbilityManager getAbilityManager() {
        return abilityManager;
    }
    public void setAbilityManager(AbilityManager abilityManager) {
        this.abilityManager = abilityManager;
    }

    @Override
    public void update() {
        fillAbilitiesView();
    }

    public AbilityView(AbilityManager abilityManager, ContentDisplayStructure contentDisplayStructure) {
        setAbilityManager(abilityManager);
        setContentDisplayStructure(contentDisplayStructure);
        setTitle("Abilities");
        initDefaultUI();
        fillAbilitiesView();
        setBackgroundImageFileName("resources/Backgrounds/spaceSlothEternal.png");
    }

    public void fillAbilitiesView() {
        for(Ability ability: getAbilityManager().getUnlockedAbilities()) {
            AbilityViewObject abilityViewObject = new AbilityViewObject(ability);
            Slot slot = new AbilitySlot(abilityViewObject);
            getContentDisplayStructure().addSlot(slot);
            System.out.println("ATTEMTPING TO ADD ABILITY TO SLOT" + slot.getStaticViewObject().getObject());
        }
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int initialX = getX();
        int initialY = getY()+getTitlePanel().getHeight();
        getContentDisplayStructure().paintComponent(g, initialX, initialY, getWidth(), getHeight());

    }



}

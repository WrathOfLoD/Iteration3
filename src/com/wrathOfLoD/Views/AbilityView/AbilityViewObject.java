package com.wrathOfLoD.Views.AbilityView;

import com.wrathOfLoD.Models.Ability.Abilities.Ability;
import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Views.ViewObjects.GraphicViewObject;

/**
 * Created by echristiansen on 4/17/2016
 */
public class AbilityViewObject extends GraphicViewObject {

    public AbilityViewObject(Ability ability) {
        setObject(ability);
        if (ability != null) {
            setImageFilePath(Config.instance().getAbilityVOPath() + ability.getName() + Config.instance().getImageExtension());
            initializeImage();
        }
    }

}

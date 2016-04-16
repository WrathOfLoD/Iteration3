package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Models.Map.AreaEffect.AreaEffect;
import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Views.SpriteMap.ImageAnimation;

/**
 * Created by luluding on 4/16/16.
 */
public class AreaEffectViewObject extends ModelViewObject{
    private AreaEffect areaEffect;

    public AreaEffectViewObject(AreaEffect ae, ImageAnimation imageAnimation){
        super(Config.getAreaEffectZLevel());
        this.areaEffect = areaEffect;
        setImage(imageAnimation.getFrame());
    }



}

package com.wrathOfLoD.Views.AbilityView;

import com.wrathOfLoD.Models.Ability.Abilities.Ability;
import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Views.ImageFactory.ImageFactory;
import com.wrathOfLoD.Views.ViewObjects.StaticViewObject;

import java.awt.*;

/**
 * Created by echristiansen on 4/17/2016.
 */
public class AbilityViewObject extends StaticViewObject {

    private Image image;

    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }

    public AbilityViewObject(Ability ability) {
        setObject(ability);
        initializeImage(ability);
    }

    public void initializeImage(Ability ability) {
        setImage(ImageFactory.generateImage(Config.instance().getAbilityVOPath()+ability.getName()+Config.instance().getImageExtension())); //edit: testing. shouldn't be using this path
    }

    @Override
    public void paintComponent(Graphics g, int x, int y, int width, int height) {
        super.paintComponent(g);
        g.drawImage(this.getImage(),x,y,width,height,this);
    }
}

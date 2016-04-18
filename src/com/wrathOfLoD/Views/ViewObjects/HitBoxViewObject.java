package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Models.RangedEffect.HitBox.HitBox;
import com.wrathOfLoD.Observers.ModelObservers.DestroyableModelObserver;
import com.wrathOfLoD.Observers.ViewObjectObservers.DestroyableVOObservable;
import com.wrathOfLoD.Observers.ViewObjectObservers.DestroyableVOObserver;
import com.wrathOfLoD.Observers.ViewObjectObservers.VOObservable;
import com.wrathOfLoD.Observers.ViewObjectObservers.VOObserver;
import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.SpriteMap.ImageAnimation;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by luluding on 4/17/16.
 */
public class HitBoxViewObject extends ModelViewObject implements DestroyableModelObserver, VOObservable{
    private HitBox hitBox;
    private ArrayList<VOObserver> voObservers;

    public HitBoxViewObject(HitBox hitBox, ImageAnimation imageAnimation){
        super(Config.getHitBoxZLevel());
        this.hitBox = hitBox;
        setImage(imageAnimation.getFrame());
        voObservers = new ArrayList<>();
    }


    @Override
    public void paintComponent(Graphics g, int x, int y, int width, int height, boolean visible) {
		Image renderedImage = this.getImage();
		if(!visible){
			renderedImage = getGrayscaleImage(renderedImage);
		}
        g.drawImage(renderedImage, x, y, this.getImage().getWidth(null), this.getImage().getHeight(null), this);
    }

    @Override
    public void notifyDestroy(Position position) {
        for(VOObserver voo: voObservers){
            voo.notifyDestroy(this, position);
        }
    }

    @Override
    public void registerObserver(VOObserver voo) {
        voObservers.add(voo);
    }

    @Override
    public void deregisterObserver(VOObserver voo) {
        voObservers.remove(voo);
    }
}

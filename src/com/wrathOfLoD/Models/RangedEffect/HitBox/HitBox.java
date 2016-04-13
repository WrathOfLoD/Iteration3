package com.wrathOfLoD.Models.RangedEffect.HitBox;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Utility.Position;
import javafx.geometry.Pos;

import java.util.*;

/**
 * Created by luluding on 4/9/16.
 */
public class HitBox {
    private int power;
    private int accuracy;
    private String name;
    private Position location;
    private HitBoxEffect hitBoxEffect;

    public HitBox(int power, int accuracy, String name, Position location, HitBoxEffect hitBoxEffect){
        this.power = power;
        this.accuracy = accuracy;
        this.name = name;
        this.location = location;
        this.hitBoxEffect = hitBoxEffect;
    }

    //depends on accuacy
    private boolean shouldDoEffect(){
        int randomNum = (int)(Math.random() * 100) + 1; //generate a randomNum from 1 to 100 (max accu percent)
        if(randomNum <= accuracy)
            return true;

        return false;
    }

    public void apply(){
        Iterator<Entity> entityIterator = Map.getInstance().getTile(location).getEntities();
        if(shouldDoEffect()){
            hitBoxEffect.doEffect(entityIterator);
        }
    }


    //HB alertDestroy also removes its observer as well
}

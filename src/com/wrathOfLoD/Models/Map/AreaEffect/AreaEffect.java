package com.wrathOfLoD.Models.Map.AreaEffect;

import com.wrathOfLoD.SaveLoad.XMLSaver;
import com.wrathOfLoD.VisitorInterfaces.TileVisitor;

/**
 * Created by zach on 4/7/16.
 */
public abstract class AreaEffect {

    public void accept(TileVisitor tv){
        tv.visitAreaEffect(this);
    }
}

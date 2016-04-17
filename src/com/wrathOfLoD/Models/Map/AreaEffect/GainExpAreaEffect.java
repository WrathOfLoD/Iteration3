package com.wrathOfLoD.Models.Map.AreaEffect;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.VisitorInterfaces.AreaEffectVisitor;

/**
 * Created by luluding on 4/16/16.
 */
public class GainExpAreaEffect extends AreaEffect {
    private int exp;

    public GainExpAreaEffect(String name, int exp){
        super(name);
        this.exp = exp;
    }

    @Override
    public void interact(Entity entity) {
        entity.gainExp(exp);
    }

    public void accept(AreaEffectVisitor aev){
        aev.visitGainExpAreaEffect(this);
    }

}

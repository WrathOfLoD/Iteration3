package com.wrathOfLoD.VisitorInterfaces;

import com.wrathOfLoD.Models.Map.AreaEffect.*;

/**
 * Created by luluding on 4/16/16.
 */
public interface AreaEffectVisitor {

    void visitAreaEffect(AreaEffect areaEffect);
    void visitGainExpAreaEffect(GainExpAreaEffect gainExpAreaEffect);
    void visitHealDamageAreaEffect(HealDamageAreaEffect healDamageAreaEffect);
    void visitInstantDeathAreaEffect(InstantDeathAreaEffect instantDeathAreaEffect);
    void visitTakeDamageAreaEffect(TakeDamageAreaEffect takeDamageAreaEffect);
}

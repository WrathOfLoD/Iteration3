package com.wrathOfLoD.Models.Ability.Abilities;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.RangedEffect.REG.LineREG;
import com.wrathOfLoD.Models.RangedEffect.REG.RangedEffectGenerator;
import com.wrathOfLoD.Models.Stats.Stats;
import com.wrathOfLoD.Models.Stats.StatsModifiable;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.ModelConfig;

/**
 * Created by zach on 4/7/16.
 */
public class FireballAbility extends Ability {
    private Direction direction;
    private Stats stats;

    public FireballAbility(Entity entity, int windup,int coolDown, Direction dir, Stats stats) {
        super(entity, windup, coolDown, ModelConfig.getMidManaCost());
        this.direction = dir;
        this.stats = stats;
    }

    public FireballAbility(int unlockingLevel, Entity entity, int windup,int coolDown, Direction dir, Stats stats){
        super(unlockingLevel, entity, windup, coolDown, ModelConfig.getMidManaCost());
        this.direction = dir;
        this.stats = stats;
    }

    @Override
    public void doAbility() {
        //TODO: check if can cast ability (using skill level)

        //TODO: if get target, set avatar's dir to target's dir

        StatsModifiable manaModifiable = StatsModifiable.createManaStatsModifiable(getManaCost());
        stats.modifyStats(manaModifiable);

        //RangedEffectGenerator reg = new LineREG()

    }
}

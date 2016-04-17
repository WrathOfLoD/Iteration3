package com.wrathOfLoD.Models.RangedEffect.REG;

import com.wrathOfLoD.GameClock.Fuseable;
import com.wrathOfLoD.GameClock.TimeModel;
import com.wrathOfLoD.Models.RangedEffect.HitBox.HitBox;
import com.wrathOfLoD.Models.RangedEffect.HitBox.HitBoxFactories.HitBoxFactory;
import com.wrathOfLoD.Utility.ModelConfig;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.ViewFactories.ViewObjectFactory.ViewObjectFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by luluding on 4/9/16.
 */
public abstract class RangedEffectGenerator implements Fuseable{
    private int currentDistance;
    private int totalDistance; //radius
    private Position entityLocation; //location of entity who is firing this
    private int unmodifiedPower; //initial damage
    private int unmodifiedAccuracy = 100; //set to 100 for now, can be passed in if needed
    private int travelTime; //time it takes to get to next layer
    private HitBoxFactory hitBoxFactory;
    private ArrayList<HitBox> effectiveHB;

    public RangedEffectGenerator(int totalDistance, Position entityLocation, int damage, int travelTime, HitBoxFactory hitBoxFactory){
        this.totalDistance = totalDistance;
        this.currentDistance = 0;
        this.entityLocation = entityLocation;
        this.unmodifiedPower = damage;
        this.travelTime = travelTime;
        this.hitBoxFactory = hitBoxFactory;
        effectiveHB = new ArrayList<>();
    }

    public void doRangedEffect(){ //template method
        if(currentDistance < totalDistance){
            currentDistance ++;

            List<Position> effectivePos = getEffectiveLocations(currentDistance, entityLocation);
            int damage = calculatePower(unmodifiedPower, currentDistance);
            int accuracy = calculateAccuracy(unmodifiedAccuracy, currentDistance);

            for(Position p : effectivePos){
                HitBox hb = hitBoxFactory.createHitBox(damage, accuracy, p);
                ViewObjectFactory.getInstance().createHitBoxViewObject(p, hb);

                effectiveHB.add(hb);
                hb.apply();
            }

            TimeModel.getInstance().registerFuseable(this, travelTime);
        }
    }

    public abstract List<Position> getEffectiveLocations(int radius, Position orignalPos); //pass in distanceLeft

    @Override
    public void explode() {
        doRangedEffect();

        Iterator<HitBox> hitBoxIterator = effectiveHB.iterator();
        while (hitBoxIterator.hasNext()){
            HitBox hb = hitBoxIterator.next();
            hb.destroyHitbox();
            hitBoxIterator.remove();
        }
    }

    private int calculatePower(int unmodifiedPower, int currentDistance){
        double decPercent = 1.0 / ModelConfig.getAvatarVisibleRadius();

        //power on tiles outside visible radius = 0
        //radius at 1 = 100% power

        if(currentDistance > ModelConfig.getAvatarVisibleRadius()){
            return 0;
        }

        int calculatedPower = unmodifiedPower - (int)(unmodifiedPower * decPercent * (currentDistance - 1));
        return calculatedPower;
    }

    private int calculateAccuracy(int unmodifiedAccuracy, int currentDistance){
        double decPercent = 1.0 / ModelConfig.getAvatarVisibleRadius();

        if(currentDistance > ModelConfig.getAvatarVisibleRadius()){
            return 0;
        }

        int calculatedAcc = unmodifiedAccuracy - (int)(unmodifiedAccuracy * decPercent * (currentDistance - 1));
        return calculatedAcc;
    }



}

package com.wrathOfLoD.Models.Map.AreaEffect;


import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.LocationTracker.LocationTrackerManager;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.MapArea;
import com.wrathOfLoD.Utility.Position;
import javafx.geometry.Pos;

/**
 * Created by luluding on 4/18/16.
 */
public class Teleport extends AreaEffect {
    private Position destPosition;


    public Teleport(Position destPosition){
        super("Teleport");
        this.destPosition = destPosition;
    }


    @Override
    public void interact(Entity entity) {


            Map.getInstance().removeEntity(entity, entity.getPosition());
            LocationTrackerManager.getInstance().deregisterEntity(entity);
            //entity.notifyObserverOnTeleport(destMapArea, entity.getPosition(), destPosition);
            Map.getInstance().addEntity(entity, destPosition);
            entity.notifyObserverOnMove(entity.getPosition(), destPosition, entity.getDirection(), 2);
            entity.setPosition(destPosition);
            LocationTrackerManager.getInstance().registerEntity(entity);

    }
}

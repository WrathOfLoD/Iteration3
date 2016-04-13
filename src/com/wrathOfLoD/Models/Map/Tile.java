package com.wrathOfLoD.Models.Map;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Models.LocationTracker.LocationTrackerManager;
import com.wrathOfLoD.Models.Map.AreaEffect.AreaEffect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zach on 4/7/16.
 */
public class Tile {
    private List<Entity> entities;
    private List<Item> items;
    private List<AreaEffect> areaEffects;
//    private Flow flow;

    public Tile(){
        this.entities = new ArrayList<>();
        this.items = new ArrayList<>();
        this.areaEffects = new ArrayList<>();
    }

    public void addEntity(Entity e){
        entities.add(e);
    }

    public void addItem(Item i){
        items.add(i);
    }

    public void addAE(AreaEffect ae){
        areaEffects.add(ae);
    }

    public void removeEntity(Entity e){
        entities.remove(e);
    }

    public void removeItem(Item i){
        items.remove(i);
    }

    public void removeAE(AreaEffect ae){
        areaEffects.remove(ae);
    }

    public void interact(Entity e){

	}

    public Iterator<Entity> getEntities(){
        return entities.iterator();
    }
}


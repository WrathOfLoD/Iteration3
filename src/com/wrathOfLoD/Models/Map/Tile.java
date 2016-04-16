package com.wrathOfLoD.Models.Map;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Models.LocationTracker.LocationTrackerManager;
import com.wrathOfLoD.Models.Map.AreaEffect.AreaEffect;
import com.wrathOfLoD.Models.Map.Terrain.Ground;
import com.wrathOfLoD.Models.Map.Terrain.Sky;
import com.wrathOfLoD.Models.Map.Terrain.Terrain;
import com.wrathOfLoD.Models.Map.Terrain.Water;
import com.wrathOfLoD.VisitorInterfaces.TileVisitor;
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
    private Terrain terrain;
//    private Flow flow;

    public Tile(){
        this.entities = new ArrayList<>();
        this.items = new ArrayList<>();
        this.areaEffects = new ArrayList<>();
        this.terrain = new Ground();
    }

    public Tile(Terrain terrain){
        this.entities = new ArrayList<>();
        this.items = new ArrayList<>();
        this.areaEffects = new ArrayList<>();
        this.terrain = terrain;
    }

    /*
    public Tile createSkyTile(){
        return new Tile(new Sky());
    }

    public Tile createGroundTile(){
        return new Tile(new Ground());
    }

    public Tile createWaterTile(){
        return new Tile(new Water());
    }*/

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


    public Iterator<Entity> getEntities() {
        return entities.iterator();
    }

    public void accept(TileVisitor tileVisitor){
        tileVisitor.visitTile(this);

    }

    public Entity[] getEntitiesArray(){
        return entities.toArray(new Entity[entities.size()]);
    }

    public Item[] getItems(){
        return items.toArray(new Item[items.size()]);
    }

    public AreaEffect[] getAreaEffects(){
        return areaEffects.toArray(new AreaEffect[areaEffects.size()]);
    }

    public Terrain getTerrain(){
        return terrain;
    }
}


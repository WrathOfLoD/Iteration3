package com.wrathOfLoD.Models.Map;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Models.Map.AreaEffect.AreaEffect;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.VisitorInterfaces.MapVisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zach on 4/7/16.
 */
public class MapArea{
    private HashMap<Position, TilePillar> tilePillarMap;
	private String mapAreaName;

    public MapArea(){
        this.tilePillarMap = new HashMap<Position, TilePillar>();
    }

	public MapArea(String mapAreaName){
		this.tilePillarMap = new HashMap<Position, TilePillar>();
		this.mapAreaName = mapAreaName;
	}

	public boolean hasTilePillarAt(Position pos){
		TilePillar pillar = getTilePillar(pos);
		if(pillar != null){
			return true;
		}
		else{
			return false;
		}
	}

	public TilePillar getTilePillar(Position pos){
		TilePillar pillar = this.tilePillarMap.get(pos.get2DProjection());
		return pillar;
	}

	public boolean hasTileAt(Position pos){
		if(this.hasTilePillarAt(pos)){
			TilePillar pillar = getTilePillar(pos);
			return pillar.hasTileAt(pos);
		}
		else{
			return false;
		}
	}

	public void addTilePillar(Position pos, TilePillar tilePillar){
		//h=0
		tilePillarMap.put(pos.get2DProjection(), tilePillar);
	}

    public Tile getTile(Position pos) {
        TilePillar pillar = getTilePillar(pos);
		return pillar.getTile(pos);
    }

    public List<Tile> getTiles(List<Position> pList) {
        List<Tile> tiles = new ArrayList<>();

        pList.stream()
             .forEach(p -> tiles.add(this.getTile(p)));

        return tiles;
    }



	public void accept(MapVisitor mapVisitor){
		mapVisitor.visitMapArea(this);
	}


	/************ Setters & Getters *************/
	public HashMap<Position, TilePillar> getTilePillarMap() {
		return tilePillarMap;
	}

	public void setTilePillarMap(HashMap<Position, TilePillar> tilePillarMap) {
		this.tilePillarMap = tilePillarMap;
	}

	public String getMapAreaName() {
		return mapAreaName;
	}

	public void setMapAreaName(String mapAreaName) {
		this.mapAreaName = mapAreaName;
	}
	/************ END Setters & Getters *************/



	/********** Forward to Tile ***************/
	public void addEntity(Entity entity, Position pos){
		TilePillar pillar = getTilePillar(pos);
		pillar.addEntity(entity, pos);
	}

	public void addItem(Item item, Position pos){
		TilePillar pillar = getTilePillar(pos);
		pillar.addItem(item, pos);
	}

	public void addAE(AreaEffect ae, Position pos){
		TilePillar pillar = getTilePillar(pos);
		pillar.addAE(ae, pos);
	}

	public void removeEntity(Entity entity, Position pos){
		TilePillar pillar = getTilePillar(pos);
		pillar.removeEntity(entity, pos);
	}

	public void removeItem(Item item, Position pos){
		TilePillar pillar = getTilePillar(pos);
		pillar.removeItem(item, pos);
	}

	public void removeAE(AreaEffect ae, Position pos){
		TilePillar pillar = getTilePillar(pos);
		pillar.removeAE(ae, pos);
	}

	public void removeTrap(Position pos){
		TilePillar pillar = getTilePillar(pos);
		pillar.removeTrap(pos);
	}
	/********** END Forward to Tile ***************/
}

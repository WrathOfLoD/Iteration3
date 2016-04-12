package com.wrathOfLoD.Models.Map;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Models.Map.AreaEffect.AreaEffect;
import com.wrathOfLoD.Utility.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zach on 4/7/16.
 */
public class MapArea{
    private HashMap<Position, TilePillar> tilePillarMap;

    public MapArea(){
        this.tilePillarMap = new HashMap<Position, TilePillar>();
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
		TilePillar pillar = getTilePillar(pos);
		if(pillar != null){
			return pillar.hasTileAt(pos);
		}
		else{
			return false;
		}
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

}

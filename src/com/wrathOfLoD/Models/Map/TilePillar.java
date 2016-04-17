package com.wrathOfLoD.Models.Map;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Models.Map.AreaEffect.AreaEffect;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.VisitorInterfaces.MapVisitor;

/**
 * Created by zach on 4/7/16.
 */
public class TilePillar{

	private static final int PILLAR_HEIGHT = 10;
    private Tile[] tiles;
    private int horizon;
    private boolean discovered;
    private boolean visible;
	private int groundLevel; //TODO: for movement, any alternative???

    public TilePillar() {
        // 10 is height of a TilePillar, 0-9
        this.tiles = new Tile[PILLAR_HEIGHT];
		this.horizon = 0;
		this.discovered = false;
		this.visible = false;
    }

	public TilePillar(Tile[] tiles, boolean discovered, boolean visible){
		init(tiles, discovered, visible);
	}

	public void init(Tile[] tiles, boolean discovered, boolean visible){
		if(tiles.length != PILLAR_HEIGHT){
			throw new IllegalArgumentException("Illegal number of Tiles. Must be: " + PILLAR_HEIGHT);
		}
		this.tiles = tiles;
		this.discovered = discovered;
		this.visible = visible;
	}

	public boolean isDiscovered(){
		return discovered;
	}

	public boolean isVisible(){
		return visible;
	}

	public boolean hasTileAt(Position pos){
		if(pos.getH() >= 0 && pos.getH() < PILLAR_HEIGHT){
			return (tiles[pos.getH()] != null);
		}
		else{
			return false;
		}
	}

	public void addTile(int index, Tile t){
		if(index < 0 || index >= PILLAR_HEIGHT){
			throw new IllegalArgumentException("Illegal index for tile");
		}else{
			tiles[index] = t;
		}
	}

    public Tile getTile(Position pos){
        return this.tiles[pos.getH()];
    }

	public Tile[] getTiles() {
		return tiles;
	}

	public int getGroundLevel() {
		return groundLevel;
	}

	public void setGroundLevel(int groundLevel) {
		this.groundLevel = groundLevel;
	}

	public void accept(MapVisitor mv){
		mv.visitTileColumn(this);
	}


	/********** Forward request to tile *************/
	public void addEntity(Entity entity, Position pos){
		Tile tile = getTile(pos);
		tile.addEntity(entity);
	}

	public void addItem(Item item, Position pos){
		Tile tile = getTile(pos);
		tile.addItem(item);
	}

	public void addAE(AreaEffect ae, Position pos){
		Tile tile = getTile(pos);
		tile.addAE(ae);
	}

	public  void addTrap(Trap trap, Position pos){
		Tile tile = getTile(pos);
		tile.setTrap(trap);
	}

	public void removeEntity(Entity entity, Position pos){
		Tile tile = getTile(pos);
		tile.removeEntity(entity);
	}

	public void removeItem(Item item, Position pos){
		Tile tile = getTile(pos);
		tile.removeItem(item);
	}

	public void removeAE(AreaEffect ae, Position pos){
		Tile tile = getTile(pos);
		tile.removeAE(ae);
	}

	public void removeTrap(Position pos){
		Tile tile = getTile(pos);
		tile.removeTrap();
	}
	/********** END Forward request to tile *************/
}

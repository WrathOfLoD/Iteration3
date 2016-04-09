package com.wrathOfLoD.Utility;

import java.util.List;

/**
 * Created by Mitchell on 4/7/2016.
 */
public enum Direction {

	DOWN(0, 0, 0, -1),
	DOWN_NORTH(0, -1, 1, -1),
	DOWN_NORTH_EAST(1, -1, 0, -1),
	DOWN_SOUTH_EAST(1, 0, -1, -1),
	DOWN_SOUTH(0, 1, -1, -1),
	DOWN_SOUTH_WEST(-1, 1, 0, -1),
	DOWN_NORTH_WEST(-1, 0, 1, -1),

	CENTER(0, 0, 0, 0), //the useless direction that I want to put there anyway
	NORTH(0, -1, 1, 0),
	NORTH_EAST(1, -1, 0, 0),
	SOUTH_EAST(1, 0, -1, 0),
	SOUTH(0, 1, -1, 0),
	SOUTH_WEST(-1, 1, 0, 0),
	NORTH_WEST(-1, 0, 1, 0),

	UP(0, 0, 0, 1),
	UP_NORTH(0, -1, 1, 1),
	UP_NORTH_EAST(1, -1, 0, 1),
	UP_SOUTH_EAST(1, 0, -1, 1),
	UP_SOUTH(0, 1, -1, 1),
	UP_SOUTH_WEST(-1, 1, 0, 1),
	UP_NORTH_WEST(-1, 0, 1, 1);

	private int qMod;
	private int rMod;
	private int sMod;
	private int hMod;

	Direction(int qMod, int rMod, int sMod, int hMod){
		this.qMod = qMod;
		this.rMod = rMod;
		this.sMod = sMod;
		this.hMod = hMod;
	}

	public Position getPosVector(){
		return new Position(this.qMod, this.rMod, this.sMod, this.hMod);
	}

	public Direction clockwise(){
		if(this.ordinal() % 7 == 0){
			return this;
		}
		else{
			int centerPlane = (this.ordinal()/7)*7;
			int nextOrdinal = (((this.ordinal()-centerPlane) + 1) % 6) + centerPlane;
			return values()[nextOrdinal];
		}
	}

	public Direction counterClockwise(){
		if(this.ordinal() % 7 == 0){
			return this;
		}
		else{
			int centerPlane = (this.ordinal()/7)*7;
			int nextOrdinal = (((this.ordinal()-centerPlane) - 1) % 6) + centerPlane;
			return values()[nextOrdinal];
		}
	}

	public Direction above(){
		if(this.ordinal() + 7 >= values().length){
			return this;
		}
		else{
			return values()[this.ordinal() + 7];
		}
	}

	public Direction below(){
		if(this.ordinal() - 7 < 0){
			return this;
		}
		else{
			return values()[this.ordinal() - 7];
		}
	}

	public Direction planar(){
		if(this.ordinal() < 7){
			return values()[this.ordinal() + 7];
		}
		else if(this.ordinal() > 14){
			return values()[this.ordinal() - 7];
		}
		else{
			return this;
		}
	}

}

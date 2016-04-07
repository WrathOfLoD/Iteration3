package com.wrathOfLoD.Utility;

/**
 * Created by Mitchell on 4/7/2016.
 */
public enum Direction{

	CENTER(0, 0, 0, 0),
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
	UP_NORTH_WEST(-1, 0, 1, 1),

	DOWN(0, 0, 0, -1),
	DOWN_NORTH(0, -1, 1, -1),
	DOWN_NORTH_EAST(1, -1, 0, -1),
	DOWN_SOUTH_EAST(1, 0, -1, -1),
	DOWN_SOUTH(0, 1, -1, -1),
	DOWN_SOUTH_WEST(-1, 1, 0, -1),
	DOWN_NORTH_WEST(-1, 0, 1, -1);

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

}

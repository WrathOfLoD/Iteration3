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

	public boolean matches(int matchQ, int matchR, int matchS, int matchH){
		return (this.qMod == matchQ) &&
				(this.rMod == matchR) &&
				(this.sMod == matchS) &&
				(this.hMod == matchH);
	}

	public Position getPosVector(){
		return new Position(this.qMod, this.rMod, this.sMod, this.hMod);
	}

	// for less breakable solution:
	// http://www.redblobgames.com/grids/hexagons/#rotation
	// http://stackoverflow.com/a/7888655
	public Direction clockwise(){
		int clockQ = -1 * this.sMod;
		int clockR = -1 * this.qMod;
		int clockS = -1 * this.rMod;
		int clockH = this.hMod;
		for(Direction dir : values()){
			if(dir.matches(clockQ, clockR, clockS, clockH)){
				return dir;
			}
		}
		throw new EnumConstantNotPresentException(Direction.class, "Could not find clockwise of " + this.name());
	}

	public Direction counterClockwise(){
		int cClockQ = -1 * this.rMod;
		int cClockR = -1 * this.sMod;
		int cClockS = -1 * this.qMod;
		int cClockH = this.hMod;
		for(Direction dir : values()){
			if(dir.matches(cClockQ, cClockR, cClockS, cClockH)){
				return dir;
			}
		}
		throw new EnumConstantNotPresentException(Direction.class, "Could not find counterClockwise of " + this.name());
	}

	public Direction above(){
		int aboveQ = this.sMod;
		int aboveR = this.qMod;
		int aboveS = this.rMod;
		int aboveH = Math.min(this.hMod + 1, 1);
		for(Direction dir : values()){
			if(dir.matches(aboveQ, aboveR, aboveS, aboveH)){
				return dir;
			}
		}
		throw new EnumConstantNotPresentException(Direction.class, "Could not find above of " + this.name());
	}

	public Direction below(){
		int belowQ = this.sMod;
		int belowR = this.qMod;
		int belowS = this.rMod;
		int belowH = Math.max(this.hMod - 1, -1);
		for(Direction dir : values()){
			if(dir.matches(belowQ, belowR, belowS, belowH)){
				return dir;
			}
		}
		throw new EnumConstantNotPresentException(Direction.class, "Could not find below of " + this.name());
	}

	public Direction planar(){
		int planarQ = this.qMod;
		int planarR = this.rMod;
		int planarS = this.sMod;
		int planarH = 0;
		for(Direction dir : values()){
			if(dir.matches(planarQ, planarR, planarS, planarH)){
				return dir;
			}
		}
		throw new EnumConstantNotPresentException(Direction.class, "Could not find planar of " + this.name());
	}

	public Direction inversePlanar(){
		int iPQ = -1 * this.sMod;
		int iPR = -1 * this.qMod;
		int iPS = -1 * this.rMod;
		int iPH = this.hMod;
		for(Direction dir : values()){
			if(dir.matches(iPQ, iPR, iPS, iPH)){
				return dir;
			}
		}
		throw new EnumConstantNotPresentException(Direction.class, "Could not find inversePlanar of " + this.name());
	}

	public Direction inverseSpatial(){
		int iSQ = -1 * this.sMod;
		int iSR = -1 * this.qMod;
		int iSS = -1 * this.rMod;
		int iSH = -1 * this.hMod;
		for(Direction dir : values()){
			if(dir.matches(iSQ, iSR, iSS, iSH)){
				return dir;
			}
		}
		throw new EnumConstantNotPresentException(Direction.class, "Could not find inverseSpatial of " + this.name());
	}

}

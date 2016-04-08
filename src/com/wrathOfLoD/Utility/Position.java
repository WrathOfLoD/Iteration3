package com.wrathOfLoD.Utility;

/**
 * Created by Mitchell on 4/7/2016.
 */
public class Position{

	private int q;
	private int r;
	private int s;
	private int h;

	public Position(int q, int r, int s, int h){
		if(q + r + s != 0){
			throw new IllegalArgumentException("Invalid Position property: (q + r + s = 0) required");
		}
		this.q = q;
		this.r = r;
		this.s = s;
		this.h = h;
	}

	public Position(int q, int r, int h){
		this.q = q;
		this.r = r;
		this.s = -1 * (q + r);
		this.h = h;
	}

	public int getQ(){
		return q;
	}

	public int getR(){
		return r;
	}

	public int getS(){
		return s;
	}

	public int getH(){
		return h;
	}

	@Override
	public boolean equals(Object obj){
		Position pos = (Position) obj;
		if(this.getQ() == pos.getQ() &&
				this.getR() == pos.getR() &&
				this.getS() == pos.getS() &&
				this.getH() == pos.getH()){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public int hashCode(){
		int prime1 = 199;
		int prime2 = 157;
		int hash = prime1;
		hash = (hash * prime2) + this.getQ();
		hash = (hash * prime2) + this.getR();
		hash = (hash * prime2) + this.getS();
		hash = (hash * prime2) + this.getH();
		return hash;
	}

	public int getDistance(Position pos){
		int distanceHorz = Math.abs((this.getQ() - pos.getQ()) +
				(this.getR() - pos.getR()) + (this.getS() - pos.getS()));
		int distanceVert = Math.abs(this.getH() - pos.getH());
		return distanceHorz + distanceVert;
	}

	public Position getPosInDir(Direction dir){
		return dir.getPosInDir(this);
	}

	public Position get2DProjection(){
		return new Position(this.getQ(), this.getR(), this.getS(), 0);
	}

}

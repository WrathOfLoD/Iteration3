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
		if(h > 9 || h < 0){
			throw new IllegalArgumentException("Invalid Position property: (0 <= h < 10) required");
		}
		this.q = q;
		this.r = r;
		this.s = s;
		this.h = h;
	}

	public Position(int q, int r, int h){
		if(h > 9 || h < 0){
			throw new IllegalArgumentException("Invalid Position property: (0 <= h < 10) required");
		}
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

	public Position get2DPosition() {
		return new Position(this.getQ(), this.getS(), 0);
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
		hash *= this.getQ() * prime2;
		hash *= this.getR() * prime2;
		hash *= this.getS() * prime2;
		hash *= this.getH() * prime2;
		return hash;
	}

}

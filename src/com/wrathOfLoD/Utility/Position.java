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

	public static Position copyOf(Position pos){
		return new Position(pos.getQ(), pos.getR(), pos.getS(), pos.getH());
	}

	public void modifyPosition(Position target){
		this.q = target.getQ();
		this.r = target.getR();
		this.s = target.getS();
		this.h = target.getH();
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

	public static Position vectorAdd(Position a, Position b){
		int abQ = a.getQ() + b.getQ();
		int abR = a.getR() + b.getR();
		int abS = a.getS() + b.getS();
		int abH = a.getH() + b.getH();
		return new Position(abQ, abR, abS, abH);
	}

	public static Position vectorSubtract(Position a, Position b){
		int abQ = a.getQ() - b.getQ();
		int abR = a.getR() - b.getR();
		int abS = a.getS() - b.getS();
		int abH = a.getH() - b.getH();
		return new Position(abQ, abR, abS, abH);
	}

	public static Position scalarMultiply(Position a, int c){
		int acQ = a.getQ() * c;
		int acR = a.getR() * c;
		int acS = a.getS() * c;
		int acH = a.getH() * c;
		return new Position(acQ, acR, acS, acH);
	}

	public int getDistance(Position pos){
		int distanceHorz = Math.abs((this.getQ() - pos.getQ()) +
				(this.getR() - pos.getR()) + (this.getS() - pos.getS()));
		int distanceVert = Math.abs(this.getH() - pos.getH());
		return distanceHorz + distanceVert;
	}

	public Position getPosInDir(Direction dir){
		return vectorAdd(this, dir.getPosVector());
	}

	public Position get2DProjection(){
		return new Position(this.getQ(), this.getR(), this.getS(), 0);
	}



}

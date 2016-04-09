package com.wrathOfLoD.Utility;

import java.util.ArrayList;
import java.util.List;

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

	public static Position scalarMultiply(Position a, float c){
		float acQ = a.getQ() * c;
		float acR = a.getR() * c;
		float acS = a.getS() * c;
		float acH = a.getH() * c;
		return roundPosition(acQ, acR, acS, acH);
	}

	private static Position roundPosition(float qf, float rf, float sf, float hf){
		int q = Math.round(qf);
		int r = Math.round(rf);
		int s = Math.round(sf);
		int h = Math.round(hf);
		return new Position(q, r, s, h);
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

	//drawing shapes :D

	//drawing a line in a straight direction
	public static List<Position> drawLine(Position origin, Direction dir, int range, boolean includeOrigin){

		Position deltaVector = scalarMultiply(dir.getPosVector(), range);
		Position target = vectorAdd(origin, deltaVector);

		return drawline(origin, target, range, includeOrigin);
	}

	//drawing a line at a target in 3D space
	public static List<Position> drawline(Position origin, Position target, int range, boolean includeOrigin){
		List<Position> line = new ArrayList<Position>();

		if(includeOrigin){
			line.add(origin);
		}
		int totalDist = origin.getDistance(target);
		for(float f = 1; f <= range; f++){
			float deltaQ = (target.getQ() - origin.getQ()) * f;
			float deltaR = (target.getR() - origin.getR()) * f;
			float deltaS = (target.getS() - origin.getS()) * f;
			float deltaH = (target.getH() - origin.getH()) * f;
			Position deltaPos = roundPosition(deltaQ, deltaR, deltaS, deltaH);
			line.add(vectorAdd(origin, deltaPos));
		}

		return line;
	}

}

package com.wrathOfLoD.Utility;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitchell on 4/7/2016.
 */
public class Position{

	private int q = 0;
	private int r = 0;
	private int s = 0;
	private int h = 0;


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

	public Position() {
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

		//check that the invariant will still hold after rounding
		if(Math.abs(qf - q) > Math.abs(rf - r) && Math.abs(qf - q) > Math.abs(sf - s)){
			q = -1 * (r + s);
		}
		else if(Math.abs(rf - r) > Math.abs(sf - s)){
			r = -1 * (q + s);
		}
		else{
			s = -1 * (q + r);
		}

		return new Position(q, r, s, h);
	}

	public int getDistance(Position pos){
		int distanceHorz = Math.abs((this.getQ() - pos.getQ()) +
				(this.getR() - pos.getR()) + (this.getS() - pos.getS()));
		int distanceVert = Math.abs(this.getH() - pos.getH());
		return distanceHorz + distanceVert;
	}

	public int getHorizontalDist(Position pos){
		return Math.abs((this.getQ() - pos.getQ()) +
				(this.getR() - pos.getR()) + (this.getS() - pos.getS()));
	}
	public Position getPosInDir(Direction dir){
		return vectorAdd(this, dir.getPosVector());
	}

	public Position get2DProjection(){
		return new Position(this.getQ(), this.getR(), this.getS(), 0);
	}

	//drawing shapes :D

	//drawing a line in a straight direction
	//spatial
	public static List<Position> drawLine(Position origin, Direction dir, int range, boolean includeOrigin){

		Position deltaVector = scalarMultiply(dir.getPosVector(), range);
		Position target = vectorAdd(origin, deltaVector);

		return drawline(origin, target, range, includeOrigin);
	}

	//drawing a line to a target
	//spatial
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

	//drawing a fan (can be horizontal or vertical)
	//planar (horizontal or vertical)
	public static List<Position> drawFan(Position origin, Direction dir, boolean horizontal, int range, boolean includeOrigin){
		List<Position> fan = new ArrayList<Position>();

		if(includeOrigin){
			fan.add(origin);
		}

		for(int i = 1; i < range; i++){
			List<Position> wave  = drawArc(origin, dir, horizontal, i);
			fan.addAll(wave);
		}

		return fan;
	}

	//drawing an arc (slice of a fan )
	//planar (horizontal or vertical)
	public static List<Position> drawArc(Position origin, Direction dir, boolean horizontal, int range){
		List<Position> arc = new ArrayList<Position>();

		dir = dir.planar(); //REVIEW, do I need this?
		Position rightVector;
		Position leftVector;

		if(horizontal){
			rightVector = dir.counterClockwise().inversePlanar().getPosVector();
			leftVector = dir.clockwise().inversePlanar().getPosVector();
		}
		else{
			rightVector = dir.above().getPosVector();
			leftVector = dir.below().getPosVector();
		}

		Position arcCenter = vectorAdd(origin, scalarMultiply(dir.getPosVector(), range));
		arc.add(arcCenter);
		for(int i = 1; i < range/2; i++){
			Position arcRight = vectorAdd(arcCenter, scalarMultiply(rightVector, i));
			arc.add(arcRight);
			Position arcLeft = vectorAdd(arcCenter, scalarMultiply(leftVector, i));
			arc.add(arcLeft);
		}

		return arc;
	}


	public void setH(int h) {
		this.h = h;
	}

	public Point positionToXY(){
		double x = (3.0/2.0) * this.getQ() + (0 * this.getR());
		double y = ((Math.sqrt(3)/2.0) * this.getQ()) + (Math.sqrt(3) * this.getR()) - ((5/39) * this.getH());
		return new Point((int) x, (int) y);
	}

}

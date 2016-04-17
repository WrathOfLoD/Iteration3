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
		int distanceHorz = getHorizontalDist(pos);
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
		System.out.println("*********The telltale arc************");
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
		System.out.printf("Arc rightVector: (%d,%d,%d,%d)%n", rightVector.getQ(), rightVector.getR(), rightVector.getS(), rightVector.getH());
		System.out.printf("Arc leftVector: (%d,%d,%d,%d)%n", leftVector.getQ(), leftVector.getR(), leftVector.getS(), leftVector.getH());

		Position arcCenter = vectorAdd(origin, scalarMultiply(dir.getPosVector(), range));
		arc.add(arcCenter);
		System.out.printf("Arc arcCenter: (%d,%d,%d,%d)%n", arcCenter.getQ(), arcCenter.getR(), arcCenter.getS(), arcCenter.getH());
		for(int i = 1; i <= range/2; i++){
			Position arcRight = vectorAdd(arcCenter, scalarMultiply(rightVector, i));
			arc.add(arcRight);
			System.out.printf("ArcRight[%d]: (%d,%d,%d,%d)%n", i, arcRight.getQ(), arcRight.getR(), arcRight.getS(), arcRight.getH());
			Position arcLeft = vectorAdd(arcCenter, scalarMultiply(leftVector, i));
			arc.add(arcLeft);
			System.out.printf("ArcLeft[%d]: (%d,%d,%d,%d)%n", i, arcLeft.getQ(), arcLeft.getR(), arcLeft.getS(), arcLeft.getH());
		}
		System.out.println("**********Finished arc****************");
		return arc;
	}

//	TODO: prism effects one or more concentric vertical columns of hextiles.
//	TODO: (hemi-)conical effects (e.g., shotgun blast) approximates an expanding 60° cone centered on the direction the unit is targeting
//	TODO: (hemi)spherical (e.g., bomb blast) 360° expanding effect (targeting independent)

	public Point positionToXY(){
		double x = (3.0/2.0) * this.getQ() + (0 * this.getR());
		x *= 43;
		double y = ((Math.sqrt(3)/2.0) * this.getQ()) + (Math.sqrt(3) * this.getR());
		y *= 23;
		y -= ((20.0) * this.getH());
		return new Point((int) x, (int) y);
	}

    public static Direction getDirectionFromPostoPos(Position source, Position dest){
        Position vector = vectorSubtract(dest, source);
		int unitQ = vector.getQ();
		int unitR = vector.getR();
		int unitS = vector.getS();
		int unitH = Integer.signum(vector.getH());
		if(Math.abs(unitQ) >= Math.abs(unitR) && Math.abs(unitQ) >= Math.abs(unitS)){
			unitQ = Integer.signum(unitQ);
			if(Math.abs(unitR) >= Math.abs(unitS)){
				unitR = Integer.signum(unitR);
				unitS = -1 * (unitQ + unitR);
			}
			else{
				unitS = Integer.signum(unitS);
				unitR = -1 * (unitQ + unitS);
			}
		}
		else if(Math.abs(unitR) >= Math.abs(unitS)){
			unitR = Integer.signum(unitR);
			if(Math.abs(unitQ) >= Math.abs(unitS)){
				unitQ = Integer.signum(unitQ);
				unitS = -1 * (unitQ + unitR);
			}
			else{
				unitS = Integer.signum(unitS);
				unitQ = -1 * (unitR + unitS);
			}
		}
		else{
			unitS = Integer.signum(unitS);
			if(Math.abs(unitQ) >= Math.abs(unitR)){
				unitQ = Integer.signum(unitQ);
				unitR = -1 * (unitQ + unitS);
			}
			else{
				unitR = Integer.signum(unitR);
				unitQ = -1 * (unitR + unitS);
			}
		}
		//Position unit = new Position(unitQ, unitR, unitS, unitH);
		for(Direction dir: Direction.values()){
			if(dir.matches(unitQ, unitR, unitS, unitH)){
				return dir;
			}
		}
//		System.out.println("Can't find a direction that matches, wtf?!?!");
		return Direction.SOUTH;
    }

}

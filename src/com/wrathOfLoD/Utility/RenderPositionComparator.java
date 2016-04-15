package com.wrathOfLoD.Utility;

import java.util.Comparator;

/**
 * Created by Mitchell on 4/13/2016.
 */
public class RenderPositionComparator implements Comparator<Position>{
	
	@Override
	public int compare(Position pos1, Position pos2){

		if(pos1.getR() == pos2.getR()){
			if(pos1.getQ() == pos2.getQ()){
				return pos2.getH() - pos1.getH();
			}
			else{
				return pos2.getQ() - pos1.getQ();
			}
		}
		else{
			return pos2.getR() - pos1.getR();
		}

	}

}

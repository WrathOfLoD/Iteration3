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
				return pos1.getH() - pos2.getH();
			}
			else{
				return pos1.getQ() - pos2.getQ();
			}
		}
		else{
			return pos1.getR() - pos2.getR();
		}

	}

}

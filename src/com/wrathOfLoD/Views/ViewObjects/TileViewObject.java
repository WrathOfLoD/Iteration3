package com.wrathOfLoD.Views.ViewObjects;

import com.sun.tools.internal.xjc.model.Model;
import com.sun.tools.internal.xjc.reader.RawTypeSet;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.Tile;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.SpriteMap.ImageAnimation;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Mitchell on 4/12/2016.
 */
public class TileViewObject extends ViewObject{

	private Tile tile;
	private Position pos;

	private ArrayList<ModelViewObject> modelVOList;

	public TileViewObject(Position pos, ImageAnimation animation){
		this.pos = pos;
		this.tile = Map.getInstance().getTile(pos);
		modelVOList = new ArrayList<>();
	}

	public void paintComponent(Graphics g, int x, int y, int width, int height) {
		//super.paintComponent(g);
		//g.drawImage(this.getImage(), x, y, width, height, this);

		//TODO: ???
		for(ModelViewObject mvo : modelVOList){
			mvo.paintComponents(g);
		}
	}


	public void addMOVToTile(ModelViewObject mvo){
		modelVOList.add(mvo);
	}

	public void removeMOVFromTile(ModelViewObject mvo){
		modelVOList.remove(mvo);
	}



}

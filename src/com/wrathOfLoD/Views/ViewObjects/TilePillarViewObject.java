package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.Tile;
import com.wrathOfLoD.Models.Map.TilePillar;
import com.wrathOfLoD.Utility.Position;

import java.awt.*;
import java.util.List;

/**
 * Created by Mitchell on 4/12/2016.
 */
public class TilePillarViewObject extends ViewObject{

	private TilePillar tilePillar;
	private Position pos;

	private List<TileViewObject> tileViewObjects;

	public TilePillarViewObject(Position pos){
		this.pos = pos;
		this.tilePillar = Map.getInstance().getTilePillar(pos);
	}

	public void paintComponent(Graphics g, int x, int y, int width, int height) {
		for(TileViewObject tvo : tileViewObjects){
			tvo.paintComponent(g, pos.getQ(), pos.getR(), 20, 20);
		}
	}

	public Position getPosition(){
		return this.pos;
	}

}

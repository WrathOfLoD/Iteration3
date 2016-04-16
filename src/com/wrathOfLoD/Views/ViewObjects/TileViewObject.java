package com.wrathOfLoD.Views.ViewObjects;

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
		setImage(animation.getFrame()); //terrain
	}

	public void paintComponent(Graphics g, int x, int y, int h, Point screenCenter) {
		//super.paintComponent(g);
		this.setOffsetX(x);
		this.setOffsetY(y - (int)(h * TILE_THICKNESS/this.getImage().getHeight(null)));
		g.drawImage(this.getImage(), this.getOffsetX(), this.getOffsetY(), screenCenter.x, screenCenter.y, null);
//		super.paintComponent(g,x,y,width,height);
		//TODO: ???
		for(ModelViewObject mvo : modelVOList){
			//mvo.paintComponents(g);  ...not calling the right method
		}
	}

	public void addMOVToTile(ModelViewObject mvo){
		modelVOList.add(mvo);
	}

	public void removeMOVFromTile(ModelViewObject mvo){
		modelVOList.remove(mvo);
	}

}

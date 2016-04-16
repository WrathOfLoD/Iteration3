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
	private ArrayList<ModelViewObject> modelVOList;

	public TileViewObject(Tile tile, ImageAnimation animation){
		this.tile = tile;
		modelVOList = new ArrayList<>();
		setImage(animation.getFrame()); //terrain
	}

	public void paintComponent(Graphics g, int x, int y, int width, int height) {
		//super.paintComponent(g);
		g.drawImage(this.getImage(), x + this.getOffsetX(), y + this.getOffsetY(), width, height, this);
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

package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.Tile;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.SpriteMap.ImageAnimation;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
		//terrain image
		g.drawImage(this.getImage(), x + this.getOffsetX(), y + this.getOffsetY(), width, height, this);

		Collections.sort(modelVOList, new Comparator<ModelViewObject>() {
			@Override
			public int compare(ModelViewObject o1, ModelViewObject o2) {
				return o1.getzOrder() - o2.getzOrder();
			}
		});


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

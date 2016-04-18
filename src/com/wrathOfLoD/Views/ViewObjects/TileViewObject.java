package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.Tile;
import com.wrathOfLoD.Observers.ViewObjectObservers.DestroyableVOObserver;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.SpriteMap.ImageAnimation;
import javafx.geometry.Pos;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

	public void paintComponent(Graphics g, Position cameraCenter, Point screenCenter) {
		//super.paintComponent(g);
		Point offset = Position.vectorSubtract(this.pos, cameraCenter).positionToXY();
		this.setOffsetX(offset.x-40);
		this.setOffsetY(offset.y-90);
		g.drawImage(this.getImage(), this.getOffsetX() + screenCenter.x, this.getOffsetY() + screenCenter.y, 80, 140, null);

		Collections.sort(modelVOList, new Comparator<ModelViewObject>() {
			@Override
			public int compare(ModelViewObject o1, ModelViewObject o2) {
				return o1.getzOrder() - o2.getzOrder();
			}
		});

		for (int i = 0; i < modelVOList.size(); i++){
			ModelViewObject mvo = modelVOList.get(i);
			mvo.paintComponent(g, this.getOffsetX() + screenCenter.x, this.getOffsetY() + screenCenter.y, mvo.getImage().getWidth(null), mvo.getImage().getHeight(null));
		}

//		for(ModelViewObject mvo : modelVOList){
//			mvo.paintComponent(g, this.getOffsetX() + screenCenter.x, this.getOffsetY() + screenCenter.y, mvo.getImage().getWidth(null), mvo.getImage().getHeight(null));
//		}
	}

	public void addMOVToTile(ModelViewObject mvo){
		modelVOList.add(mvo);
	}

	public void removeMOVFromTile(ModelViewObject mvo){
		modelVOList.remove(mvo);
	}

	public Position getPosition(){
		return this.pos;
	}

}

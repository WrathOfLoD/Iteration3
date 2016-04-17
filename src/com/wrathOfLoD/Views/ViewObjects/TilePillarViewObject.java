package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.Tile;
import com.wrathOfLoD.Models.Map.TilePillar;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Utility.RenderPositionComparator;
import javafx.geometry.Pos;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Mitchell on 4/12/2016.
 */
public class TilePillarViewObject extends ViewObject{

	private TilePillar tilePillar;
	private Position pos;

	private HashMap<Position, TileViewObject> tileViewObjects;

	public TilePillarViewObject(Position pos){
		this.pos = pos;
		this.tileViewObjects = new HashMap<>();
		this.tilePillar = Map.getInstance().getTilePillar(pos);
	}

	public void paintComponent(Graphics g, Position cameraCenter, Point screenCenter){
		//if(!tilePillar.isDiscovered()){
		//	return;
		//}
		Point point = Position.vectorSubtract(this.pos, cameraCenter).positionToXY();
		this.setOffsetX(point.x);
		this.setOffsetY(point.y);
		List<Position> renderOrder = new ArrayList<Position>();
		renderOrder.addAll(tileViewObjects.keySet());
		Collections.sort(renderOrder, new RenderPositionComparator());
		for(Position pos: renderOrder){
			TileViewObject tvo = tileViewObjects.get(pos);
			tvo.paintComponent(g, cameraCenter, screenCenter);
		}
		//paintComponent(g);
	}

	@Override
	public void paintComponent(Graphics g){
		//TODO
		if(!tilePillar.isVisible()){
			//TODO draw a big-ass translucent grey rectangle
		}
	}

	public Position getPosition(){
		return this.pos;
	}

	public void addTileVO(Position pos, TileViewObject tvo){
		tileViewObjects.put(pos, tvo);
	}

	public void addVOToTile(Position pos, ModelViewObject mvo){
		tileViewObjects.get(pos).addMOVToTile(mvo);
	}

	public TileViewObject getTileVO(Position position){
		return tileViewObjects.get(position);
	}

	public void removeVOFromTile(Position pos, ModelViewObject mvo){
		tileViewObjects.get(pos).removeMOVFromTile(mvo);
	}



}

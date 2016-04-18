package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.Tile;
import com.wrathOfLoD.Observers.ViewObjectObservers.DestroyableVOObserver;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.SpriteMap.ImageAnimation;
import javafx.geometry.Pos;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
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

	public void paintComponent(Graphics g, Position cameraCenter, Point screenCenter, boolean visible) {
		//super.paintComponent(g);
		Point offset = Position.vectorSubtract(this.pos, cameraCenter).positionToXY();
		this.setOffsetX(offset.x-40);
		this.setOffsetY(offset.y-90);

		Image renderedImage = this.getImage();
		if(!visible){
			//ImageFilter filter = new GrayFilter(true, 50);
			//ImageProducer producer = new FilteredImageSource(this.getImage().getSource(), filter);
			//renderedImage = Toolkit.getDefaultToolkit().createImage(producer);
			BufferedImage image = new BufferedImage(renderedImage.getWidth(null), renderedImage.getHeight(null), BufferedImage.TYPE_BYTE_GRAY);
			Graphics g2 = image.getGraphics();
			g2.setColor(new Color(0f,0f,0f,0.4f));
			g2.drawImage(renderedImage, 0, 0, null);
			//g2.dispose();
			renderedImage = image;
		}
		g.drawImage(renderedImage, this.getOffsetX() + screenCenter.x, this.getOffsetY() + screenCenter.y, 80, 140, null);

		Collections.sort(modelVOList, new Comparator<ModelViewObject>() {
			@Override
			public int compare(ModelViewObject o1, ModelViewObject o2) {
				return o1.getzOrder() - o2.getzOrder();
			}
		});

		for (int i = 0; i < modelVOList.size(); i++){
			ModelViewObject mvo = modelVOList.get(i);
			mvo.paintComponent(g, this.getOffsetX() + screenCenter.x, this.getOffsetY() + screenCenter.y, mvo.getImage().getWidth(null), mvo.getImage().getHeight(null), visible);
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

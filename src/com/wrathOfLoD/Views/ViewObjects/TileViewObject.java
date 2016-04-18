package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.Tile;
import com.wrathOfLoD.Observers.ViewObjectObservers.DestroyableVOObserver;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.ImageFactory.ImageFactory;
import com.wrathOfLoD.Views.SpriteMap.ImageAnimation;
import javafx.geometry.Pos;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
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
	private static Image fog = ImageFactory.generateImage("resources/FogOfWar.png");

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

		g.drawImage(this.getImage(), this.getOffsetX() + screenCenter.x, this.getOffsetY() + screenCenter.y, 80, 140, null);
		//Image renderedImage = this.getImage();
		if(!visible){
			g.drawImage(fog, this.getOffsetX() + screenCenter.x, this.getOffsetY() + screenCenter.y, 80, 140, null);
			/*ImageFilter filter = new RGBImageFilter(){
				@Override
				public int filterRGB(int x, int y, int rgb){
					// Find the average of red, green, and blue.
					float avg = (((rgb >> 16) & 0xff) / 255f +
							((rgb >>  8) & 0xff) / 255f +
							(rgb        & 0xff) / 255f) / 3;
					// Pull out the alpha channel.
					float alpha = (((rgb >> 24) & 0xff) / 255f);

					// Calculate the average.
					// Sun's formula: Math.min(1.0f, (1f - avg) / (100.0f / 35.0f) + avg);
					// The following formula uses less operations and hence is faster.
					avg = Math.min(1.0f, 0.35f + 0.65f * avg);
					// Convert back into RGB.
					return (int) (alpha * 255f) << 24 | (int) (avg   * 255f) << 16 |
							(int) (avg   * 255f) << 8  | (int) (avg   * 255f);
				}
			};
			ImageProducer producer = new FilteredImageSource(this.getImage().getSource(), filter);
			renderedImage = Toolkit.getDefaultToolkit().createImage(producer);
			//BufferedImage image = new BufferedImage(renderedImage.getWidth(null), renderedImage.getHeight(null), BufferedImage.TYPE_BYTE_GRAY);
			//Graphics g2 = image.getGraphics();
			//g2.setColor(new Color(0f,0f,0f,0.4f));
			//g2.drawImage(renderedImage, 0, 0, null);
			////g2.dispose();
			//renderedImage = image;
			*/
		}


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

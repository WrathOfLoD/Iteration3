package com.wrathOfLoD.Views.AreaView;

import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Utility.RenderPositionComparator;
import com.wrathOfLoD.Views.StaticView;
import com.wrathOfLoD.Views.ViewObjects.TilePillarViewObject;
import com.wrathOfLoD.Views.ViewObjects.TileViewObject;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by echristiansen on 4/8/2016.
 */
public class AreaView extends StaticView { //need to change to just extending View, perhaps

    public static final int WIDTH = Config.instance().getAreaViewWidth();
    public static final int HEIGHT = Config.instance().getAreaViewHeight();

	private static Direction areaOrientation;

	private Position cameraCenter;
	private HashMap<Position, TilePillarViewObject> tilePillarViewObjects;

    public AreaView() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackgroundImageFileName("resources/Backgrounds/spaceSloth.png");

		cameraCenter = Avatar.getInstance().getPosition();
    }

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		List<Position> renderOrder = new ArrayList<Position>();
		renderOrder.addAll(tilePillarViewObjects.keySet());
		Collections.sort(renderOrder, new RenderPositionComparator());

		for(Position pos: renderOrder){
			TilePillarViewObject tPVO = tilePillarViewObjects.get(pos);
			tPVO.paint(g);
		}

	}

}

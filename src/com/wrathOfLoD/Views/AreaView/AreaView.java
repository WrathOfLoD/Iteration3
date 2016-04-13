package com.wrathOfLoD.Views.AreaView;

import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.StaticView;
import com.wrathOfLoD.Views.ViewObjects.TileViewObject;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by echristiansen on 4/8/2016.
 */
public class AreaView extends StaticView { //need to change to just extending View, perhaps

    public static final int WIDTH = Config.instance().getAreaViewWidth();
    public static final int HEIGHT = Config.instance().getAreaViewHeight();

	private static Direction areaOrientation;

	private Position cameraCenter;
	private HashMap<Position, TileViewObject> tileViewObjects;

    public AreaView() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackgroundImageFileName("resources/Backgrounds/spaceSloth.png");

		cameraCenter = Avatar.getInstance().getPosition();
    }

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}

}

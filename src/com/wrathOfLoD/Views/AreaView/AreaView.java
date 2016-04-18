package com.wrathOfLoD.Views.AreaView;

import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Map.*;
import com.wrathOfLoD.Observers.ModelObservers.MapObserver;
import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Utility.RenderPositionComparator;
import com.wrathOfLoD.Views.CameraView.CameraView;
import com.wrathOfLoD.Views.CameraView.CameraViewManager;
import com.wrathOfLoD.Views.StaticView;
import com.wrathOfLoD.Views.ViewFactories.ViewObjectFactory.ViewObjectFactory;
import com.wrathOfLoD.Views.ViewObjects.EntityViewObject;
import com.wrathOfLoD.Views.ViewObjects.ModelViewObject;
import com.wrathOfLoD.Views.ViewObjects.TilePillarViewObject;
import com.wrathOfLoD.Views.ViewObjects.TileViewObject;
import javafx.geometry.Pos;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by echristiansen on 4/8/2016.
 */
public class AreaView extends StaticView implements MapObserver{ //need to change to just extending View, perhaps

    public static final int WIDTH = Config.instance().getAreaViewWidth();
    public static final int HEIGHT = Config.instance().getAreaViewHeight();

	private CameraView activeCameraView;
	private CameraViewManager cameraViewManager;

    public AreaView() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackgroundImageFileName("resources/Backgrounds/spaceSloth.png");
    }

	public AreaView(CameraViewManager cvm){
		this();
		setCameraViewManager(cvm);
		setActiveCameraView(cameraViewManager.getActiveCV());
	}


	public void setActiveCameraView(CameraView cv){
		this.activeCameraView = cv;
	}

	public void setCameraViewManager(CameraViewManager cvm){
		this.cameraViewManager = cvm;
	}

	public CameraView getActiveCameraView(){
		return this.activeCameraView;
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//activeCameraView.paintComponent(g);
		activeCameraView.paintComponent(g);
	}

	public void addVOToCV(Position pos, ModelViewObject mvo, MapArea mapArea){
		cameraViewManager.getCV(mapArea).addVOToTile(pos, mvo);
	}

	public TileViewObject getTileVOFromCV(Position pos, MapArea mapArea){
		return cameraViewManager.getCV(mapArea).getTileVO(pos);
	}

	public CameraView getCV(MapArea mapArea){
		return cameraViewManager.getCV(mapArea);
	}

	@Override
	public void notifyMapAreaChange(MapArea ma) {
		cameraViewManager.setActiveCV(ma);
		setActiveCameraView(cameraViewManager.getActiveCV());
		EntityViewObject avo = ViewObjectFactory.getInstance().createAvatarViewObject(Avatar.getInstance().getPosition(), Avatar.getInstance());
	}
}

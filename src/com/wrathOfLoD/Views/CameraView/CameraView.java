package com.wrathOfLoD.Views.CameraView;

import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.StaticView;
import com.wrathOfLoD.Views.ViewObjects.TilePillarViewObject;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Utility.RenderPositionComparator;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by luluding on 4/16/16.
 */
public class CameraView{

    private HashMap<Position, TilePillarViewObject> tilePillarViewObjects;
    private Position cameraCenter;

    public CameraView(){
        cameraCenter = Avatar.getInstance().getPosition();
    }

    public void paintComponent(Graphics g){
        List<Position> renderOrder = new ArrayList<Position>();
        renderOrder.addAll(tilePillarViewObjects.keySet());
        Collections.sort(renderOrder, new RenderPositionComparator());

        for(Position pos: renderOrder){
            TilePillarViewObject tPVO = tilePillarViewObjects.get(pos);

            Position dist = Position.vectorSubtract(tPVO.getPosition(), cameraCenter);

            //tPVO.paintComponent(g);
        }
    }

    public void setTilePillarViewObjects(HashMap<Position, TilePillarViewObject> map) {
        this.tilePillarViewObjects = map;
    }

}

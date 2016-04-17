package com.wrathOfLoD.Views.CameraView;

import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Models.Map.AreaEffect.AreaEffect;
import com.wrathOfLoD.Models.Map.MapArea;
import com.wrathOfLoD.Models.Map.Tile;
import com.wrathOfLoD.Models.Map.TilePillar;
import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.ViewFactories.ViewObjectFactory.ViewObjectFactory;
import com.wrathOfLoD.Views.ViewObjects.ModelViewObject;
import com.wrathOfLoD.Views.StaticView;
import com.wrathOfLoD.Views.ViewFactories.ViewObjectFactory.ViewObjectFactory;
import com.wrathOfLoD.Views.ViewObjects.TilePillarViewObject;
import com.wrathOfLoD.Utility.RenderPositionComparator;
import com.wrathOfLoD.Views.ViewObjects.TileViewObject;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by luluding on 4/16/16.
 */
public class CameraView{

    private HashMap<Position, TilePillarViewObject> tilePillarViewObjects;
    private MapArea mapArea;
    private Position cameraCenter;
    private ViewObjectFactory vof = ViewObjectFactory.getInstance();
    private int frameWidth;
    private int frameHeight;

    public CameraView(MapArea mapArea){
        cameraCenter = Avatar.getInstance().getPosition();
        this.mapArea = mapArea;
        this.tilePillarViewObjects = new HashMap<>();
        this.frameWidth = Config.getAreaViewWidth();
        this.frameHeight = Config.getAreaViewHeight();
        //populateCV();
    }

    public void paintComponent(Graphics g){
        List<Position> renderOrder = new ArrayList<Position>();
        renderOrder.addAll(tilePillarViewObjects.keySet());
        Collections.sort(renderOrder, new RenderPositionComparator());

        for(Position pos: renderOrder){
            TilePillarViewObject tPVO = tilePillarViewObjects.get(pos);
            tPVO.paintComponent(g, cameraCenter, new Point(this.frameWidth/2, this.frameHeight/2));
        }
    }


    public void populateCV(){
        HashMap<Position, TilePillar> tilePillarHashMap = mapArea.getTilePillarMap();

        for(Position pos : tilePillarHashMap.keySet()){
            TilePillarViewObject tpvo = vof.createTilePillarViewObject(pos);
            tilePillarViewObjects.put(pos, tpvo);

            Tile tiles[] = tilePillarHashMap.get(pos).getTiles();
            for(int i = 0; i < tiles.length; i++){
				Position tPos = new Position(pos.getQ(), pos.getR(), i);
                TileViewObject tvo = vof.createTileViewObject(tPos, tiles[i]);
                tpvo.addTileVO(tPos, tvo);
                //System.out.println("add TVO to TPVO: " + pos.getQ() + " " + pos.getR() + " " + i);
                populateTile(tiles[i], tvo);
//                System.out.println("add TVO to TPVO: " + pos.getQ() + " " + pos.getR() + " " + i);
            }
        }

    }

    private void populateTile(Tile t, TileViewObject tvo){
        for(AreaEffect ae : t.getAreaEffects()){
           vof.createAEViewObject(tvo.getPosition(), ae);
        }

        for (Item i : t.getItems()){
            vof.createMapItemViewObject(tvo.getPosition(), i);
            System.out.println("CREATE ITEM GETTING CALLED?");
        }

        for (Entity e : t.getEntitiesArray()){
            vof.createEntityViewObject(tvo.getPosition(), e);
        }

    }


    public void setTilePillarViewObjects(HashMap<Position, TilePillarViewObject> map) {
        this.tilePillarViewObjects = map;
    }

    public void addVOToTile(Position pos, ModelViewObject mvo){
        TilePillarViewObject tpvo = tilePillarViewObjects.get(pos.get2DProjection());
        tpvo.addVOToTile(pos, mvo);
    }

}

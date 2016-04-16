package com.wrathOfLoD.Views.ViewObjectFactory;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Models.Map.AreaEffect.AreaEffect;
import com.wrathOfLoD.Models.Map.Terrain.Terrain;
import com.wrathOfLoD.Models.Map.Tile;
import com.wrathOfLoD.Models.Map.TilePillar;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.AreaView.AreaView;
import com.wrathOfLoD.Views.SpriteMap.ImageAnimation;
import com.wrathOfLoD.Views.ViewObjects.*;
import javafx.geometry.Pos;

/**
 * Created by luluding on 4/16/16.
 */
public class ViewObjectFactory {
    private static ViewObjectFactory instance;
    private AreaView areaView;

    public static ViewObjectFactory getInstance(){
        if(instance == null)
            instance = new ViewObjectFactory();

        return instance;
    }

    //TODO: configure this somewhere
    public void initVOFactory(AreaView areaView){
        this.areaView = areaView;
    }

    public TilePillarViewObject createTilePillarViewObject(Position pos){
        return new TilePillarViewObject(pos);
    }

    public TileViewObject createTileViewObject(Tile tile){
        return null;
    }


    public AreaEffectViewObject createAEViewObject(AreaEffect ae){
        return null;
    }

    public EntityViewObject createEntityViewObject(Entity entity){
        return null;
    }

    public MapItemViewObject createMapItemViewObject(Item item){
        return null;
    }






}

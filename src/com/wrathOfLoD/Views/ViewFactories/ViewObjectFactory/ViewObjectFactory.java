package com.wrathOfLoD.Views.ViewFactories.ViewObjectFactory;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Models.Map.AreaEffect.AreaEffect;
import com.wrathOfLoD.Models.Map.Tile;
import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.AreaView.AreaView;
import com.wrathOfLoD.Views.ImageFactory.ImageFactory;
import com.wrathOfLoD.Views.SpriteMap.ImageAnimation;
import com.wrathOfLoD.Views.SpriteMap.SpriteMap;
import com.wrathOfLoD.Views.ViewObjects.*;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;

/**
 * Created by luluding on 4/16/16.
 */
public class ViewObjectFactory {
    private static ViewObjectFactory instance;
    private AreaView areaView;
    private SpriteMap spriteMap;

    public static ViewObjectFactory getInstance(){
        if(instance == null)
            instance = new ViewObjectFactory();

        return instance;
    }

    //TODO: configure this somewhere!!!
    public void initVOFactory(AreaView areaView){
        this.areaView = areaView;
        //TODO: init the Sprite Map

    }

    public TilePillarViewObject createTilePillarViewObject(Position pos){
        return new TilePillarViewObject(pos);
    }

    public TileViewObject createTileViewObject(Position pos, Tile tile){
        //TODO: hook up with spriteMap
        List<Image> img = new ArrayList<>();
        img.add(ImageFactory.generateImage("resources/SpaceRockTile.png"));

        return new TileViewObject(pos, new ImageAnimation(img));
    }

    public AreaEffectViewObject createAEViewObject(Position pos, AreaEffect ae){
        AreaEffectViewObject aevo = new AreaEffectViewObject(ae, null); //TODO: hook up to sprite map
        areaView.addViewObject(pos, aevo);
        return aevo;
    }

    public EntityViewObject createEntityViewObject(Position pos, Entity entity){
        EntityViewObject evo = new EntityViewObject(entity, null);
        areaView.addViewObject(pos, evo);
        return evo;
    }

    public MapItemViewObject createMapItemViewObject(Position pos, Item item){
        List<Image> img = new ArrayList<>();
        img.add(ImageFactory.generateImage("resources/EquippedItems/hammer.png"));

        MapItemViewObject mivo = new MapItemViewObject(item, new ImageAnimation(img));
        areaView.addViewObject(pos, mivo);
        return mivo;
    }

}

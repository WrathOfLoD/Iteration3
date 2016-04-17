package com.wrathOfLoD.Views.ViewFactories.ViewObjectFactory;

import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Models.Map.AreaEffect.AreaEffect;
import com.wrathOfLoD.Models.Map.Tile;
import com.wrathOfLoD.Models.RangedEffect.HitBox.HitBox;
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
        String terrainName = tile.getTerrain().getName();
        img.add(ImageFactory.generateImage("resources/" + terrainName + ".png"));

        return new TileViewObject(pos, new ImageAnimation(img));
    }

    public AreaEffectViewObject createAEViewObject(Position pos, AreaEffect ae){
        List<Image> img = new ArrayList<>();
        img.add(ImageFactory.generateImage("resources/WaterTile.png"));

        AreaEffectViewObject aevo = new AreaEffectViewObject(ae, new ImageAnimation(img)); //TODO: hook up to sprite map
        areaView.addViewObjectToActiveCV(pos, aevo);
        return aevo;
    }

    public EntityViewObject createEntityViewObject(Position pos, Entity entity){
        List<Image> img = new ArrayList<>();
        img.add(ImageFactory.generateImage("resources/MapItems/Hammer/Hammer.png"));

        EntityViewObject evo = new EntityViewObject(entity, new ImageAnimation(img));
        areaView.addViewObjectToActiveCV(pos, evo);
        entity.registerObserver(evo);
        evo.registerObserver(areaView.getActiveCameraView()); //TODO: gonna cause problem because all map areas are populated at once
        return evo;
    }

    public DestroyableModelViewObject createMapItemViewObject(Position pos, Item item){
        List<Image> img = new ArrayList<>();
        String itemName = item.getName();
        img.add(ImageFactory.generateImage("resources/MapItems/" + itemName+ ".png"));
        DestroyableModelViewObject mivo = new DestroyableModelViewObject(item, new ImageAnimation(img));

        item.registerObserver(mivo);
        mivo.registerObserver(areaView.getTileVOFromActiveCV(pos));

        areaView.addViewObjectToActiveCV(pos, mivo);
        return mivo;
    }

    public HitBoxViewObject createHitBoxViewObject(Position position, HitBox hitBox){
        List<Image> img = new ArrayList<>();
        String hbName = hitBox.getName();
        img.add(ImageFactory.generateImage("resources/Effects/" + hbName + "/" + hbName + ".png"));
        HitBoxViewObject hitBoxViewObject = new HitBoxViewObject(hitBox, new ImageAnimation(img));

        hitBox.registerObserver(hitBoxViewObject);
        hitBoxViewObject.registerObserver(areaView.getTileVOFromActiveCV(position));

        areaView.addViewObjectToActiveCV(position, hitBoxViewObject);
        return hitBoxViewObject;
    }

}

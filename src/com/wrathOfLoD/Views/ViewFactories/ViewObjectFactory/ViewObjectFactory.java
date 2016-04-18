package com.wrathOfLoD.Views.ViewFactories.ViewObjectFactory;

import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Models.Map.AreaEffect.AreaEffect;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.MapArea;
import com.wrathOfLoD.Models.Map.Tile;
import com.wrathOfLoD.Models.RangedEffect.HitBox.HitBox;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.AreaView.AreaView;
import com.wrathOfLoD.Views.ImageFactory.ImageFactory;
import com.wrathOfLoD.Views.SpriteMap.ImageAnimation;
import com.wrathOfLoD.Views.SpriteMap.SpriteMap;
import com.wrathOfLoD.Views.ViewObjects.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
    public void initVOFactory(AreaView areaView) throws IOException{
        this.areaView = areaView;
        this.spriteMap = new SpriteMap();
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

    public AreaEffectViewObject createAEViewObject(Position pos, AreaEffect ae, MapArea mapArea){
        HashMap<String, ImageAnimation> aoeSprites = spriteMap.getAoeMap();
        ImageAnimation img = aoeSprites.get(ae.getName());


        AreaEffectViewObject aevo = new AreaEffectViewObject(ae, img);
        //areaView.addViewObjectToActiveCV(pos, aevo);
        areaView.addVOToCV(pos, aevo, mapArea);
        return aevo;
    }

    public EntityViewObject createEntityViewObject(Position pos, Entity entity, MapArea mapArea){

        List<Image> img = new ArrayList<>();
//        Map<Direction, ImageAnimation> imageAnimationMap = new HashMap<>();
        img.add(ImageFactory.generateImage("resources/Entity/NPC/FoeNPC/South/Walk/walk.png"));
//        img.add(ImageFactory.generateImage("resources/Entity/Avatar/Smasher/Walk/south.png"));
//        img.add(ImageFactory.generateImage("resources/Entity/Avatar/Smasher/Walk/south_west.png"));

        EntityViewObject evo = new EntityViewObject(entity, new ImageAnimation(img), createHealthBarViewObject(entity.getStats().getMaxHealth(), entity.getStats().getCurrentHealth()));
        areaView.addVOToCV(pos, evo, mapArea);
        entity.registerObserver(evo);

        evo.registerObserver(areaView.getCV(mapArea));
        return evo;
    }

    public HealthBarViewObject createHealthBarViewObject(int fullHealth, int currentHealth){
        HealthBarViewObject hbvo = new HealthBarViewObject(fullHealth, currentHealth);
        return hbvo;
    }

    public EntityViewObject createAvatarViewObject(Position pos, Avatar avatar){ //has to be added to the active one
        String occupationType = Avatar.getInstance().getOccupation().getName();

        List<Image> img = new ArrayList<>();
//        img.add(ImageFactory.generateImage("resources/Entity/Avatar/Smasher/Walk/slice19_19.png"));
       // img.add(ImageFactory.generateImage("resources/Entity/Avatar/Summoner/Unequipped/South_East/Walk/summoner1.png"));
        img.add(ImageFactory.generateImage("resources/Entity/Avatar/" + occupationType + "/Unequipped/South/Walk/walk.png"));

        EntityViewObject evo = new EntityViewObject(avatar, new ImageAnimation(img), createHealthBarViewObject(avatar.getStats().getMaxHealth(), avatar.getStats().getCurrentHealth()));

        areaView.addVOToCV(pos, evo, Map.getInstance().getActiveMapArea());
        avatar.registerObserver(evo);
        evo.registerObserver(areaView.getActiveCameraView());
        evo.registerObserver(areaView.getActiveCameraView().getCameraCenter());
        return evo;
    }



    public MapItemViewObject createMapItemViewObject(Position pos, Item item, MapArea mapArea){
        HashMap<String, ImageAnimation> mapItemSprites = spriteMap.getItemMap();
        ImageAnimation img = mapItemSprites.get(item.getName());

        MapItemViewObject mivo = new MapItemViewObject(item, img);

        item.registerObserver(mivo);
        //mivo.registerObserver(areaView.getTileVOFromActiveCV(pos));
        //mivo.registerObserver(areaView.getTileVOFromCV(pos, mapArea));
        mivo.registerObserver(areaView.getActiveCameraView());

        //areaView.addViewObjectToActiveCV(pos, mivo);
        areaView.addVOToCV(pos, mivo, mapArea);
        return mivo;
    }

    public HitBoxViewObject createHitBoxViewObject(Position position, HitBox hitBox, MapArea mapArea){
        HashMap<String, ImageAnimation> effectSprites = spriteMap.getEffectsMap();
        ImageAnimation img = effectSprites.get(hitBox.getName());

        HitBoxViewObject hitBoxViewObject = new HitBoxViewObject(hitBox, img);

        hitBox.registerObserver(hitBoxViewObject);
        //hitBoxViewObject.registerObserver(areaView.getTileVOFromActiveCV(position));
        //hitBoxViewObject.registerObserver(areaView.getTileVOFromCV(position, mapArea));
        hitBoxViewObject.registerObserver(areaView.getActiveCameraView());

        //areaView.addViewObjectToActiveCV(position, hitBoxViewObject);
        areaView.addVOToCV(position, hitBoxViewObject, mapArea);
        return hitBoxViewObject;
    }
}

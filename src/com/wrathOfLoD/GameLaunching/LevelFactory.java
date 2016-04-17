package com.wrathOfLoD.GameLaunching;

import com.wrathOfLoD.GameLaunching.Vendors.AEVendor;
import com.wrathOfLoD.GameLaunching.Vendors.EntityVendor;
import com.wrathOfLoD.GameLaunching.Vendors.ItemVendor;
import com.wrathOfLoD.Models.Entity.Character.NPC;
import com.wrathOfLoD.Models.Entity.EntityCanMoveVisitor.TerrestrialCanMoveVisitor;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.TwoHandWeapon;
import com.wrathOfLoD.Models.Map.AreaEffect.Flow;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.MapArea;
import com.wrathOfLoD.Models.Map.Terrain.Ground;
import com.wrathOfLoD.Models.Map.Terrain.NullTerrain;
import com.wrathOfLoD.Models.Map.Terrain.Sky;
import com.wrathOfLoD.Models.Map.Tile;
import com.wrathOfLoD.Models.Map.TilePillar;
import com.wrathOfLoD.Models.Occupation.Smasher;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.AreaView.AreaView;
import com.wrathOfLoD.Views.CameraView.CameraView;
import com.wrathOfLoD.Views.CameraView.CameraViewManager;
import com.wrathOfLoD.Views.ViewFactories.ViewObjectFactory.ViewObjectFactory;

/**
 * Created by icavitt on 4/12/2016.
 */
public class LevelFactory {

    private CameraViewManager cvm;
    private AreaView areaView;
    private String levelName;
    private ItemVendor itemVendor;
    private EntityVendor entityVendor;
    private AEVendor aeVendor;

    public LevelFactory(String levelName){
        this.levelName = levelName;
        cvm = new CameraViewManager();
        itemVendor = new ItemVendor();
        entityVendor = new EntityVendor();
        aeVendor = new AEVendor();
        areaView = new AreaView(cvm);
    }

    public CameraViewManager getCameraViewManager(){
        return this.cvm;
    }
    public AreaView getAreaView(){
        return this.areaView;
    }

    public void generateMap(){
        switch (levelName){
            case "test_map" :
                createTestMap();
                break;
            default:
                System.out.println("The map you are requesting doesnt exist");
        }
    }

    public void populateMap(){
        switch (levelName){
            case "test_map" :
                populateTestMap();
                break;
            default:
                System.out.println("The map you are requesting to populateMap doesn't exist");
        }
    }
    private void populateTestMap() {

        ViewObjectFactory.getInstance().initVOFactory(getAreaView());
        popolateTestMapAreaOne();

    }

    private void popolateTestMapAreaOne(){
        MapArea mapAreaOne =  Map.getInstance().getMapAreas()[0];
//        ItemVendor.createHammer(mapAreaOne, new Position(1,2,9));
        EntityVendor.createEnemy(new Position(1,2,8), mapAreaOne);

        EntityVendor.createNewSmasherPlayer("Dave",new Position(0,0,8), mapAreaOne);

//        NPC myNPC = new NPC("Hehe",new Position(1,1,8), new Smasher(), new TerrestrialCanMoveVisitor());
//        mapAreaOne.addEntity(myNPC, new Position(1,1,8));
//
        mapAreaOne.addAE(new Flow(Direction.SOUTH_EAST, 10), new Position(0,3,9));
        mapAreaOne.addAE(new Flow(Direction.SOUTH_EAST, 10), new Position(1,3,9));
        mapAreaOne.addAE(new Flow(Direction.SOUTH_EAST, 10), new Position(2,3,9));

        CameraView cameraView1 = new CameraView(mapAreaOne);
        cvm.addCameraView(mapAreaOne, cameraView1);
        areaView.setActiveCameraView(cameraView1);
        cameraView1.populateCV();
    }



    private void createTestMap() {
        createTestMapAreaOne();

    }

    public void createTestMapAreaOne(){
        MapArea mapArea1 = new MapArea();

        for(int i = 0; i < 4; i++){ //q
            for(int j = 0; j < 5; j++){ //r
                TilePillar tilePillar = new TilePillar();
                for(int k = 0; k < 10; k++){ //h
                    if (k >= 9 && j < 2) {
                        tilePillar.addTile(k, new Tile(new Sky()));
                    }else {
                        tilePillar.addTile(k, new Tile(new Ground()));
                    }
                }
                mapArea1.addTilePillar(new Position(i,j,0), tilePillar);

                if(j == 4){
                    for(int k = 5; k < 10; k++){ //h
                        tilePillar.addTile(k, new Tile(new Sky()));
                    }
                }


            }
        }

        for(int i = 5; i < 6; i++){
            for(int j = 5; j < 6; j++){ //r
                TilePillar tilePillar = new TilePillar();
                for(int k = 0; k < 10; k++){ //h
                    tilePillar.addTile(k, new Tile(new NullTerrain()));
                }
                mapArea1.addTilePillar(new Position(i,j,0), tilePillar);
            }
        }
        //TODO: need to find a better way to fill NullTile around the maparea


        Map.getInstance().addMapArea(mapArea1);
        Map.getInstance().setActiveMapArea(mapArea1);
    }




}

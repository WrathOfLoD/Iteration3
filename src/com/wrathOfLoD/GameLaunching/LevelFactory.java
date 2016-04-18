package com.wrathOfLoD.GameLaunching;

import com.wrathOfLoD.GameLaunching.Vendors.AEVendor;
import com.wrathOfLoD.GameLaunching.Vendors.EntityVendor;
import com.wrathOfLoD.GameLaunching.Vendors.ItemVendor;
import com.wrathOfLoD.Models.Ability.Abilities.BlastAbilities.FanBlastAbility;
import com.wrathOfLoD.Models.Ability.Abilities.BlastAbilities.FireballAbility;
import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Entity.Character.NPC;
import com.wrathOfLoD.Models.Entity.EntityCanMoveVisitor.TerrestrialCanMoveVisitor;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.TwoHandWeapon;
import com.wrathOfLoD.Models.Map.AreaEffect.Flow;
import com.wrathOfLoD.Models.Map.AreaEffect.Teleport;
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

import java.io.IOException;

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

    public void setActiveCV(MapArea mapArea){
        cvm.setActiveCV(mapArea);
        areaView.setActiveCameraView(cvm.getActiveCV());
    }

    public void generateMap(){
        switch (levelName){
            case "test_map" :
                createTestMap();
                break;
            default:
                System.out.println("The map you are requesting doesn't exist");
        }
    }

    public void populateMap() throws IOException{
        switch (levelName){
            case "test_map" :
                populateTestMap();
                break;
            default:
                System.out.println("The map you are requesting to populateMap doesn't exist");
        }
    }
    private void populateTestMap() throws IOException{

        ViewObjectFactory.getInstance().initVOFactory(getAreaView());
        popolateTestMapAreaOne();

    }

    private void popolateTestMapAreaOne(){
        MapArea mapAreaOne =  Map.getInstance().getMapAreas()[0];


        //ItemVendor.createHammer(mapAreaOne, new Position(1,2,9));
        //EntityVendor.createNewSummonerPlayer("Dave",new Position(0,0,8), mapAreaOne);


//        ItemVendor.createHammer(mapAreaOne, new Position(1,2,9));
//        EntityVendor.createEnemy(new Position(1,2,9), mapAreaOne);
//        EntityVendor.createEnemy(new Position(1,0,9), mapAreaOne);
        EntityVendor.createFlyingEnemy(new Position(2,4,4), mapAreaOne);


//        NPC myNPC = new NPC("Hehe",new Position(1,1,8), new Smasher(), new TerrestrialCanMoveVisitor());
//        mapAreaOne.addEntity(myNPC, new Position(1,1,8));
//


        ItemVendor.createHammer(mapAreaOne, new Position(2,1,8));

        mapAreaOne.addAE(new Flow(Direction.SOUTH_EAST, 10), new Position(0,3,9));
        mapAreaOne.addAE(new Flow(Direction.SOUTH_EAST, 10), new Position(1,3,9));
        mapAreaOne.addAE(new Flow(Direction.SOUTH_EAST, 10), new Position(2,3,9));

        mapAreaOne.addAE(new Teleport(new Position(0,1,8)), new Position(0,7,3));

        CameraView cameraView1 = new CameraView(mapAreaOne);
        cameraView1.setInitialCameraCenter(mapAreaOne.getSpawnPoint());
        cameraView1.setCameraCenter(mapAreaOne.getSpawnPoint());
        cvm.addCameraView(mapAreaOne, cameraView1);
        areaView.setActiveCameraView(cameraView1); //TODO: set active cv when avatar gets added
        cameraView1.populateCV();



        Map.getInstance().registerObserver(areaView);
    }


    private void createTestMap() {
        createTestMapAreaOne();

    }

    public void createTestMapAreaOne(){
        MapArea mapArea1 = new MapArea(new Position(0,0,8));

        for(int i = 0; i < 12; i++){ //q
            for(int j = 0; j < 8; j++){ //r
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
                    for(int k = 7; k < 10; k++){ //h
                        tilePillar.addTile(k, new Tile(new Sky()));
                    }
                }
                if(j == 5){
                    for(int k = 6; k < 10; k++){ //h
                        tilePillar.addTile(k, new Tile(new Sky()));
                    }
                }
                if(j == 6){
                    for(int k = 5; k < 10; k++){ //h
                        tilePillar.addTile(k, new Tile(new Sky()));
                    }
                }
                if(j == 7){
                    for(int k = 4; k < 10; k++){ //h
                        tilePillar.addTile(k, new Tile(new Sky()));
                    }
                }



            }
        }

//        for(int i = 5; i < 6; i++){
//            for(int j = 5; j < 6; j++){ //r
//                TilePillar tilePillar = new TilePillar();
//                for(int k = 0; k < 10; k++){ //h
//                    tilePillar.addTile(k, new Tile(new NullTerrain()));
//                }
//                mapArea1.addTilePillar(new Position(i,j,0), tilePillar);
//            }
//        }
        //TODO: need to find a better way to fill NullTile around the maparea


        Map.getInstance().addMapArea(mapArea1);
        Map.getInstance().setActiveMapArea(mapArea1);

    }




}

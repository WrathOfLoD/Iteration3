package com.wrathOfLoD.GameLaunching;

import com.wrathOfLoD.GameLaunching.Vendors.AEVendor;
import com.wrathOfLoD.GameLaunching.Vendors.EntityVendor;
import com.wrathOfLoD.GameLaunching.Vendors.ItemVendor;
import com.wrathOfLoD.Models.Ability.Abilities.BlastAbilities.FanBlastAbility;
import com.wrathOfLoD.Models.Ability.Abilities.BlastAbilities.FireballAbility;
import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Entity.Character.NPC;
import com.wrathOfLoD.Models.Entity.EntityCanMoveVisitor.CanMoveVisitor;
import com.wrathOfLoD.Models.Entity.EntityCanMoveVisitor.FlyingCanMoveVisitor;
import com.wrathOfLoD.Models.Entity.EntityCanMoveVisitor.TerrestrialCanMoveVisitor;
import com.wrathOfLoD.Models.Entity.Mount;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.TwoHandWeapon;
import com.wrathOfLoD.Models.Map.AreaEffect.*;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.MapArea;
import com.wrathOfLoD.Models.Map.Terrain.Ground;
import com.wrathOfLoD.Models.Map.Terrain.NullTerrain;
import com.wrathOfLoD.Models.Map.Terrain.Sky;
import com.wrathOfLoD.Models.Map.Terrain.Water;
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



        EntityVendor.createFlyingEnemy(new Position(2,4,4), mapAreaOne);
        EntityVendor.createFlyingEnemy(new Position(17,5,9), mapAreaOne);



        //EntityVendor.createPet(new Position(0,1,8), mapAreaOne);


//        NPC myNPC = new NPC("Hehe",new Position(1,1,8), new Smasher(), new TerrestrialCanMoveVisitor());
//        mapAreaOne.addEntity(myNPC, new Position(1,1,8));
//


        ItemVendor.createHammer(mapAreaOne, new Position(8,14,3));

        //mapAreaOne.addEntity(new Mount("Mount", new Position(3, 3, 9), new FlyingCanMoveVisitor()), new Position(3,3,9));



        mapAreaOne.addAE(new Flow(Direction.SOUTH_EAST, 10), new Position(2,3,8));
        mapAreaOne.addAE(new Flow(Direction.SOUTH_EAST, 10), new Position(3,3,8));
        mapAreaOne.addAE(new Flow(Direction.SOUTH_EAST, 10), new Position(4,3,8));


        mapAreaOne.addAE(new Flow(Direction.NORTH_WEST, 10), new Position(2,10,9));
        mapAreaOne.addAE(new Flow(Direction.NORTH_WEST, 10), new Position(3,10,9));
        mapAreaOne.addAE(new Flow(Direction.NORTH_WEST, 10), new Position(4,10,9));

        mapAreaOne.addAE(new TakeDamageAreaEffect("TakeDamageAE", 40), new Position(6,0,8));
        mapAreaOne.addAE(new HealDamageAreaEffect("HealDamageAE", 30), new Position(7,0,8));
        mapAreaOne.addAE(new InstantDeathAreaEffect("InstantDeathAE"), new Position(8,0,8));


        mapAreaOne.addAE(new Teleport(new Position(3,6,9)), new Position(4,14,3));


        CameraView cameraView1 = new CameraView(mapAreaOne);
        cameraView1.setInitialCameraCenter(mapAreaOne.getSpawnPoint());
        cameraView1.setCameraCenter(mapAreaOne.getSpawnPoint());
        cvm.addCameraView(mapAreaOne, cameraView1);
        areaView.setActiveCameraView(cameraView1); //TODO: set active cv when avatar gets added
        cameraView1.populateCV();



        //Map.getInstance().registerObserver(areaView);
    }


    private void createTestMap() {
        createTestMapAreaOne();

    }

    public void createTestMapAreaOne(){
        MapArea mapArea1 = new MapArea(new Position(0,0,8));

        for(int i = 0; i < 20; i++){ //q
            for(int j = 0; j < 15; j++){ //r
                TilePillar tilePillar = new TilePillar();
                for(int k = 0; k < 10; k++){ //h
                    if (k >= 9 && j < 2) {
                        tilePillar.addTile(k, new Tile(new Sky()));
                    }else {
                        tilePillar.addTile(k, new Tile(new Ground()));
                    }
                }
                mapArea1.addTilePillar(new Position(i,j,0), tilePillar);

                if(j == 11){
                    for(int k = 7; k < 10; k++){ //h
                        tilePillar.addTile(k, new Tile(new Sky()));
                    }
                }
                if(j == 12){
                    for(int k = 6; k < 10; k++){ //h
                        tilePillar.addTile(k, new Tile(new Sky()));
                    }
                }
                if(j == 13){
                    for(int k = 5; k < 10; k++){ //h
                        tilePillar.addTile(k, new Tile(new Sky()));
                    }
                }
                if(j == 14){
                    for(int k = 4; k < 10; k++){ //h
                        tilePillar.addTile(k, new Tile(new Sky()));
                    }
                }

                if(j == 3){

                    if(i == 10 || i == 11 || i == 12){
                        for(int k = 8; k < 10; k++){ //h
                            tilePillar.addTile(k, new Tile(new Water()));
                        }
                    }else{
                        for(int k = 9; k < 10; k++){ //h
                            tilePillar.addTile(k, new Tile(new Sky()));
                        }

                    }

                }

                if(j == 4){

                    if(i == 10 || i == 11 || i == 12){
                        for(int k = 8; k < 10; k++){ //h
                            tilePillar.addTile(k, new Tile(new Water()));
                        }
                    }
                }

                if(j == 5){

                    if(i == 10 || i == 11 || i == 12){
                        for(int k = 8; k < 10; k++){ //h
                            tilePillar.addTile(k, new Tile(new Water()));
                        }
                    }
                }




            }
        }

        for(int i = 20; i < 21; i++){
            for(int j = 15; j < 16; j++){ //r
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

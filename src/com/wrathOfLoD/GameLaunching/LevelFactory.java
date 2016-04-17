package com.wrathOfLoD.GameLaunching;

import com.wrathOfLoD.GameLaunching.Vendors.AEVendor;
import com.wrathOfLoD.GameLaunching.Vendors.EntityVendor;
import com.wrathOfLoD.GameLaunching.Vendors.ItemVendor;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.TwoHandWeapon;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.MapArea;
import com.wrathOfLoD.Models.Map.Terrain.Ground;
import com.wrathOfLoD.Models.Map.Terrain.NullTerrain;
import com.wrathOfLoD.Models.Map.Terrain.Sky;
import com.wrathOfLoD.Models.Map.Tile;
import com.wrathOfLoD.Models.Map.TilePillar;
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
    //not set yet add to this as wanted for putting things on test map
    private void populateTestMap() {
//        //TODO: get map area from map
//        MapArea mapAreas[] = Map.getInstance().getMapAreas();
//        MapArea mapArea1 = mapAreas[0];
//
//        /*********** Map Area 1 Can be put in separate method***************/
//        mapArea1.addItem(itemVendor.createTestStaff(), new Position(0, 1, 0));
//
//
//        /*********** END Map Area 1 ***************/
//
//
//
//        /**** Create area view for the map area ****/
//        CameraView cameraView1 = new CameraView(mapArea1);
//        //TODO: areaView needs to create all the VO based on the populated MapArea
//        cvm.addCameraView(mapArea1, cameraView1);
        ViewObjectFactory.getInstance().initVOFactory(getAreaView());
        popolateTestMapAreaOne();

    }

    private void popolateTestMapAreaOne(){
        MapArea mapAreaOne =  Map.getInstance().getMapAreas()[0];
        ItemVendor.createHammer(mapAreaOne, new Position(1,2,9));
        EntityVendor.createNewSmasherPlayer("Dave",new Position(0,0,8), mapAreaOne);
        CameraView cameraView1 = new CameraView(mapAreaOne);
        cvm.addCameraView(mapAreaOne, cameraView1);
        areaView.setActiveCameraView(cameraView1);
        cameraView1.populateCV();
    }



    //not set yet add to this as wanted for creating the map ,mapareas, and the tiles in them as well as area effects or other static things that will be on the map
    private void createTestMap() {
//        /*********** Map Area 1 Can be put in separate method***************/
//        MapArea mapArea1 = new MapArea();
//
//        for(int i = 0; i < 4; i++){ //q
//            for(int j = 0; j < 5; j++){ //r
//                TilePillar tilePillar = new TilePillar();
//                tilePillar.setGroundLevel(10-j); //TODO:Need for movement to work
//                for(int k = 0; k < 10; k++){ //h
//                    if (k >= 9 && j < 2) {
//                        tilePillar.addTile(k, new Tile(new Sky()));
//                    }else {
//                        tilePillar.addTile(k, new Tile(new Ground()));
//                    }
//                }
//                mapArea1.addTilePillar(new Position(i,j,0), tilePillar);
//
//                if(j == 4){
//                    tilePillar.setGroundLevel(4);
//                    for(int k = 5; k < 10; k++){ //h
//                        tilePillar.addTile(k, new Tile(new Sky()));
//                    }
//                }
//
//
//            }
//        }
//
//        for(int i = 5; i < 6; i++){
//            for(int j = 5; j < 6; j++){ //r
//                TilePillar tilePillar = new TilePillar();
//                for(int k = 0; k < 10; k++){ //h
//                    tilePillar.addTile(k, new Tile(new NullTerrain()));
//                }
//                mapArea1.addTilePillar(new Position(i,j,0), tilePillar);
//            }
//        }
//
//        /*********** END Map Area 1 ***************/
//
//
//
//        Map.getInstance().addMapArea(mapArea1);
//        Map.getInstance().setActiveMapArea(mapArea1);
        createTestMapAreaOne();

    }

    public void createTestMapAreaOne(){
        /*** Create Map *****/
        MapArea mapArea1 = new MapArea();

        for(int i = 0; i < 4; i++){ //q
            for(int j = 0; j < 5; j++){ //r
                TilePillar tilePillar = new TilePillar();
                tilePillar.setGroundLevel(10-j); //TODO:Need for movement to work
                for(int k = 0; k < 10; k++){ //h
                    if (k >= 9 && j < 2) {
                        tilePillar.addTile(k, new Tile(new Sky()));
                    }else {
                        tilePillar.addTile(k, new Tile(new Ground()));
                    }
                }
                mapArea1.addTilePillar(new Position(i,j,0), tilePillar);

                if(j == 4){
                    tilePillar.setGroundLevel(4);
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

package com.wrathOfLoD.GameLaunching;

import com.wrathOfLoD.GameLaunching.Vendors.AEVendor;
import com.wrathOfLoD.GameLaunching.Vendors.EntityVendor;
import com.wrathOfLoD.GameLaunching.Vendors.ItemVendor;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.MapArea;
import com.wrathOfLoD.Models.Map.Terrain.Ground;
import com.wrathOfLoD.Models.Map.Tile;
import com.wrathOfLoD.Models.Map.TilePillar;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.AreaView.AreaView;
import com.wrathOfLoD.Views.AreaView.AreaViewManager;

import java.awt.geom.Area;

/**
 * Created by icavitt on 4/12/2016.
 */
public class LevelFactory {

    private AreaViewManager avm;
    private String levelName;
    private ItemVendor itemVendor;
    private EntityVendor entityVendor;
    private AEVendor aeVendor;

    public LevelFactory(String levelName){
        this.levelName = levelName;
        avm = new AreaViewManager();
        itemVendor = new ItemVendor();
        entityVendor = new EntityVendor();
        aeVendor = new AEVendor();
    }

    public AreaViewManager getAreaViewManager(){
        return this.avm;
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
        //TODO: get map area from map
        MapArea mapAreas[] = Map.getInstance().getMapAreas();
        MapArea mapArea1 = mapAreas[0];

        /*********** Map Area 1 Can be put in separate method***************/
        mapArea1.addItem(itemVendor.createTestStaff(), new Position(0, 1, 0));


        /*********** END Map Area 1 ***************/



        /**** Create area view for the map area ****/
        AreaView areaView1 = new AreaView();
        //TODO: areaView needs to create all the VO based on the populated MapArea
        avm.addAreaView(mapArea1, areaView1);

    }



    //not set yet add to this as wanted for creating the map ,mapareas, and the tiles in them as well as area effects or other static things that will be on the map
    private void createTestMap() {
        /*********** Map Area 1 Can be put in separate method***************/
        MapArea mapArea1 = new MapArea();

        for(int i = 0; i < 20; i++){ //q
            for(int j = 0; j < 15; j++){ //r
                TilePillar tilePillar = new TilePillar();
                for(int k = 0; k < 10; k++){ //h
                    tilePillar.addTile(k, new Tile(new Ground()));
                }
                mapArea1.addTilePillar(new Position(i,j,0), tilePillar);
            }
        }

        /*********** END Map Area 1 ***************/




        Map.getInstance().addMapArea(mapArea1);
        Map.getInstance().setActiveMapArea(mapArea1);
    }




}

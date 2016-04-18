package com.wrathOfLoD.Views.SpriteMap;


import com.wrathOfLoD.Utility.Direction;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by matthewdiaz on 4/15/16.
 */
public class SpriteMap {
    private  HashMap<String, ImageAnimation> aoeMap;
    private  HashMap<EntityKey, ImageAnimation> entityMap;
    //includes hitbox
    private  HashMap<String, ImageAnimation> effectsMap;
    private  HashMap<String, ImageAnimation> itemMap;

    public class EntityKey{
        private String entityType;
        private String action;
        private Direction direction;

        EntityKey(String entityType, String action, Direction direction){
            this.entityType = entityType;
            this.action = action;
            this.direction = direction;
        }
    }

    public SpriteMap() throws IOException{
        this.aoeMap = new HashMap<>();
        this.entityMap = new HashMap<>();
        this.effectsMap = new HashMap<>();
        this.itemMap = new HashMap<>();
        generateItemMap();
        generateEffectsMap();
        generateAOEMap();
    }

    /***** getter & setter for SpriteMap *******/
    public  HashMap<String, ImageAnimation> getAoeMap() { return aoeMap; }

    public  HashMap<EntityKey, ImageAnimation>  getEntityMap(){ return entityMap; }

    public  HashMap<String, ImageAnimation>  getEffectsMap(){ return effectsMap; }

    public  HashMap<String, ImageAnimation>  getItemMap(){ return itemMap; }

    /********* END Getters *********/

    /***** Reusable Methods for all Maps *******/
    private List<Image> imageFramesGenerator(File folder) throws IOException{
        File[] listOfFiles = folder.listFiles();

        List<Image> sprites = new ArrayList<>();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                sprites.add(ImageIO.read(file));
            }
        }
        return sprites;
    }
    /***** End of Reusable Methods for all maps *******/



    private  void generateItemMap() throws IOException{
        imageAnimationGenerator("./resources/MapItems", itemMap);
    }

    private  void generateEffectsMap() throws IOException{
        imageAnimationGenerator("./resources/Effects", effectsMap);
    }

    private void generateAOEMap() throws  IOException{
        imageAnimationGenerator("./resources/AOE", aoeMap);
    }


    /***** Reusable Methods for  aoeMap, imageMap, and effectsMap *******/
    private void imageAnimationGenerator(String path, HashMap<String, ImageAnimation> hash) throws IOException {
        File directory = new File(path);

        List<Image> itemImage;
        ImageAnimation itemImageAnimation;
        for(File subdirectories: directory.listFiles()){

            if(subdirectories.isDirectory()){
                System.out.println(subdirectories);
                itemImage = imageFramesGenerator(subdirectories);
                itemImageAnimation = new ImageAnimation(itemImage);
                insertToHash(subdirectories.getName(), itemImageAnimation, hash);
            }
        }
    }

    private void insertToHash(String item, ImageAnimation val, HashMap<String, ImageAnimation> hash){
        hash.put(item, val);
    }
    /***** End of Reusable Methods for aoeMap, imageMap, and effectsMap *******/


//    public void generateEntityMap() throws IOException{
//        generateEntityMap("./resources/Entity/Avatar/Smasher/AttackWithWeapon");
//    }
//
//    private void insertToEntityHash(String entityType, String action, Direction direction, ImageAnimation val){
//        EntityKey entityKey = new EntityKey(entityType, action, Direction.DOWN_NORTH);
//        this.entityMap.put(entityKey, val);
//    }
//
//    private void generateEntityMap(String path) throws IOException {
//        File folder = new File(path);
//        //System.out.println(truncateName(path));
//        List<Image> sprites = generateImageFrames(folder);
//        for(int i = 0; i < sprites.size(); i++){
//            System.out.println(sprites.get(i).toString());
//        }
//
//
//        ImageAnimation imageAnimation = new ImageAnimation(sprites);
//        insertToEntityHash(folder.getName(), "walk", Direction.DOWN_NORTH, imageAnimation);
//    }
}

package com.wrathOfLoD.Views.SpriteMap;


import com.wrathOfLoD.Utility.Direction;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by matthewdiaz on 4/15/16.
 */
public class SpriteMap {
    private  HashMap<String, ImageAnimation> aoeMap;
    private  HashMap<EntityKey, ImageAnimation> entityMap;
    private  HashMap<String, ImageAnimation> hitBoxMap;
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

    public SpriteMap(){
        this.aoeMap = new HashMap<>();
        this.entityMap = new HashMap<>();
        this.hitBoxMap = new HashMap<>();
        this.itemMap = new HashMap<>();
    }

    /***** getter & setter for SpriteMap *******/
    public  HashMap<String, ImageAnimation> getAoeMap() { return aoeMap; }

    public  HashMap<EntityKey, ImageAnimation>  getEntityMap(){ return entityMap; }

    public  HashMap<String, ImageAnimation>  getHitBoxMap(){ return hitBoxMap; }

    public  HashMap<String, ImageAnimation>  getItemMap(){ return itemMap; }

    /********* END Getters *********/


//    Not sure if we need this
    private String truncateName(String fileName){
        int truncateIndex = fileName.indexOf(".");
        String name = fileName.substring(0,truncateIndex);
        return name;
    }

    private void insertToEntityHash(String entityType, String action, Direction direction, ImageAnimation val){
        EntityKey entityKey = new EntityKey(entityType, action, Direction.DOWN_NORTH);
        this.entityMap.put(entityKey, val);
    }

    private void insertToItemHash(String item, ImageAnimation val){
        this.itemMap.put(item, val);
    }

    private List<Image> generateImageFrames(File folder) throws IOException{
        File[] listOfFiles = folder.listFiles();

        List<Image> sprites = new ArrayList<>();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                //System.out.println(file.getName());
                sprites.add(ImageIO.read(file));
            }
        }

        return sprites;
    }

    private void generateEntityMap(String path) throws IOException {
        File folder = new File(path);
        System.out.println(truncateName(path));
        List<Image> sprites = generateImageFrames(folder);
        for(int i = 0; i < sprites.size(); i++){
            System.out.println(sprites.get(i).toString());
        }


        ImageAnimation imageAnimation = new ImageAnimation(sprites);
        insertToEntityHash(folder.getName(), "walk", Direction.DOWN_NORTH, imageAnimation);
    }

    private void generateItemMap(String path) throws IOException{
        File directory = new File(path);

        List<Image> itemImage;
        ImageAnimation itemImageAnimation;
        for(File subdirectories: directory.listFiles()){
            itemImage = generateImageFrames(subdirectories);
            itemImageAnimation = new ImageAnimation(itemImage);
            insertToItemHash(subdirectories.getName(), itemImageAnimation);
        }
    }


    public void generateEntityMap() throws IOException{
        generateEntityMap("./resources/Entity/Avatar/Smasher/AttackWithWeapon");
    }

    public  void generateItemMap() throws IOException{
        generateItemMap("./resources/MapItems");
    }
}

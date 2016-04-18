package com.wrathOfLoD.Views.SpriteMap;


import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.FileExtensionExtractor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

/**
 * Created by matthewdiaz on 4/15/16.
 */
public class SpriteMap {
    private  HashMap<String, ImageAnimation> aoeMap;
    private  HashMap<EntityKey, ImageAnimation> entityMap;
    private  HashMap<AvatarKey, ImageAnimation> avatarMap = new HashMap<>();
    private  HashMap<String, ImageAnimation> effectsMap;
    private  HashMap<String, ImageAnimation> itemMap;
    private Set<String> stateSet;

    public class EntityKey{
        private String entityType;
        private String action;
        private String state;
        private String direction;

        EntityKey(String entityType, String state, String direction,  String action){
            this.entityType = entityType;
            this.state = state;
            this.direction = direction;
            this.action = action;
        }
    }

    public class AvatarKey{
        private String occupation;
        private String action;
        private String state;
        private String direction;

        AvatarKey(String occupation, String state, String action, String direction){
            this.occupation = occupation;
            this.state = state;
            this.action = action;
            this.direction = direction;
        }

        @Override
        public String toString(){
            return occupation + " " + state + " " + action + " " + direction;
        }
    }

    public SpriteMap() throws IOException{
        this.aoeMap = new HashMap<>();
        this.entityMap = new HashMap<>();
        this.effectsMap = new HashMap<>();
        this.itemMap = new HashMap<>();
        stateSet = new HashSet<>();
        stateSet.add("Attack");
        stateSet.add("Walk");
        generateItemMap();
        generateEffectsMap();
        generateAOEMap();
//        generateEntityMap();
//        generateAvatarMap();
    }

    /***** getter & setter for SpriteMap *******/
    public  HashMap<String, ImageAnimation> getAoeMap() { return aoeMap; }

    public  HashMap<AvatarKey, ImageAnimation>  getAvatarMapMap(){ return avatarMap; }

    public  HashMap<EntityKey, ImageAnimation>  getEntityMap(){ return entityMap; }

    public  HashMap<String, ImageAnimation>  getEffectsMap(){ return effectsMap; }

    public  HashMap<String, ImageAnimation>  getItemMap(){ return itemMap; }

    /********* END Getters *********/

    /***** Reusable Methods for all Maps *******/
    private List<Image> imageFramesGenerator(File folder) throws IOException{
        File[] listOfFiles = folder.listFiles();

        List<Image> sprites = new ArrayList<>();
        for (File file : listOfFiles) {
            if (file.isFile() && FileExtensionExtractor.getFileExtension(file.getName()).equals("png")) {
                sprites.add(ImageIO.read(file));
            }
        }
        return sprites;
    }

    /***** End of Reusable Methods for all maps *******/
    private void entityRenameImageFiles(File folder) throws IOException{
        File[] listOfFiles = folder.listFiles();
        int counter = 0;
        for (File file : listOfFiles) {
            if (file.isFile() && FileExtensionExtractor.getFileExtension(file.getName()).equals("png")) {
                Files.move(file.toPath(), file.toPath().resolveSibling(folder.getName() + counter +".png"));
                counter++;
            }
        }
    }

    private void entityImageFramesGenerator(File folder) throws IOException{
        int startStringLength = Config.getEntityVOPath().length();

        String stringKey = folder.getPath().substring(startStringLength);
        String[] keyVals = stringKey.split("/");
        for (String s : keyVals)
            System.out.println(s);
        AvatarKey key = new AvatarKey(keyVals[0], keyVals[1], keyVals[2], keyVals[3]);

        File[] listOfFiles = folder.listFiles();

        List<Image> sprites = new ArrayList<>();
        for (File file : listOfFiles) {
            if (file.isFile() && FileExtensionExtractor.getFileExtension(file.getName()).equals("png")) {
                sprites.add(ImageIO.read(file));
            }
        }
        if(sprites.size() > 0){
            ImageAnimation imgAnimation = new ImageAnimation(sprites);
            System.out.println("At key: " + key);
            for (Image f : sprites)
                System.out.println("\tinserting " + f);

            avatarMap.put(key, imgAnimation);
        }
    }


    private  void generateItemMap() throws IOException{
        imageAnimationGenerator("./resources/MapItems", itemMap);
    }

    private  void generateEffectsMap() throws IOException{
        imageAnimationGenerator("./resources/Effects", effectsMap);
    }

    private void generateAOEMap() throws  IOException{
        imageAnimationGenerator("./resources/AOE", aoeMap);
    }

    public void generateAvatarMap() throws IOException{
        entityAnimationGenerator(Config.getEntityVOPath() + "/Avatar/Smasher");
    }

    public void generateEntityMap() throws IOException{
        entityAnimationGenerator(Config.getEntityVOPath());
    }

    private void entityAnimationGenerator(String path) throws IOException {
        File directory = new File(path);
        if (stateSet.contains(directory.getName())) {
            //System.out.println("The hash contains me" + directory.getPath());
            entityImageFramesGenerator(directory);
            return;
        }

        File[] paths = directory.listFiles();

        if (paths != null) {
            for (int i = 0; i < paths.length; i++) {
                entityAnimationGenerator(paths[i].getPath());
                //System.out.println(paths[i].getPath());
            }
        }
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

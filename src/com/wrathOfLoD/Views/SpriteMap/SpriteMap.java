package com.wrathOfLoD.Views.SpriteMap;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * Created by matthewdiaz on 4/15/16.
 */
public class SpriteMap {
    private  HashMap<String, ImageAnimation> aoeMap;
    private  HashMap<String, ImageAnimation> entityMap;
    private  HashMap<String, ImageAnimation> hitBoxMap;
    private  HashMap<String, ImageAnimation> itemMap;

    public SpriteMap(){
        this.aoeMap = new HashMap<>();
        this.entityMap = new HashMap<>();
        this.hitBoxMap = new HashMap<>();
        this.itemMap = new HashMap<>();
    }

    /***** getter & setter for SpriteMap *******/
    public  HashMap<String, ImageAnimation> getAoeMap() { return aoeMap; }

    public  HashMap<String, ImageAnimation>  getEntityMap(){ return entityMap; }

    public  HashMap<String, ImageAnimation>  getHitBoxMap(){ return hitBoxMap; }

    public  HashMap<String, ImageAnimation>  getItemMap(){ return itemMap; }

    /********* END Getters *********/


    private String truncateName(String fileName){
        int truncateIndex = fileName.indexOf(".");
        String name = fileName.substring(0,truncateIndex);
        return name;
    }

    private  List<Image> generateBufferedImages(String path) throws IOException {
        List<Image> images = new ArrayList<>();
        Files.walk(Paths.get(path)).forEach(filePath -> {
            if (Files.isRegularFile(filePath)) {
                //System.out.println(filePath);
                try {
                    File file = filePath.toFile();
                    String fileName = file.getName();
                    String name = truncateName(fileName);
                    BufferedImage image = ImageIO.read(file);
                    images.add(image);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return images;
    }

    //iterate through all the files and create bufferedImage for each file
    //Create a new imageAnimation with the list of bufferedImages
    public  void generateItemMap() throws IOException{
        List<Image> images = generateBufferedImages("./resources/Backgrounds");
        ImageAnimation imageAnimation = new ImageAnimation(images);
        itemMap.put("items", imageAnimation);
    }
}

package com.wrathOfLoD.Views.SpriteMap;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

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


    private List<BufferedImage> createdBufferedImages(File file) throws IOException{
        BufferedImage bigImg = ImageIO.read(file);
        final int rows = 4;
        final int cols = 6;
        final int width = bigImg.getWidth()/cols;
        final int height = bigImg.getHeight()/rows;

        List<BufferedImage> sprites = new ArrayList<>();

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                String name = "file" + i + j+".png";
                File outputfile = new File(name);
                BufferedImage subImage = bigImg.getSubimage(j * width, i * height,width, height);
                ImageIO.write(subImage, "png", outputfile);

            }
        }
        return sprites;
    }

    private void generateEntityMap(String path) throws IOException {
        //List<Image> images = new ArrayList<>();

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName());
                List sprites = createdBufferedImages(file);

//        Files.walk(Paths.get(path)).forEach(filePath -> {
//            if (Files.isRegularFile(filePath)) {
//                System.out.println(filePath);
//                try {
//                    File file = filePath.toFile();
//                    String fileName = file.getName();
//                    String name = truncateName(fileName);
//                    System.out.println(name);
//                    BufferedImage image = ImageIO.read(file);
//                    //images.add(image);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

            }
        }
    }

    //iterate through all the files and create bufferedImage for each file
    //Create a new imageAnimation with the list of bufferedImages

    public  void generateEntityMap() throws IOException{
        generateEntityMap("./resources/Entity/Avatar/Smasher/AttackWithWeapon");
    }

    public  void generateItemMap() throws IOException{
//        List<Image> images = generateEntityMap("./resources/Backgrounds");
//        ImageAnimation imageAnimation = new ImageAnimation(images);
//        itemMap.put("items", imageAnimation);
    }
}

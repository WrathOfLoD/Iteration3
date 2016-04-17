package com.wrathOfLoD.Views.SpriteMap;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by matthewdiaz on 4/16/16.
 */
public class SpriteTestOutPut {
    public static void main(String args[]) throws IOException {
        SpriteMap sm = new SpriteMap();
//        sm.generateEntityMap();

        File image = new File("resources/walk_right_sheet.png");

        for (BufferedImage bi : sm.createdBufferedImages(image)) {
            System.out.println(bi);
        }
    }
}

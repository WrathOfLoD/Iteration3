package com.wrathOfLoD.Views.ImageFactory;

import com.wrathOfLoD.Models.Items.Item;

import javax.swing.*;
import java.awt.*;

/**
 * Created by erik on 4/7/2016.
 */
public class ImageFactory {

    public ImageFactory() {
    }

    public static String generateImageFileName(String name) {
        String imageFileName = "resources/"+name+".png";
        return imageFileName;
    }

    public static Image scaleImage(Image image, int width, int height) {
        Image scaledImage=image.getScaledInstance(width,height, Image.SCALE_SMOOTH);
        return scaledImage;
    }

    public static Image generateImageFromFile(String imageFileName) {
        ImageIcon itemImageIcon = new ImageIcon(imageFileName);
        Image itemImage = itemImageIcon.getImage();
        return itemImage;
    }

    public static Image generateImage(String name) {
        String imageFileName = generateImageFileName(name);
        Image itemImage = generateImageFromFile(imageFileName);
        return itemImage;
    }

    public static Image generateScaledImage(String name, int width, int height) {
        String imageFileName = generateImageFileName(name);
        Image itemImage = generateImageFromFile(imageFileName);
        Image scaledImage = scaleImage(itemImage, width, height);
        return scaledImage;
    }

    public static JLabel createImageLabel(Image image) {
        JLabel picLabel = new JLabel(new ImageIcon(image));
        return picLabel;
    }

}

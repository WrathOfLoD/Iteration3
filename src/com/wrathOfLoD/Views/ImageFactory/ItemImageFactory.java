package com.wrathOfLoD.Views.ImageFactory;

import com.wrathOfLoD.Models.Items.Item;

import javax.swing.*;
import java.awt.*;

/**
 * Created by erik on 4/7/2016.
 */
public class ItemImageFactory  {

    public ItemImageFactory() {
    }

    public static String generateItemImageFileName(Item item) {
        String imageFileName = "resources/InventoryItems/"+item.getName()+".png";
        return imageFileName;
    }


    public static Image generateImageFromFile(String imageFileName) {
        ImageIcon itemImageIcon = new ImageIcon(imageFileName);
        Image itemImage = itemImageIcon.getImage();
        return itemImage;
    }

    public static Image scaleItemImage(Image itemImage, int width, int height) {
        Image scaledImage=itemImage.getScaledInstance(width,height, Image.SCALE_SMOOTH);
        return scaledImage;
    }

    public static JLabel createItemImageLabel(Image itemImage) {
        JLabel picLabel = new JLabel(new ImageIcon(itemImage));
        return picLabel;
    }

    public static Image generateScaledImage(Item item, int width, int height) {
        String imageFileName = generateItemImageFileName(item);
        Image itemImage = generateImageFromFile(imageFileName);
        Image scaledImage = scaleItemImage(itemImage, width, height);
        return scaledImage;
    }

    public static Image generateImage(Item item) {
        String imageFileName = generateItemImageFileName(item);
        Image itemImage = generateImageFromFile(imageFileName);
        return itemImage;
    }

}

package com.wrathOfLoD.Views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by erik on 4/7/2016.
 */
public class View extends JPanel {

    private String backgroundImageFileName;

    public String getBackgroundImageFileName() {
        return backgroundImageFileName;
    }
    public void setBackgroundImageFileName(String backgroundImageFileName) {
        this.backgroundImageFileName = backgroundImageFileName;
    }

    public View() {
    }

    public final void generateImageBackground(String imageName, Graphics g) {
        ImageIcon itemIcon = new ImageIcon(imageName);
        Image backgroundImage = itemIcon.getImage();
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(),this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        generateImageBackground(getBackgroundImageFileName(), g);
    }


}

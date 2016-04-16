package com.wrathOfLoD.Views.Menu;

import com.wrathOfLoD.Views.ImageFactory.ImageFactory;
import com.wrathOfLoD.Views.StaticView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mistiansen on 4/15/16.
 */
public class MenuItem extends JPanel {

    private String text;
    private String imageFileName;
    private Image image;

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getImageFileName() {
        return imageFileName;
    }
    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }


    public MenuItem(String text) {
        setText(text);
        setImageFileName("resources/Buttons/spaceMenuButton.png");
        image = ImageFactory.generateImage(getImageFileName());
    }

    public void paintComponent(Graphics g, int x, int y, int width, int height) {
        int textWidth;
        int textHeight;
        int textXCoord;
        int textYCoord;

        if(image!=null) {
            g.drawImage(image, x, y, width, height,this);
        } else {
            setBackground(Color.BLACK);
        }
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        textWidth = g.getFontMetrics().stringWidth(getText());
        textHeight = g.getFontMetrics().getHeight();

        textXCoord = x + width/2 - textWidth/2;
        textYCoord = y + height/2 - textHeight/2;

        g.drawString(getText(), textXCoord, textYCoord);

    }


}

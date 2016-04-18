package com.wrathOfLoD.Views.Menu;

import com.wrathOfLoD.Views.ImageFactory.ImageFactory;
import com.wrathOfLoD.Views.StaticView;
import com.wrathOfLoD.Models.Commands.MenuActionCommands.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Mistiansen on 4/15/16.
 */
public class MenuItem extends JPanel {

    private String text;
    private MenuSelectCommand command;
    private boolean isSelected;

    public MenuItem(String text) {
        setText(text);
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean selected) {
        this.isSelected = selected;
    }

    public void paintComponent(Graphics g, int x, int y, int width, int height) {
        int textWidth;
        int textHeight;
        int textXCoord;
        int textYCoord;

        textWidth = g.getFontMetrics().stringWidth(getText());
        textHeight = g.getFontMetrics().getAscent();

        textXCoord = x + width/2 - textWidth/2;
        textYCoord = y + height/2 + textHeight/4;

        g.setColor(Color.RED);
        g.drawString(getText(), textXCoord, textYCoord);

        if (this.isSelected()) {
            g.setColor(new Color(0f,0f,1.0f,0.2f));
            g.fillRect(x,y,width,height);
        }
    }

    public void execute() throws IOException, InterruptedException{

    }


}

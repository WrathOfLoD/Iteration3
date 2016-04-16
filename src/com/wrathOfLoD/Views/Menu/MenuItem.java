package com.wrathOfLoD.Views.Menu;

import com.wrathOfLoD.Views.ImageFactory.ImageFactory;
import com.wrathOfLoD.Views.StaticView;
import com.wrathOfLoD.Models.Commands.MenuActionCommands.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mistiansen on 4/15/16.
 */
public class MenuItem extends JPanel {

    private String text;
    private MenuSelectCommand command;

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public MenuItem(String text) {
        setText(text);
    }

    public void paintComponent(Graphics g, int x, int y, int width, int height) {
        int textWidth;
        int textHeight;
        int textXCoord;
        int textYCoord;

        textWidth = g.getFontMetrics().stringWidth(getText());
        textHeight = g.getFontMetrics().getHeight();

        textXCoord = x + width/2 - textWidth/2;
        textYCoord = y + height/2 - textHeight/2;

        g.drawString(getText(), textXCoord, textYCoord);

    }


}

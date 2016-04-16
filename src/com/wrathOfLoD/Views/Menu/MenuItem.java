package com.wrathOfLoD.Views.Menu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mistiansen on 4/15/16.
 */
public class MenuItem extends JComponent {

    private String name;


    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }

    public MenuItem(String name) {
        setName(name);
    }

    public void paintComponent(Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.BLUE);
        g.drawRect(x,y,width,height);
        g.drawString(getName(), x, y);


    }

}

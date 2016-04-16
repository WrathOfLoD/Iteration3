package com.wrathOfLoD.Views.Menu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Mistiansen on 4/15/16.
 */
public class MainMenu extends JFrame {

    private JPanel contentPanel;
    private ArrayList<MenuItem> menuItems = new ArrayList<>();


    public void paintComponent(Graphics g) {

        for (MenuItem menuItem: menuItems) {
            //menuItem.paintComponent(g);
        }
    }


}

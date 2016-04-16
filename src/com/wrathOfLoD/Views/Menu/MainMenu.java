package com.wrathOfLoD.Views.Menu;

import com.wrathOfLoD.Views.ContentDisplayStructure.MenuListStructure;
import com.wrathOfLoD.Views.StaticView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Mistiansen on 4/15/16.
 */
public class MainMenu extends StaticView {

    private JPanel contentPanel;
    private ArrayList<MenuItem> menuItems = new ArrayList<>();
    private MenuListStructure mls;

    public MainMenu() {
        initMenuItems();
        initDefaultUI();
    }

    public void initMenuItems() {
        menuItems.add(new MenuItem("Slothst in Space"));
        menuItems.add(new MenuItem("New Game"));
        menuItems.add(new MenuItem("Load Game"));
    }

    public void initDefaultUI() {
        setBackgroundImageFileName("resources/Backgrounds/spaceSlothDefault.png");
        //setLayout(new GridLayout(menuItems.size(),1,0,0)); // TODO: 4/16/2016 edit hgap and vgap?
       /*
        for (int i=0; i<menuItems.size(); i++) {
            this.add(menuItems.get(i));
        }
        */
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        mls = new MenuListStructure(menuItems.size(), 1, this.getWidth(), this.getHeight());
        int index = 0;
        for (MenuItem menuItem: menuItems) {
            menuItem.paintComponent(g, mls.calculateXCoord(index), mls.calculateYCoord(index), mls.calculateSlotWidth(), mls.calculateSlotHeight());
            index++;
        }
        g.setColor(Color.CYAN);
        g.drawRect(mls.calculateXCoord(4),400, 500,mls.calculateSlotHeight());

    }




}

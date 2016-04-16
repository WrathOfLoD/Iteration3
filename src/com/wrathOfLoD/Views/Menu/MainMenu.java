package com.wrathOfLoD.Views.Menu;

import com.wrathOfLoD.Views.ContentDisplayStructure.MenuListStructure;
import com.wrathOfLoD.Views.StaticView;
import com.wrathOfLoD.Views.ViewFactories.TextLabelFactory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Mistiansen on 4/15/16.
 */
public class MainMenu extends Menu {

    private MenuListStructure mls;

    public MainMenu() {
        initMenuItems();
        initDefaultUI();
    }

    public void initMenuItems() {
        this.addMenuItem(new MenuItem("New Game"));
        this.addMenuItem(new MenuItem("Load Game"));
    }

    public void initDefaultUI() {
        setBackgroundImageFileName("resources/Backgrounds/slothMenu.png");
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        mls = new MenuListStructure(this.getMenuItems().size(), 1, this.getWidth(), this.getHeight());
        int menuItemHeight = 100; // TODO: 4/16/2016 put this in constructor for MenuListStructure???
        int additionalVerticalOffset = 90;
        int index = 0;
        for (MenuItem menuItem: this.getMenuItems()) {
            g.setColor(Color.RED);
            g.setFont(new Font("Bauhaus 93", Font.ITALIC, 72));
            menuItem.paintComponent(g, mls.calculateXCoord(index), mls.calculateYCoord(index,menuItemHeight) + additionalVerticalOffset, mls.calculateSlotWidth(), menuItemHeight);
            index++;
        }
    }




}

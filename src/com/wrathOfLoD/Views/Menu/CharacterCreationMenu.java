package com.wrathOfLoD.Views.Menu;

import com.wrathOfLoD.Views.ContentDisplayStructure.MenuListStructure;

import java.awt.*;

/**
 * Created by echristiansen on 4/16/2016.
 */
public class CharacterCreationMenu extends Menu {

    //private String titleString = "Choose your Destiny";
    private String titleString = "Make your choice";
    private MenuListStructure mls;

    public CharacterCreationMenu() {
        initMenuItems();
        initDefaultUI();
    }

    public void initMenuItems() {
        this.addMenuItem(new MenuItem("Smasher"));
        this.addMenuItem(new MenuItem("Sneak"));
        this.addMenuItem(new MenuItem("Summoner"));
    }

    public void initDefaultUI() {
        setBackgroundImageFileName("resources/Backgrounds/occupationMenu.png");
    }

    public void paintComponent(Graphics g) {

        /*Setup the paint specification */
        super.paintComponent(g);
        mls = new MenuListStructure(this.getMenuItems().size(), 1, this.getWidth(), this.getHeight());
        int menuItemHeight = 100; // TODO: 4/16/2016 put this in constructor for MenuListStructure???
        int additionalVerticalOffset = 50;

        /*Add a title */
        g.setColor(Color.GREEN);
        g.setColor(new Color(0,0,255,255));
        g.setFont(new Font("Bauhaus 93", Font.BOLD, 84));
        int stringWidth = g.getFontMetrics().stringWidth(titleString);
        int stringHeight = g.getFontMetrics().getHeight();
        g.drawString(titleString, this.getWidth()/2 - stringWidth/2, stringHeight + 10);

        /* Paint all MenuItems */
        g.setColor(Color.RED);
        g.setFont(new Font("Bauhaus 93", Font.ITALIC, 72));
        int index = 0;
        for (MenuItem menuItem: this.getMenuItems()) {
            menuItem.paintComponent(g, mls.calculateXCoord(index), mls.calculateYCoord(index,menuItemHeight) + additionalVerticalOffset, mls.calculateSlotWidth(), menuItemHeight);
            index++;
        }
    }

}
package com.wrathOfLoD.Views.Menu;

import com.wrathOfLoD.Views.ContentDisplayStructure.MenuListStructure;

import java.awt.*;

/**
 * Created by echristiansen on 4/16/2016.
 */
public class PauseMenu extends Menu {

    private MenuListStructure mls;
    private String titleString = "Paused";

    public PauseMenu() {
        super();
        initMenuItems();
        initDefaultUI();
    }

    public void initMenuItems() {
        this.addMenuItem(new MenuItem("Resume Game"));
        this.addMenuItem(new MenuItem("Save Game"));
        this.addMenuItem(new MenuItem("Exit Game"));
        this.addMenuItem(new MenuItem("Options"));
    }

    public void initDefaultUI() {
        this.setBackground(new Color(0f,0f,0.7f,0.2f));
        //setBackgroundImageFileName("resources/Backgrounds/spaceSloth.png");
    }


    public void paintComponent(Graphics g) {

        /*Setup the paint specification */
        super.paintComponent(g);
        mls = new MenuListStructure(this.getMenuItems().size(), 1, this.getWidth(), this.getHeight());
        int menuItemHeight = 100; // TODO: 4/16/2016 put this in constructor for MenuListStructure???
        int additionalVerticalOffset = 0;

        /*Add a "Paused" title */
        g.setFont(new Font("Bauhaus 93", Font.BOLD, 84));
        int stringWidth = g.getFontMetrics().stringWidth(titleString);
        int stringHeight = g.getFontMetrics().getHeight();
        g.drawString(titleString, this.getWidth()/2 - stringWidth/2, stringHeight + 10);

        /* Paint all MenuItems */
        g.setColor(Color.RED);
        g.setFont(new Font("Bauhaus 93", Font.ITALIC, 72));

        this.paintMenuItems(g, mls, menuItemHeight, additionalVerticalOffset);
    }


}

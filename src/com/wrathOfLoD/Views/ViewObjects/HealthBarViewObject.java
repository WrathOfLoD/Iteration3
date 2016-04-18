package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Utility.Config;

import java.awt.*;

/**
 * Created by luluding on 4/17/16.
 */
public class HealthBarViewObject extends ModelViewObject {
    private int fullHealth;
    private int currentHealth;

    public HealthBarViewObject(int fullHealth, int currentHealth){
        super(Config.getEntityZLevel());
        this.fullHealth = fullHealth;
        this.currentHealth = currentHealth;
    }

    public void paintHealthBar(Graphics g, int x, int y, int width, int height, int maxHealth, int currentHealth, boolean visible){
        this.fullHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.paintComponent(g, x, y, width, height, visible);
    }

    @Override
    public void paintComponent(Graphics g, int x, int y, int width, int height, boolean visible) {
        //System.out.println("FULL: "+ fullHealth);
        //System.out.println("NOW: "+ currentHealth);
        if(!visible){
            return;
        }
        int maxHealthBarWidth = 50;
        int currentHealthBarWidth = (int)((double)currentHealth / (double)fullHealth * maxHealthBarWidth);

        //System.out.println("DRAW: "+ currentHealthBarWidth);
        g.setColor(Color.black);
        g.fillRect(x-2, y-2, maxHealthBarWidth+4, 11);
        g.setColor(Color.red);
        g.fillRect(x, y, maxHealthBarWidth, 7);
        g.setColor(Color.green);
        g.fillRect(x, y, currentHealthBarWidth, 7);
    }
}

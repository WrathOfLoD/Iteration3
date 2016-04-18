package com.wrathOfLoD.Views.ViewObjects;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by echristiansen on 4/17/2016.
 */
public abstract class StaticViewObject extends JPanel {
    private Object object;

    public Object getObject() {
        return object;
    }
    public void setObject(Object object) {
        this.object = object;
    }

    public abstract void paintComponent(Graphics g, int x, int y, int width, int height);

}

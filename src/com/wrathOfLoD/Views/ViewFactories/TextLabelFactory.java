package com.wrathOfLoD.Views.ViewFactories;

import javax.swing.*;
import java.awt.*;

/**
 * Created by echristiansen on 4/16/2016.
 */
public class TextLabelFactory {

    public TextLabelFactory() {

    }

    //public JLabel generateItemNameLabel(InventoryItem item, int fontSize, Color color) {
    public static JLabel generateTextLabel(String name, int fontSize, Color color) {
        JLabel textLabel = new JLabel(name);
        Font font = new Font(textLabel.getFont().getName(), Font.BOLD, fontSize);
        textLabel.setForeground(color);
        textLabel.setFont(font);
        return textLabel;
    }
}

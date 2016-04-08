package com.wrathOfLoD.Views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by erik on 4/7/2016.
 */
public abstract class View extends JPanel {

    private int viewWidth;
    private int viewHeight;
    private String backgroundImageFileName;

    public View() {
    }

    public int getViewWidth() {
        return viewWidth;
    }
    public void setViewWidth(int viewWidth) {
        this.viewWidth = viewWidth;
    }
    public int getViewHeight() {
        return viewHeight;
    }
    public void setViewHeight(int viewHeight) {
        this.viewHeight = viewHeight;
    }
    public String getBackgroundImageFileName() {
        return backgroundImageFileName;
    }
    public void setBackgroundImageFileName(String backgroundImageFileName) {
        this.backgroundImageFileName = backgroundImageFileName;
    }

    public final void generateImageBackground(String imageName, Graphics g) {
        ImageIcon itemIcon = new ImageIcon(imageName);
        Image backgroundImage = itemIcon.getImage();
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(),this);
    }

    public JLabel generateTitleLabel(String title, int fontSize, Color color) {
        JLabel titleLabel = new JLabel(title);
        Font font = new Font(titleLabel.getFont().getName(), Font.BOLD, fontSize);
        titleLabel.setForeground(color);
        titleLabel.setFont(font);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        return titleLabel;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        generateImageBackground(backgroundImageFileName, g);
    }

}

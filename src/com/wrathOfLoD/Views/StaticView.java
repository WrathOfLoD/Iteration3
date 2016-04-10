package com.wrathOfLoD.Views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by echristiansen on 4/8/2016.
 */
public class StaticView extends View {

    private int viewWidth;
    private int viewHeight;
    private JPanel contentPanel;
    private String backgroundImageFileName;

    public StaticView() {
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }
    public void setContentPanel(JPanel contentPanel) {
        this.contentPanel = contentPanel;
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

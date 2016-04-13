package com.wrathOfLoD.Views.AvatarIESView;


import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Views.ItemDisplayView.EquipmentView;
import com.wrathOfLoD.Views.ItemDisplayView.InventoryView;
import com.wrathOfLoD.Views.StaticView;
import com.wrathOfLoD.Views.StatsView.StatsView;
import com.wrathOfLoD.Views.View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by echristiansen on 4/8/2016.
 */
public class AvatarIESView extends StaticView {

    private InventoryView inventoryView;
    private StatsView statsView;
    private EquipmentView equipmentView;
    private StaticView containerPanel;
    private JPanel pushPanel;

    private static final int AVATARIES_VIEW_WIDTH =(int) Config.instance().getAvatarIESViewWidth();
    private static final int AVATARIES_VIEW_HEIGHT = (int) Config.instance().getAvatarIESViewHeight();

    public InventoryView getInventoryView() {
        return inventoryView;
    }
    public void setInventoryView(InventoryView iv) {
        this.inventoryView = iv;
    }
    public StatsView getStatsView() {
        return statsView;
    }
    public void setStatsView(StatsView sv) {
        this.statsView = sv;
    }
    public EquipmentView getEquipmentView() {
        return equipmentView;
    }
    public void setEquipmentView(EquipmentView ev) {
        this.equipmentView = ev;
    }

    public AvatarIESView(InventoryView iv, StatsView sv, EquipmentView ev) {
        setInventoryView(iv);
        setStatsView(sv);
        setEquipmentView(ev);
        //setBackgroundImageFileName("resources/slothSpaceTrade.png");
        initDefaultUI();
    }

    public void initDefaultUI() {

        pushPanel = new JPanel(); //this JPanel is used to center the CharacterView in the ViewManager. It "pushes" down the CharacterView in the ViewManager
        pushPanel.setPreferredSize(new Dimension(Config.instance().getAreaViewWidth(), Config.instance().getAreaViewHeight() / 6));
        pushPanel.setBackground(new Color(0f, 0f, 0f, 0f)); //pushPanel needs to be invisible
        this.setBackground(new Color(0f, 0f, 0f, 0f));
        this.setLayout(new FlowLayout());
        this.containerPanel = new StaticView();
        //this.containerPanel.setBackground(new Color(0f,0f,0f,0f));
        this.containerPanel.setBackgroundImageFileName("resources/Backgrounds/spaceSlothTrade.png");
        this.containerPanel.setPreferredSize(new Dimension(AVATARIES_VIEW_WIDTH, AVATARIES_VIEW_HEIGHT));
        this.containerPanel.setLayout(new GridLayout(1, 3));
        this.containerPanel.add(this.inventoryView);
        this.containerPanel.add(this.equipmentView);
        //this.containerPanel.add(this.statsView);
        this.add(pushPanel);
        this.add(containerPanel);
        this.containerPanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(15.0f)));

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}

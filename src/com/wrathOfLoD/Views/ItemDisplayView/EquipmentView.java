package com.wrathOfLoD.Views.ItemDisplayView;


import com.wrathOfLoD.Views.ContentDisplayStructure.EquipmentDisplayStructure;
import com.wrathOfLoD.Views.ViewObjects.EquippedItemViewObject;
import com.wrathOfLoD.Views.ViewObjects.ItemViewObject;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by echristiansen on 4/9/2016.
 */
public class EquipmentView extends ItemDisplayView {

        private EquipmentDisplayStructure eds;

        public EquipmentView() {

            this.setBackground(new Color(0f, 0f, 0f, 0f));
            this.setBorder(new LineBorder(Color.WHITE));

        }

        public void paintComponent(Graphics g) {

            eds = new EquipmentDisplayStructure(this.getWidth(), this.getHeight());

            int width = this.getWidth();
            int height = this.getHeight();
            g.setColor(Color.WHITE);
            g.drawLine(width/2, 0, width/2, height);
            g.drawLine(0, height/2, width, height/2);
            g.drawRect(eds.getHelmetX(), eds.getHelmetY(), eds.getSlotWidth(), eds.getslotHeight());
            g.drawRect(eds.getWeaponX(), eds.getWeaponY(), eds.getSlotWidth(), eds.getslotHeight());
            g.drawRect(eds.getChestX(), eds.getChestY(), eds.getSlotWidth(), eds.getslotHeight());
            g.drawRect(eds.getShieldX(), eds.getShieldY(), eds.getSlotWidth(), eds.getslotHeight());
            g.drawRect(eds.getLegsX(), eds.getLegsY(), eds.getSlotWidth(), eds.getslotHeight());

            // TODO: 4/9/2016 Create a Slot class, where each Slot has an x and a y and then we call slot.paintComponent and the check for whether or not something is null happens in the slot
            for (ItemViewObject evo: getIvoList()) {

            }

        }



    }



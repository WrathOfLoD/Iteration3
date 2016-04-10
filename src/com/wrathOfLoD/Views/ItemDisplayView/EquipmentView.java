package com.wrathOfLoD.Views.ItemDisplayView;


import com.wrathOfLoD.Views.ContentDisplayStructure.EquipmentDisplayStructure;

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
            int horLineLength = width/4;
            int vertLineLength = height/4;
            int boxWidth = width/10;
            int boxHeight = height/10;
            int x = horLineLength-boxWidth/2;
            int y = vertLineLength-boxHeight/2;
            g.setColor(Color.WHITE);

            g.drawLine(width/2, 0, width/2, height);
            g.drawLine(0, height/2, width, height/2);
            g.drawRect(2*horLineLength-boxWidth/2, y, boxWidth, boxHeight);
            //getIvoList().get(0).paintComponent(g, 2*x, y, boxWidth, boxHeight);
            for(int i=1; i<=3; i++) {
                g.drawRect(i*horLineLength-boxWidth/2, 2*vertLineLength-boxHeight/2, boxWidth, boxHeight);
                //getIvoList().get(i).paintComponent(g, i*x, 2*y, boxWidth, boxHeight);
            }
            g.drawRect(2*horLineLength-boxWidth/2, 3*vertLineLength-boxHeight/2, boxWidth, boxHeight);
            //getIvoList().get(i).paintComponent(g, 2*x, 3*y, boxWidth, boxHeight);

        }



    }



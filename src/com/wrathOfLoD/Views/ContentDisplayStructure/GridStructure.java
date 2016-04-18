package com.wrathOfLoD.Views.ContentDisplayStructure;

import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Views.ItemDisplayView.Slot.ItemSlot;
import com.wrathOfLoD.Views.ItemDisplayView.Slot.Slot;
import com.wrathOfLoD.Views.ViewObjects.StaticViewObject;

import java.awt.*;

/**
 * Created by erik on 4/7/2016.
 */
public class GridStructure extends ContentDisplayStructure { // TODO: 4/17/2016 ABSTRACT TO SLOTS, or make inventoryGridStructure???

    public GridStructure(int numRows, int numCols) {
        super(numRows,numCols);
    }

    @Override
        public int calculateXCoord(int index, int initialX){
            int columnSlotIndex = determineColumn(index);
            int slotWidth = calculateSlotWidth();
            int multipleX = 1 + 3*columnSlotIndex;
            int xCoord = (slotWidth/2)* multipleX + initialX;
            return xCoord;
        }

        @Override
        public int calculateYCoord(int index, int initialY) {
            int rowSlotIndex = determineRow(index);
            int multipleY = 1 + 3*rowSlotIndex;
            int slotHeight = calculateSlotHeight();
            int lineLength = slotHeight/2;
            int yCoord = ((slotHeight/2) * multipleY) + initialY;
            return yCoord;
        }

        @Override
        public int determineColumn(int index){
            int columnSlot = index%getNumCols();
            return columnSlot;
        }

        @Override
        public int determineRow(int index) {
            int rowSlot = index/getNumCols();
            return rowSlot;
        }


        @Override
        public int calculateSlotWidth() {
            int slotWidth = (int)(getDisplayWidth() * (2.0/((3*getNumCols())+1)));
            return slotWidth;
        }

        @Override
        public int calculateSlotHeight() {
            int slotHeight = (int)((getDisplayHeight()) * (2.0/((3*getNumRows())+1)));
            return slotHeight;
        }


    @Override
    public void paintComponent(Graphics g, int initialX, int initialY, int displayWidth, int displayHeight) {
        super.paintComponent(g, initialX, initialY, displayWidth, displayHeight);

//        int index = 0;
//        for (int i=0; i<getNumSlots(); i++) {
//            g.drawRect(calculateXCoord(index, initialX - 15), calculateYCoord(index, initialY - 15), calculateSlotWidth() + 30, calculateSlotHeight() + 30);
//            index++;
//        }
    }

}





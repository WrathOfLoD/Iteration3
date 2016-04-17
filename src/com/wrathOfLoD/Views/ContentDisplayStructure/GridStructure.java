package com.wrathOfLoD.Views.ContentDisplayStructure;

import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Views.ViewObjects.StaticViewObject;

import java.awt.*;

/**
 * Created by erik on 4/7/2016.
 */
public class GridStructure extends ContentDisplayStructure { // TODO: 4/17/2016 ABSTRACT TO SLOTS, or make inventoryGridStructure??? 

//    public GridStructure(int numRows, int numCols, int displayWidth, int displayHeight) {
//        super(numRows, numCols, displayWidth, displayHeight);
//    }

    public GridStructure(int numRows, int numCols) {
        super(numRows, numCols);
    }


//    public GridStructure(int numRows, int numCols, int displayWidth, int displayHeight) {
//        super(numRows, numCols, displayWidth, displayHeight);
//    }

    @Override
        public int calculateXCoord(int index){
            int columnSlotIndex = determineColumn(index);
            int slotWidth = calculateSlotWidth();
            int multipleX = 1 + 3*columnSlotIndex;
            int xCoord = (slotWidth/2)* multipleX;
            return xCoord;
        }

        @Override
        public int calculateYCoord(int index) {
            int rowSlotIndex = determineRow(index);
            int multipleY = 1 + 3*rowSlotIndex;
            int slotHeight = calculateSlotHeight();
            int lineLength = slotHeight/2;
            int yCoord = ((slotHeight/2) * multipleY);
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


        public void paintComponent(Graphics g, int displayWidth, int displayHeight) {
            super.paintComponent(g, displayWidth, displayHeight);
            //System.out.println("Calling paintComponent in gridstructure ");
        }



    }



/*

  @Override
        public int calculateXCoord(int displayWidth, int index){
            int columnSlotIndex = determineColumn(index);
            int slotWidth = calculateSlotWidth(displayWidth);
            int multipleX = 1 + 3*columnSlotIndex;
            int xCoord = (slotWidth/2)* multipleX;
            return xCoord;
        }

        @Override
        public int calculateYCoord(int displayHeight, int index) {
            int rowSlotIndex = determineRow(index);
            int multipleY = 1 + 3*rowSlotIndex;
            int slotHeight = calculateSlotHeight(displayHeight);
            int lineLength = slotHeight/2;
            int yCoord = ((slotHeight/2) * multipleY);
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
        public int calculateSlotWidth(int displayWidth) {
            int slotWidth = (int)(displayWidth * (2.0/((3*getNumCols())+1)));
            return slotWidth;
        }

        @Override
        public int calculateSlotHeight(int displayHeight) {
            int slotHeight = (int)((displayHeight) * (2.0/((3*getNumRows())+1)));
            return slotHeight;
        }


 */


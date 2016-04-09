package com.wrathOfLoD.Views.ContentDisplayStructure;

import java.awt.*;

/**
 * Created by erik on 4/7/2016.
 */
public class GridStructure extends ContentDisplayStructure {

    /*WIDTH = numCols;
    HEIGHT = numRows;
    So each Dimension is numCols, numRows
    getHeight() returns numRows
    getWidth() returns numCols
     */

        public GridStructure(Dimension dimension) {
        super(dimension);
    }

        public int calculateXCoord(int displayWidth, int index, int numCols){ //may be deprecated
            int columnSlotIndex = determineColumn(index, numCols);
            int slotWidth = calculateSlotWidth(displayWidth, numCols);
            int multipleX = 1 + 3*columnSlotIndex;
            int xCoord = (slotWidth/2)* multipleX;
            return xCoord;
        }

        public int calculateYCoord(int displayHeight, int index, int numRows, int numCols) { //may be deprecated
            int rowSlotIndex = determineRow(index, numCols);
            int multipleY = 1 + 3*rowSlotIndex;
            int slotHeight = calculateSlotHeight(displayHeight, numRows);
            int lineLength = slotHeight/2;
            int yCoord = ((slotHeight/2) * multipleY);
            return yCoord;
        }

        public int calculateXCoord(int displayWidth, int index){
            int columnSlotIndex = determineColumn(index, getDimension().width);
            int slotWidth = calculateSlotWidth(displayWidth, getDimension().height);
            int multipleX = 1 + 3*columnSlotIndex;
            int xCoord = (slotWidth/2)* multipleX;
            return xCoord;
        }

        public int calculateYCoord(int displayHeight, int index) {
            int rowSlotIndex = determineRow(index, getDimension().width);
            int multipleY = 1 + 3*rowSlotIndex;
            int slotHeight = calculateSlotHeight(displayHeight, getDimension().height);
            int lineLength = slotHeight/2;
            int yCoord = ((slotHeight/2) * multipleY);
            return yCoord;
        }

        public int determineColumn(int index, int numCols){
            int columnSlot = index%numCols;
            return columnSlot;
        }

        public int determineRow(int index, int numCols) {
            int rowSlot = index/numCols;
            return rowSlot;
        }

        public int calculateSlotWidth(int displayWidth, int numCols) {
            int slotWidth = (int)(displayWidth * (2.0/((3*numCols)+1)));
            return slotWidth;
        }

        public int calculateSlotHeight(int displayHeight, int numRows) {
            int slotHeight = (int)((displayHeight) * (2.0/((3*numRows)+1)));
            return slotHeight;
        }

        public int calculateSlotWidth(int displayWidth) {
            int slotWidth = (int)(displayWidth * (2.0/((3*getDimension().width)+1)));
            return slotWidth;
        }

        public int calculateSlotHeight(int displayHeight) {
            int slotHeight = (int)((displayHeight) * (2.0/((3*getDimension().height)+1)));
            return slotHeight;
        }

    }


package com.wrathOfLoD.Views.ContentDisplayStructure;

/**
 * Created by erik on 4/7/2016.
 */
public class GridStructure extends ContentDisplayStructure {


        public static int calculateXCoord(int displayWidth, int index, int numCols){
            int columnSlotIndex = determineColumn(index, numCols);
            int slotWidth = calculateSlotWidth(displayWidth, numCols);
            int multipleX = 1 + 3*columnSlotIndex;
            int xCoord = (slotWidth/2)* multipleX;
            return xCoord;
        }

        public static int calculateYCoord(int displayHeight, int index, int numRows, int numCols) {

            int rowSlotIndex = determineRow(index, numCols);
            int multipleY = 1 + 3*rowSlotIndex;
            int slotHeight = calculateSlotHeight(displayHeight, numRows);
            int lineLength = slotHeight/2;
            int yCoord = ((slotHeight/2) * multipleY);
            return yCoord;
        }

        public static int determineColumn(int index, int numCols){
            int columnSlot = index%numCols;
            return columnSlot;
        }

        public static int determineRow(int index, int numCols) {
            int rowSlot = index/numCols;
            return rowSlot;
        }

        public static int calculateSlotWidth(int displayWidth, int numCols) {
            int slotWidth = (int)(displayWidth * (2.0/((3*numCols)+1)));
            return slotWidth;
        }

        public static int calculateSlotHeight(int displayHeight, int numRows) {
            int slotHeight = (int)((displayHeight) * (2.0/((3*numRows)+1)));
            return slotHeight;
        }

    }


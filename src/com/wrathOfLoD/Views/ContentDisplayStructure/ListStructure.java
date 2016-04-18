package com.wrathOfLoD.Views.ContentDisplayStructure;

import java.awt.*;

/**
 * Created by erik on 4/7/2016.
 */
public class ListStructure extends ContentDisplayStructure {
    private int horOffset = 0;
    private int vertOffset = 0;

    public int getHorOffset() {
        return horOffset;
    }
    public void setHorOffset(int horOffset) {
        this.horOffset = horOffset;
    }
    public int getVertOffset() {
        return vertOffset;
    }
    public void setVertOffset(int vertOffset) {
        this.vertOffset = vertOffset;
    }

    public ListStructure(int numRows, int numCols, int horOffset, int vertOffset) {
        super(numRows, numCols);
        this.horOffset = horOffset;
        this.vertOffset = vertOffset;
    }

    public ListStructure(int numRows, int numCols) {
        super(numRows, numCols);
    }

    //to generalize, centered list x coord would be 1/2 of width - 1/2 item width
    //but want it to be centered with respect to the column
    //use num cols
    //if index<numRows, numCols=1; else, numCols = numCols specified by the user (store numCols in a temp variable)
    //


    @Override
    public int calculateXCoord(int index, int initialX) {
        int columnSlotIndex = determineColumn(index);
        int slotWidth = calculateSlotWidth();
        int multipleX = 0 + 3*columnSlotIndex; // TODO: 4/13/2016 change to 1 + 3*csi?
        int xCoord = (slotWidth/2)* multipleX + getHorOffset() + initialX;
        return xCoord;
    }

    @Override
    public int calculateYCoord(int index, int initialY) {
        int rowSlotIndex = determineRow(index);
        int multipleY = 0 + 3*rowSlotIndex; // TODO: 4/13/2016 change to 1 + 3*rsi?
        int slotHeight = calculateSlotHeight();
        int lineLength = slotHeight/2;
        int yCoord = ((slotHeight/2) * multipleY) + getVertOffset() + initialY;
        return yCoord;
    }

    //@Override
    public int calculateXCoord(int index) {
        int columnSlotIndex = determineColumn(index);
        int slotWidth = calculateSlotWidth();
        int multipleX = 0 + 3*columnSlotIndex; // TODO: 4/13/2016 change to 1 + 3*csi?
        int xCoord = (slotWidth/2)* multipleX + getHorOffset();
        return xCoord;
    }

    //@Override
    public int calculateYCoord(int index) {
        int rowSlotIndex = determineRow(index);
        int multipleY = 0 + 3*rowSlotIndex; // TODO: 4/13/2016 change to 1 + 3*rsi?
        int slotHeight = calculateSlotHeight();
        int lineLength = slotHeight/2;
        int yCoord = ((slotHeight/2) * multipleY) + getVertOffset();
        return yCoord;
    }

    @Override
    public int calculateSlotWidth() {
        int slotWidth = (int)(getDisplayWidth() * (2.0/((3*getNumCols())+1))); // TODO: 4/13/2016 could easily change this formula to just make it the width/numCols
        return slotWidth;
    }

    @Override
    public int calculateSlotHeight() {
        int slotHeight = (int)((getDisplayHeight()) * (2.0/((3*getNumRows())+1)));
        return slotHeight;
    }

    @Override
    public int determineColumn(int index){
        int columnSlot = index/getNumRows();
        return columnSlot;
    }

    @Override
    public int determineRow(int index) {
        int rowSlot = index%getNumRows();
        return rowSlot;
    }

    public void paintComponent(Graphics g, int displayWidth, int displayHeight) {
        //super.paintComponent(g, displayWidth, displayHeight);
        super.paintComponent(g);
    }

    /*

        @Override
    public int calculateXCoord(int displayWidth, int index){
        int columnSlotIndex = determineColumn(index);
        int slotWidth = calculateSlotWidth(displayWidth);
        int multipleX = 0 + 3*columnSlotIndex; // TODO: 4/13/2016 change to 1 + 3*csi?
        int xCoord = (slotWidth/2)* multipleX + getHorOffset();
        return xCoord;
    }

    @Override
    public int calculateYCoord(int displayHeight, int index) {
        int rowSlotIndex = determineRow(index);
        int multipleY = 0 + 3*rowSlotIndex; // TODO: 4/13/2016 change to 1 + 3*rsi?
        int slotHeight = calculateSlotHeight(displayHeight);
        int lineLength = slotHeight/2;
        int yCoord = ((slotHeight/2) * multipleY) + getVertOffset();
        return yCoord;
    }

    @Override
    public int calculateSlotWidth(int displayWidth) {
        int slotWidth = (int)(displayWidth * (2.0/((3*getNumCols())+1))); // TODO: 4/13/2016 could easily change this formula to just make it the width/numCols
        return slotWidth;
    }

    @Override
    public int calculateSlotHeight(int displayHeight) {
        int slotHeight = (int)((displayHeight) * (2.0/((3*getNumRows())+1)));
        return slotHeight;
    }
    */

}

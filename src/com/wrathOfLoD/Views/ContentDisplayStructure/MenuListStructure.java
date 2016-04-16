package com.wrathOfLoD.Views.ContentDisplayStructure;

import java.awt.*;

/**
 * Created by Mistiansen on 4/15/16.
 */
public class MenuListStructure {
    private int numRows;
    private int numCols;
    private int containerWidth;
    private int containerHeight;


    public int getNumRows() {
        return numRows;
    }
    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }
    public int getNumCols() {
        return numCols;
    }
    public void setNumCols(int numCols) {
        this.numCols = numCols;
    }
    public int getContainerWidth() {
        return containerWidth;
    }
    public void setContainerWidth(int containerWidth) {
        this.containerWidth = containerWidth;
    }
    public int getContainerHeight() {
        return containerHeight;
    }
    public void setContainerHeight(int containerHeight) {
        this.containerHeight = containerHeight;
    }


    public MenuListStructure(int numRows, int numCols, int containerWidth, int containerHeight) {
        setNumRows(numRows);
        setNumCols(numCols);
        setContainerWidth(containerWidth);
        setContainerHeight(containerHeight);
    }


    public int calculateXCoord(int index) {
        int offsetConstant = (2*calculateHorLineLength()-calculateSlotWidth()/2);
        int xCoord = offsetConstant + determineColumn(index)* offsetConstant;
        System.out.println("MENU item xCoord at : " + xCoord);
        return xCoord;
    }

    public int calculateYCoord(int index) {
        int initialOffset = getContainerHeight()/3;
        int offsetConstant = (2*calculateVertLineLength()-calculateRowHeight()/2);
        int yCoord = offsetConstant + determineRow(index)*offsetConstant;
        //int yCoord = initialOffset + determineRow(index)*
        System.out.println("MENU item yCoord at : " + yCoord);
        return yCoord;
    }

    public int calculateColWidth() {
        int colWidth = getContainerWidth()/getNumCols();
        return colWidth;
    }

    public int calculateRowHeight() {
        int rowHeight = getContainerHeight()/getNumRows();
        return rowHeight;
    }

    /* A "line" is a unit of measurement. Columns are divided into a certain number of line segments of equal length (4 for now*/
    private int calculateHorLineLength() {
        int lineLength = calculateColWidth()/4;
        return lineLength;
    }

    /* A  */
    private int calculateVertLineLength(){
        int lineLength = calculateRowHeight()/3;
        return lineLength;
    }

    /*The slot width is the width of an individual item in a list. */
    public int calculateSlotWidth(){
        int slotWidth = 2*calculateHorLineLength();
        return slotWidth;
    }

    public int calculateSlotHeight() {
        int slotHeight = calculateVertLineLength();
        return slotHeight;
    }

    private int determineColumn(int index){
        int columnSlot = index/getNumRows();
        return columnSlot;
    }


    private int determineRow(int index) {
        int rowSlot = index%getNumRows();
        return rowSlot;
    }



}

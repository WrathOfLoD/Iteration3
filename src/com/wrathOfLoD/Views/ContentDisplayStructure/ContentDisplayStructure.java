package com.wrathOfLoD.Views.ContentDisplayStructure;

import com.wrathOfLoD.Views.ItemDisplayView.Slot.Slot;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by erik on 4/7/2016.
 */
public abstract class ContentDisplayStructure extends JPanel /* implements Selectable */ {

    private ArrayList<Slot> slotList = new ArrayList<>();
    private int numRows;
    private int numCols;
    private int displayWidth;
    private int displayHeight;
    private int numSlots;

    public int getNumSlots() {
        return numSlots;
    }
    public void setNumSlots(int numSlots) {
        this.numSlots = numSlots;
    }
    public int getDisplayWidth() {
        return displayWidth;
    }
    public void setDisplayWidth(int displayWidth) {
        this.displayWidth = displayWidth;
    }
    public int getDisplayHeight() {
        return displayHeight;
    }
    public void setDisplayHeight(int displayHeight) {
        this.displayHeight = displayHeight;
    }
    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }
    public void setNumCols(int numCols) {
        this.numCols = numCols;
    }
    public int getNumRows() {
        return numRows;
    }
    public int getNumCols() {
        return numCols;
    }

    public ArrayList<Slot> getSlotList() {
        return slotList;
    }
    public void setSlotList(ArrayList<Slot> slotList) {
        this.slotList = slotList;
    }
    public void addSlot(Slot slot) {
        //getSlotList().add(slot);
        slotList.add(slot);
    }
    public void resetSlots() {
        getSlotList().clear();
    }

    public ContentDisplayStructure(int numRows, int numCols) {
        if(numRows<1 || numCols<1) {
            System.out.println("Attempting to setup display structure with invalid rows and/or columns");
            return;
        } else {
            setBackground(new Color(0f,0f,0f,0f));
            setNumRows(numRows);
            setNumCols(numCols);
            setNumSlots(numRows*numCols);
        }
    }

    // TODO: 4/13/2016 maybe make default implementations for some of these 
    public abstract int calculateXCoord(int index, int initialX);
    public abstract int calculateYCoord(int index, int initialY);
    public abstract int determineColumn(int index);
    public abstract int determineRow(int index);
    public abstract int calculateSlotWidth();
    public abstract int calculateSlotHeight();

    public void selectSlot(int index) {
        getSlotList().get(index).select();
    }



//    public void paintComponent(Graphics g, int displayWidth, int displayHeight){
    public void paintComponent(Graphics g, int initialX, int initialY, int displayWidth, int displayHeight){
        super.paintComponent(g);
        setDisplayWidth(displayWidth);
        setDisplayHeight(displayHeight);
        int x;
        int y;
        int slotWidth = calculateSlotWidth();
        int slotHeight = calculateSlotHeight();
        int index = 0;
            for(Slot slot: getSlotList()) {
                x = calculateXCoord(index, initialX);
                y = calculateYCoord(index, initialY);
                slot.paintComponent(g, x, y, slotWidth, slotHeight);
                index++;
            }
    }



}
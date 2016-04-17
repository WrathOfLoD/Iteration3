package com.wrathOfLoD.Views.ContentDisplayStructure;

import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Views.ItemDisplayView.Slot.Slot;
import com.wrathOfLoD.Views.Selectable;
import com.wrathOfLoD.Views.ViewObjects.InventoryItemViewObject;
import com.wrathOfLoD.Views.ViewObjects.ItemViewObject;
import com.wrathOfLoD.Views.ViewObjects.StaticViewObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by erik on 4/7/2016.
 */
public abstract class ContentDisplayStructure extends JPanel /* implements Selectable */ {

    //private ArrayList<StaticViewObject> svoList = new ArrayList<>();
    private ArrayList<Slot> slotList = new ArrayList<>();
    private int numRows;
    private int numCols;
    private int displayWidth;
    private int displayHeight;

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

//    public ContentDisplayStructure(int numRows, int numCols, int displayWidth, int displayHeight) {
//        setNumRows(numRows);
//        setNumCols(numCols);
//        setDisplayWidth(displayWidth);
//        setDisplayHeight(displayHeight);
//    }
//    public ArrayList<StaticViewObject> getSvoList() {
//        return svoList;
//    }
//    public void setSvoList(ArrayList<StaticViewObject> svoList) {
//        this.svoList = svoList;
//    }
//    public void addViewObject(StaticViewObject svo) {
//        svoList.add(svo);
//    }


    public ArrayList<Slot> getSlotList() {
        return slotList;
    }
    public void setSlotList(ArrayList<Slot> slotList) {
        this.slotList = slotList;
    }
    public void addSlot(Slot slot) {
        slotList.add(slot);
    }

    public ContentDisplayStructure(int numRows, int numCols) {
        if(numRows<1 || numCols<1) {
            System.out.println("Attempting to setup display structure with invalid rows and/or columns");
            return;
        } else {
            setNumRows(numRows);
            setNumCols(numCols);
        }
    }

//    public ContentDisplayStructure(int numRows, int numCols, int displayWidth, int displayHeight) {
//        if(numRows<1 || numCols<1) {
//            System.out.println("Attempting to setup display structure with invalid rows and/or columns");
//            return;
//        } else {
//            setDisplayWidth(displayWidth);
//            setDisplayHeight(displayHeight);
//            setNumRows(numRows);
//            setNumCols(numCols);
//        }
//    }

    // TODO: 4/13/2016 maybe make default implementations for some of these 
    //public abstract int calculateXCoord(int displayWidth, int index);
    //public abstract int calculateYCoord(int displayHeight, int index);
    public abstract int calculateXCoord(int index);
    public abstract int calculateYCoord(int index);
    public abstract int determineColumn(int index);
    public abstract int determineRow(int index);
    public abstract int calculateSlotWidth();
    public abstract int calculateSlotHeight();
//    public abstract int calculateSlotWidth(int displayWidth);
//    public abstract int calculateSlotHeight(int displayHeight);
    
    

    /* Could probably have this abstract class then have the subclasses implement the methods
        but no need to make static. Will just have an instance in whatever class uses?
        Probably not necessary.
        Which is better: have classes that use a contentstructure have a reference to the structure and instantiate with
        their width and so forth? Or have Static methods that can be used when passed in the appropriate parameters?
     */

    public void paintComponent(Graphics g, int displayWidth, int displayHeight){
        super.paintComponent(g);
        setDisplayWidth(displayWidth);
        setDisplayHeight(displayHeight);
        int x;
        int y;
        int slotWidth = calculateSlotWidth();
        int slotHeight = calculateSlotHeight();
        int index = 0;
        //System.out.println("Calling pc in CDS:" + index);
        //System.out.println("Calling pc in CDS:" + getSlotList().size());
        System.out.println("Calling pc in CDS:" + getSlotList());
        if(getSlotList().size()>0) {
            for(Slot slot: getSlotList()) {
                x = calculateXCoord(index);
                y = calculateYCoord(index);
                slot.paintComponent(g, x, y, slotWidth, slotHeight);
                index++;
                System.out.println("Calling pc in CDS:" + index);
            }
        }
    }


    /*
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setDisplayWidth(getDisplayWidth());
        setDisplayHeight(getDisplayHeight());
        int x;
        int y;
        int slotWidth = calculateSlotWidth();
        int slotHeight = calculateSlotHeight();
        int index = 0;
        if(getSlotList().size()>0) {
            for(Slot slot: getSlotList()) {
                x = calculateXCoord(index);
                y = calculateYCoord(index);
                slot.paintComponent(g, x, y, slotWidth, slotHeight);
                index++;
            }
        }
    }
    */


}
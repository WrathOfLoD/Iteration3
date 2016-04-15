package com.wrathOfLoD.Views.ContentDisplayStructure;

import javax.swing.*;
import java.awt.*;

/**
 * Created by erik on 4/7/2016.
 */
public abstract class ContentDisplayStructure {

    private int numRows;
    private int numCols;

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

    public ContentDisplayStructure(int numRows, int numCols) {
        if(numRows<1 || numCols<1) {
            System.out.println("Attempting to setup display structure with invalid rows and/or columns");
            return;
        } else {
            setNumRows(numRows);
            setNumCols(numCols);
        }
    }

    // TODO: 4/13/2016 maybe make default implementations for some of these 
    public abstract int calculateXCoord(int displayWidth, int index);
    public abstract int calculateYCoord(int displayHeight, int index);
    public abstract int determineColumn(int index);
    public abstract int determineRow(int index);
    public abstract int calculateSlotWidth(int displayWidth);
    public abstract int calculateSlotHeight(int displayHeight);
    
    

    /* Could probably have this abstract class then have the subclasses implement the methods
        but no need to make static. Will just have an instance in whatever class uses?
        Probably not necessary.
        Which is better: have classes that use a contentstructure have a reference to the structure and instantiate with
        their width and so forth? Or have Static methods that can be used when passed in the appropriate parameters?
     */

}
package com.wrathOfLoD.Views.ContentDisplayStructure;

import javax.swing.*;
import java.awt.*;

/**
 * Created by erik on 4/7/2016.
 */
public abstract class ContentDisplayStructure {

    private Dimension dimension;
    public Dimension getDimension() {
        return dimension;
    }
    public void setDimension(Dimension dimension) {
        setDimension(dimension);
    }

    public ContentDisplayStructure(Dimension dimension) {
        setDimension(dimension);
    }

    public abstract int calculateXCoord(int displayWidth, int index);
    public abstract int calculateYCoord(int displayHeight, int index);
    public abstract int calculateXCoord(int displayWidth, int index, int numCols); //may be deprecated
    public abstract int calculateYCoord(int displayHeight, int index, int numRows, int numCols); //may be deprecated
    public abstract int determineColumn(int index, int numCols);
    public abstract int determineRow(int index, int numCols);
    public abstract int calculateSlotWidth(int displayWidth, int numCols);
    public abstract int calculateSlotHeight(int displayHeight, int numRows);


    /* Could probably have this abstract class then have the subclasses implement the methods
        but no need to make static. Will just have an instance in whatever class uses?
        Probably not necessary.
        Which is better: have classes that use a contentstructure have a reference to the structure and instantiate with
        their width and so forth? Or have Static methods that can be used when passed in the appropriate parameters?
     */

}
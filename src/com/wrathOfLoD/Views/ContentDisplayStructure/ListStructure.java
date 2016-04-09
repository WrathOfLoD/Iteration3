package com.wrathOfLoD.Views.ContentDisplayStructure;

import java.awt.*;

/**
 * Created by erik on 4/7/2016.
 */
public class ListStructure extends ContentDisplayStructure {

    public ListStructure(Dimension dimension) {
        super(dimension);
    }

    @Override
    public int calculateXCoord(int displayWidth, int index) {
        return 0;
    }

    @Override
    public int calculateYCoord(int displayHeight, int index) {
        return 0;
    }

    @Override
    public int calculateXCoord(int displayWidth, int index, int numCols) {
        return 0;
    }

    @Override
    public int calculateYCoord(int displayHeight, int index, int numRows, int numCols) {
        return 0;
    }

    @Override
    public int determineColumn(int index, int numCols) {
        return 0;
    }

    @Override
    public int determineRow(int index, int numCols) {
        return 0;
    }

    @Override
    public int calculateSlotWidth(int displayWidth, int numCols) {
        return 0;
    }

    @Override
    public int calculateSlotHeight(int displayHeight, int numRows) {
        return 0;
    }

    @Override
    public int calculateSlotWidth(int displayWidth) {
        return 0;
    }

    @Override
    public int calculateSlotHeight(int displayHeight) {
        return 0;
    }
}

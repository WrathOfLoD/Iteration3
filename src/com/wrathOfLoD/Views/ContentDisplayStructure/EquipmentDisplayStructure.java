package com.wrathOfLoD.Views.ContentDisplayStructure;

import java.awt.*;

/**
 * Created by echristiansen on 4/9/2016.
 */
public class EquipmentDisplayStructure {

    private int structureWidth;
    private int structureHeight;
    private int slotWidth;
    private int slotHeight;
    private int widthDivisor = 10; //used to determine how wide a slot should be relative to the overall width of the structure
    private int heightDivisor = 10;//used to determine how tall a slot shoudl be relative to the overall width of the structure

    public int getSlotWidth() {
        return slotWidth;
    }
    public void setSlotWidth(int boxWidth) {
        this.slotWidth = boxWidth;
    }
    public int getslotHeight() {
        return slotHeight;
    }
    public void setSlotHeight(int boxHeight) {
        this.slotHeight = boxHeight;
    }
    public int getStructureWidth() {
        return structureWidth;
    }
    public void setStructureWidth(int structureWidth) {
        this.structureWidth = structureWidth;
    }
    public int getStructureHeight() {
        return structureHeight;
    }
    public void setStructureHeight(int structureHeight) {
        this.structureHeight = structureHeight;
    }

    public EquipmentDisplayStructure(int viewWidth, int viewHeight) {
        setStructureWidth(viewWidth);
        setStructureHeight(viewHeight);
        setSlotWidth(getStructureWidth()/widthDivisor);
        setSlotHeight(getStructureHeight()/heightDivisor);
    }

    public int calculateXCoordFromSlot(int slot){
        int horLineLength = getStructureWidth()/4;
        int x = slot*horLineLength-getSlotWidth()/2;
        return x;
    }




}

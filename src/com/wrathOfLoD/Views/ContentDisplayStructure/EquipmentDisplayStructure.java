package com.wrathOfLoD.Views.ContentDisplayStructure;

import com.sun.prism.image.Coords;
import com.wrathOfLoD.Views.ItemDisplayView.Slot.Slot;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by echristiansen on 4/9/2016.
 */
public class EquipmentDisplayStructure extends ContentDisplayStructure {

    private int slotWidth;
    private int slotHeight;
    private int widthDivisor = 7; //used to determine how wide a slot should be relative to the overall width of the structure
    private int heightDivisor = 7;//used to determine how tall a slot shoudl be relative to the overall width of the structure
    private int helmetX;
    private int helmetY;
    private int weaponX;
    private int weaponY;
    private int chestX;
    private int chestY;
    private int shieldX;
    private int shieldY;
    private int legsX;
    private int legsY;
    private int numSlots = 4;
    private int[] xArray = new int[numSlots];
    private int[] yArray = new int[numSlots];
    private ArrayList<Slot> equipmentSlotList = new ArrayList<>();


    public ArrayList<Slot> getEquipmentSlotList() {
        return equipmentSlotList;
    }
    public void setEquipmentSlotList(ArrayList<Slot> equipmentSlotList) {
        this.equipmentSlotList = equipmentSlotList;
    }
    public int getNumSlots() {
        return numSlots;
    }
    public void setNumSlots(int numSlots) {
        this.numSlots = numSlots;
    }
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

    public int getHelmetX() {
        return helmetX;
    }
    public void setHelmetX(int helmetX) {
        this.helmetX = helmetX;
    }
    public int getHelmetY() {
        return helmetY;
    }
    public void setHelmetY(int helmetY) {
        this.helmetY = helmetY;
    }
    public int getWeaponX() {
        return weaponX;
    }
    public void setWeaponX(int weaponX) {
        this.weaponX = weaponX;
    }
    public int getWeaponY() {
        return weaponY;
    }
    public void setWeaponY(int weaponY) {
        this.weaponY = weaponY;
    }
    public int getChestX() {
        return chestX;
    }
    public void setChestX(int chestX) {
        this.chestX = chestX;
    }
    public int getChestY() {
        return chestY;
    }
    public void setChestY(int chestY) {
        this.chestY = chestY;
    }
    public int getShieldX() {
        return shieldX;
    }
    public void setShieldX(int shieldX) {
        this.shieldX = shieldX;
    }
    public int getShieldY() {
        return shieldY;
    }
    public void setShieldY(int shieldY) {
        this.shieldY = shieldY;
    }
    public int getLegsX() {
        return legsX;
    }
    public void setLegsX(int legsX) {
        this.legsX = legsX;
    }
    public int getLegsY() {
        return legsY;
    }
    public void setLegsY(int legsY) {
        this.legsY = legsY;
    }


//    public EquipmentDisplayStructure(int viewWidth, int viewHeight) {
//        setStructureWidth(viewWidth);
//        setStructureHeight(viewHeight);
//        setSlotWidthgetDisplayWidth ()()/widthDivisor);
//        setSlotHeight(getDisplayHeight()()/heightDivisor);
//        calculateCoords();
//    }

    public EquipmentDisplayStructure(int numRows, int numCols) {
        super(numRows,numCols);
    }


    public void calculateCoords(int displayWidth, int displayHeight) {
        int horlineLength = displayWidth/4;
        int vertLineLength = displayHeight/4;
        setSlotWidth(displayWidth/widthDivisor);
        setSlotHeight(displayHeight/heightDivisor);
        setHelmetX(2*horlineLength-getSlotWidth()/2);
        setWeaponX(horlineLength-getSlotWidth()/2 - getSlotWidth()/2);
        setChestX(2*horlineLength-getSlotWidth()/2);
        setShieldX(3*horlineLength-getSlotWidth()/2 + getSlotWidth()/2);
        setLegsX(2*horlineLength-getSlotWidth()/2);

        setHelmetY(vertLineLength-getslotHeight()/2 - vertLineLength/4);
        setWeaponY(2*vertLineLength-getslotHeight()/2);
        //setWeaponY((int)(1.5*vertLineLength) - getslotHeight()/2);
        setChestY(2*vertLineLength-getslotHeight()/2);
        setShieldY(2*vertLineLength-getslotHeight()/2);
        setLegsY(3*vertLineLength-getslotHeight()/2 + vertLineLength/4);

        xArray[0] = getHelmetX();
        xArray[1] = getWeaponX();
        xArray[2] = getChestX();
        xArray[3] = getLegsX();

        yArray[0] = getHelmetY();
        yArray[1] = getWeaponY();
        yArray[2] = getChestY();
        yArray[3] = getLegsY();

    }


    //@Override
    public int calculateXCoord(int index, int initialX) {
        if (index<numSlots) {
            return xArray[index] + initialX;
        } else {
            return 0;
        }
    }

    //@Override
    public int calculateYCoord(int index, int initialY) {
        if (index<numSlots) {
            return yArray[index] + initialY;
        } else {
            return 0;
        }
    }


    @Override
    public int determineColumn(int index) {
        return 0;
    }

    @Override
    public int determineRow(int index) {
        return 0;
    }

    @Override
    public int calculateSlotWidth() {
        int slotWidth = getDisplayWidth()/widthDivisor;
        return slotWidth;
    }

    @Override
    public int calculateSlotHeight() {
        int slotHeight = getDisplayHeight()/heightDivisor;
        return slotHeight;
    }

    @Override
    public void paintComponent(Graphics g, int initialX, int initialY, int displayWidth, int displayHeight) {
        calculateCoords(displayWidth, displayHeight);
        super.paintComponent(g, initialX, initialY, displayWidth, displayHeight);


    }
}

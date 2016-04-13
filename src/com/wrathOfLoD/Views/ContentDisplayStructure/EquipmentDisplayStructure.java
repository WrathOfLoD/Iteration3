package com.wrathOfLoD.Views.ContentDisplayStructure;

import com.sun.prism.image.Coords;

import java.awt.*;

/**
 * Created by echristiansen on 4/9/2016.
 */
public class EquipmentDisplayStructure {

    private int structureWidth; //this is really the width of the view in which the structure is found
    private int structureHeight; //this is reallly the height of the view in which the structure is found
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


    public EquipmentDisplayStructure(int viewWidth, int viewHeight) {
        setStructureWidth(viewWidth);
        setStructureHeight(viewHeight);
        setSlotWidth(getStructureWidth()/widthDivisor);
        setSlotHeight(getStructureHeight()/heightDivisor);
        calculateCoords();
    }


    public void calculateCoords() {
        int horlineLength = getStructureWidth()/4;
        int vertLineLength = getStructureHeight()/4;
        setHelmetX(2*horlineLength-getSlotWidth()/2);
        setWeaponX(horlineLength-getSlotWidth()/2 - getSlotWidth()/2);
        setChestX(2*horlineLength-getSlotWidth()/2);
        setShieldX(3*horlineLength-getSlotWidth()/2 + getSlotWidth()/2);
        setLegsX(2*horlineLength-getSlotWidth()/2);

        setHelmetY(vertLineLength-getslotHeight()/2 - vertLineLength/4);
        setWeaponY(2*vertLineLength-getslotHeight()/2);
        setChestY(2*vertLineLength-getslotHeight()/2);
        setShieldY(2*vertLineLength-getslotHeight()/2);
        setLegsY(3*vertLineLength-getslotHeight()/2 + vertLineLength/4);
    }




}

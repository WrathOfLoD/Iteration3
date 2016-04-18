package com.wrathOfLoD.Views.ItemDisplayView;

import com.wrathOfLoD.Models.Inventory.Equipment;
import com.wrathOfLoD.Observers.Observer;
import com.wrathOfLoD.Views.ContentDisplayStructure.EquipmentDisplayStructure;
import com.wrathOfLoD.Views.ItemDisplayView.Slot.EquipmentSlot;
import com.wrathOfLoD.Views.ViewFactories.ViewObjectFactory.EquippedIVOFactory;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by echristiansen on 4/9/2016.
 */

public class EquipmentView extends JPanel implements Observer { // TODO: 4/12/2016 might need more specific observer, or to move the implementation to ItemDisplayView. Might need to extend ItemDisplayView


    @Override
    public void update() {
        //updateEquipment(equipment); // TODO: 4/12/2016 we call update rather than
        fillSlots();
        System.out.println("ATTEMPTING AN Equipment change from equipment VIEW");

    }

    private int currentIndex;
    private int numSlots = 4;
    private Equipment equipment;
    private EquipmentSlot helmetSlot = new EquipmentSlot(null);
    private EquipmentSlot weaponSlot = new EquipmentSlot(null);
    private EquipmentSlot chestSlot = new EquipmentSlot(null);
    private EquipmentSlot shieldSlot = new EquipmentSlot(null);
    private EquipmentSlot greavesSlot = new EquipmentSlot(null);
    private EquipmentDisplayStructure eds;



    public int getCurrentIndex() {
        return currentIndex;
    }
    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }
    public EquipmentSlot getHelmetSlot() {
        return helmetSlot;
    }
    public void setHelmetSlot(EquipmentSlot helmetSlot) {
        this.helmetSlot = helmetSlot;
    }
    public EquipmentSlot getWeaponSlot() {
        return weaponSlot;
    }
    public void setWeaponSlot(EquipmentSlot weaponSlot) {
        this.weaponSlot = weaponSlot;
    }
    public EquipmentSlot getChestSlot() {
        return chestSlot;
    }
    public void setChestSlot(EquipmentSlot chestSlot) {
        this.chestSlot = chestSlot;
    }
    public EquipmentSlot getShieldSlot() {
        return shieldSlot;
    }
    public void setShieldSlot(EquipmentSlot shieldSlot) {
        this.shieldSlot = shieldSlot;
    }
    public EquipmentSlot getGreavesSlot() {
        return greavesSlot;
    }
    public void setGreavesSlot(EquipmentSlot greavesSlot) {
        this.greavesSlot = greavesSlot;
    }
    public Equipment getEquipment() {
        return equipment;
    }
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
        getEquipment().registerObserver(this); // TODO: 4/12/2016 might need to delete this...but I think it's good spot
    }

        public EquipmentView(Equipment equipment) {
            setEquipment(equipment);
            //setTitle("Equipment");
            //getEquipment().addObserver(this);
            fillSlots();
            this.setBackground(new Color(0f, 0f, 0f, 0f));
            this.setBorder(new LineBorder(Color.WHITE));
        }

    public void initializeSlots(){ // TODO: 4/12/2016 might not need this. Could do this or a variant of this or just use the null constructors above
        setHelmetSlot(new EquipmentSlot(EquippedIVOFactory.generateEquippedIVO(getEquipment().getHelm())));
        setWeaponSlot(new EquipmentSlot(EquippedIVOFactory.generateEquippedIVO(getEquipment().getWeapon())));
        setChestSlot(new EquipmentSlot(EquippedIVOFactory.generateEquippedIVO(getEquipment().getArmor())));
        //setShieldSlot(new EquipmentSlot(EquippedIVOFactory.generateEquippedIVO(getEquipment().))); // TODO: 4/12/2016 add shield class to equipment
        setGreavesSlot(new EquipmentSlot(EquippedIVOFactory.generateEquippedIVO(getEquipment().getGreaves())));
    }

    public void fillSlots() {
        //System.out.println("Hlmet is this: " + getEquipment().getHelm().getName());
        getHelmetSlot().addToSlot(EquippedIVOFactory.generateEquippedIVO(getEquipment().getHelm()));
        getWeaponSlot().addToSlot(EquippedIVOFactory.generateEquippedIVO(getEquipment().getWeapon()));
        getChestSlot().addToSlot(EquippedIVOFactory.generateEquippedIVO(getEquipment().getArmor()));
        getGreavesSlot().addToSlot(EquippedIVOFactory.generateEquippedIVO(getEquipment().getGreaves()));
    }


        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int contentWidth = this.getWidth();
            //int contentHeight = this.getHeight()-getTitlePanel().getHeight();
            int contentHeight = this.getHeight();

            //eds = new EquipmentDisplayStructure(this.getWidth(), this.getHeight());
            eds = new EquipmentDisplayStructure(contentWidth, contentHeight);

            g.setColor(Color.WHITE);
            g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
            g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);

            getHelmetSlot().paintComponent(g,eds.getHelmetX(),eds.getHelmetY(),eds.getSlotWidth(),eds.getslotHeight());
            getWeaponSlot().paintComponent(g,eds.getWeaponX(), eds.getWeaponY(), eds.getSlotWidth(), eds.getslotHeight());
            getChestSlot().paintComponent(g,eds.getChestX(),eds.getChestY(),eds.getSlotWidth(),eds.getslotHeight());
            //getShieldSlot().paintComponent(g,eds.getHelmetX(),eds.getHelmetY(),eds.getSlotWidth(),eds.getslotHeight());
            getGreavesSlot().paintComponent(g,eds.getLegsX(),eds.getLegsY(),eds.getSlotWidth(),eds.getslotHeight());


            // TODO: 4/9/2016 Create a Slot class, where each Slot has an x and a y and then we call slot.paintComponent and the check for whether or not something is null happens in the slot


        }



    /**
     * desc: Paint view with next item in row selected
     */
    public void selectNextItem() {
        this.safeIncrementRight();
    }

    /**
     * desc: Increment to next index in row, makes sure not to wrap around
     */
    public void safeIncrementRight() {
        int nextIndex = getCurrentIndex()+1;
        if (nextIndex<=eds.getNumSlots()) {
            setCurrentIndex(nextIndex);
        }
    }

    /**
     * desc: Paint view with previous item in row selected
     */
    public void selectPrevItem() {
        this.safeDecrementLeft();
    }

    /**
     * desc: Decrement to previous index in row, makes sure not to wrap around
     */
    public void safeDecrementLeft() {
      int nextIndex = getCurrentIndex()-1;
        if (nextIndex>=0) {
            setCurrentIndex(nextIndex);
        }
    }

    /**
     * desc: Paint view with prev item in col selected
     */
    public void selectUpItem() {
        this.safeDecrementUp();
    }

    /**
     * desc: Decrement to previous column, makes sure not to wrap around
     */
    public void safeDecrementUp() {
        int nextIndex = getCurrentIndex()-1;
        if (nextIndex>=0) {
            setCurrentIndex(nextIndex);
        }
    }

    /**
     * desc: Paint view with next item in col selected
     */
    public void selectDownItem() {
        this.safeIncrementDown();
    }

    /**
     * desc: Increment to next column, makes sure not to wrap around
     */
    public void safeIncrementDown() {
        int nextIndex = getCurrentIndex()+1;
        if (nextIndex<=eds.getNumSlots()) {
            setCurrentIndex(nextIndex);
        }
    }

    /**
     * desc: Return the currently selected item
     */
    public Object useSelectedItem() {
        System.out.println(eds.getEquippedItemViewObjects().get(currentIndex).getObject());
        return eds.getEquippedItemViewObjects().get(currentIndex).getObject();
    }



    }



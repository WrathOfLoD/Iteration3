package com.wrathOfLoD.Views.ItemDisplayView;

import com.wrathOfLoD.Models.Inventory.Equipment;
import com.wrathOfLoD.Observers.Observer;
import com.wrathOfLoD.Views.ContentDisplayStructure.ContentDisplayStructure;
import com.wrathOfLoD.Views.ContentDisplayStructure.EquipmentDisplayStructure;
import com.wrathOfLoD.Views.ItemDisplayView.Slot.ItemSlot;
import com.wrathOfLoD.Views.ItemDisplayView.Slot.Slot;
import com.wrathOfLoD.Views.ViewObjects.GraphicViewObject;
import com.wrathOfLoD.Views.ViewObjects.ItemViewObject;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by echristiansen on 4/9/2016.
 */

public class EquipmentView extends ItemDisplayView { // TODO: 4/12/2016 might need more specific observer, or to move the implementation to ItemDisplayView. Might need to extend ItemDisplayView

    @Override
    public void update() {
        //updateEquipment(equipment); // TODO: 4/12/2016 we call update rather than
        fillSlots();
        System.out.println("ATTEMPTING AN Equipment change from equipment VIEW");
    }

//    private int currentIndex;
    private int numSlots = 4;
    private ContentDisplayStructure eds;
    private Equipment equipment;

    private Slot helmetSlot = new ItemSlot(null);
    private Slot weaponSlot = new ItemSlot(null);
    private Slot chestSlot = new ItemSlot(null);
    private Slot greavesSlot = new ItemSlot(null);

    public Slot getHelmetSlot() {
        return helmetSlot;
    }
    public Slot getWeaponSlot() {
        return weaponSlot;
    }
    public Slot getChestSlot() {
        return chestSlot;
    }
    public Slot getGreavesSlot() {
        return greavesSlot;
    }

    public Equipment getEquipment() {
        return equipment;
    }
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
        getEquipment().registerObserver(this); // TODO: 4/12/2016 might need to delete this...but I think it's good spot
    }

    public ContentDisplayStructure getEds() {
        return eds;
    }
    public void setEds(ContentDisplayStructure eds) {
        this.eds = eds;
    }

    public EquipmentView(Equipment equipment) {
            setTitle("Equipment");
            initDefaultUI();
            setEquipment(equipment);
            setEds(new EquipmentDisplayStructure(2,3));
            fillSlots();
            this.setBackground(new Color(0f, 0f, 0f, 0f));
            this.setBorder(new LineBorder(Color.WHITE));
            //this.add(getContentDisplayStructure(), BorderLayout.CENTER);
        }

    public void fillSlots() {
        /** Connascence issue...these have to be set in this order for the equipment to be set correctly **/
        eds.resetSlots();
        eds.addSlot(new ItemSlot(new ItemViewObject(getEquipment().getHelm())));
        eds.addSlot(new ItemSlot(new ItemViewObject(getEquipment().getWeapon())));
        eds.addSlot(new ItemSlot(new ItemViewObject(getEquipment().getArmor())));
        eds.addSlot(new ItemSlot(new ItemViewObject(getEquipment().getGreaves())));

    }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.WHITE);
            g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
            g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
            int initialX = 0;
            int initialY = 0;
            eds.paintComponent(g,initialX,initialY,getWidth(),getHeight());


//            getHelmetSlot().paintComponent(g,eds.getHelmetX(),eds.getHelmetY(),eds.getSlotWidth(),eds.getslotHeight());
//            getWeaponSlot().paintComponent(g,eds.getWeaponX(), eds.getWeaponY(), eds.getSlotWidth(), eds.getslotHeight());
//            getChestSlot().paintComponent(g,eds.getChestX(),eds.getChestY(),eds.getSlotWidth(),eds.getslotHeight());
//            //getShieldSlot().paintComponent(g,eds.getHelmetX(),eds.getHelmetY(),eds.getSlotWidth(),eds.getslotHeight());
//            getGreavesSlot().paintComponent(g,eds.getLegsX(),eds.getLegsY(),eds.getSlotWidth(),eds.getslotHeight());

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
        if (nextIndex<eds.getNumSlots()) {
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
        if (nextIndex<eds.getNumSlots()) {
            setCurrentIndex(nextIndex);
        }
    }

    /**
     * desc: Return the currently selected item
     */
    public Object useSelectedItem() {
        //System.out.println(eds.getEquippedItemViewObjects().get(currentIndex).getObject());
        return eds.getSlotList().get(getCurrentIndex()).getStaticViewObject().getObject();
    }



    }



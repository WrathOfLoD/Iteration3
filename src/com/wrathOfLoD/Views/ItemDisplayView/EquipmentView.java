package com.wrathOfLoD.Views.ItemDisplayView;

import com.wrathOfLoD.Models.Inventory.Equipment;
import com.wrathOfLoD.Models.Items.EquippableItems.EquippableItem;
import com.wrathOfLoD.Observers.EquipmentObserver;
import com.wrathOfLoD.Observers.Observable;
import com.wrathOfLoD.Observers.Observer;
import com.wrathOfLoD.Views.ContentDisplayStructure.EquipmentDisplayStructure;
import com.wrathOfLoD.Views.ItemDisplayView.Slot.EquipmentSlot;
import com.wrathOfLoD.Views.ViewObjectFactory.EquippedIVOFactory;
import com.wrathOfLoD.Views.ViewObjects.ItemViewObject;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by echristiansen on 4/9/2016.
 */

public class EquipmentView extends ItemDisplayView implements EquipmentObserver { // TODO: 4/12/2016 might need more specific observer, or to move the implementation to ItemDisplayView


    @Override
    public void alertEquipmentChange() {
        //updateEquipment(equipment); // TODO: 4/12/2016 we call update rather than
        fillSlots();
        System.out.println("ATTEMPTING AN Equipment change from equipment VIEW");

    }

    private Equipment equipment;
    private EquipmentSlot helmetSlot = new EquipmentSlot(null);
    private EquipmentSlot weaponSlot = new EquipmentSlot(null);
    private EquipmentSlot chestSlot = new EquipmentSlot(null);
    private EquipmentSlot shieldSlot = new EquipmentSlot(null);
    private EquipmentSlot greavesSlot = new EquipmentSlot(null);
    private EquipmentDisplayStructure eds;

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
        getEquipment().addObserver(this); // TODO: 4/12/2016 might need to delete this...but I think it's good spot
    }

        public EquipmentView() { // TODO: 4/12/2016 delete this constructor it's for testing purposes? 
            setEquipment(new Equipment()); // TODO: 4/12/2016 delete this it's for testing purposes?
            //getEquipment().addObserver(this);
            this.setBackground(new Color(0f, 0f, 0f, 0f));
            this.setBorder(new LineBorder(Color.WHITE));
        }
    
        public EquipmentView(Equipment equipment) {
            setEquipment(equipment);
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
        System.out.println("Hlmet is this: " + getEquipment().getHelm().getName());
        getHelmetSlot().addToSlot(EquippedIVOFactory.generateEquippedIVO(getEquipment().getHelm()));
        getWeaponSlot().addToSlot(EquippedIVOFactory.generateEquippedIVO(getEquipment().getWeapon()));
        getChestSlot().addToSlot(EquippedIVOFactory.generateEquippedIVO(getEquipment().getArmor()));
        getGreavesSlot().addToSlot(EquippedIVOFactory.generateEquippedIVO(getEquipment().getGreaves()));
    }


        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            eds = new EquipmentDisplayStructure(this.getWidth(), this.getHeight());
            //getEquipment().addObserver(this);

           // int width = this.getWidth();
           // int height = this.getHeight();
            g.setColor(Color.WHITE);
            g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
            g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
            g.drawRect(eds.getHelmetX(), eds.getHelmetY(), eds.getSlotWidth(), eds.getslotHeight());
            g.drawRect(eds.getWeaponX(), eds.getWeaponY(), eds.getSlotWidth(), eds.getslotHeight());
            g.drawRect(eds.getChestX(), eds.getChestY(), eds.getSlotWidth(), eds.getslotHeight());
            g.drawRect(eds.getShieldX(), eds.getShieldY(), eds.getSlotWidth(), eds.getslotHeight());
            g.drawRect(eds.getLegsX(), eds.getLegsY(), eds.getSlotWidth(), eds.getslotHeight());

            getHelmetSlot().paintComponent(g,eds.getHelmetX(),eds.getHelmetY(),eds.getSlotWidth(),eds.getslotHeight());
            getWeaponSlot().paintComponent(g,eds.getWeaponX(), eds.getWeaponY(), eds.getSlotWidth(), eds.getslotHeight());
            getChestSlot().paintComponent(g,eds.getChestX(),eds.getChestY(),eds.getSlotWidth(),eds.getslotHeight());
            //getShieldSlot().paintComponent(g,eds.getHelmetX(),eds.getHelmetY(),eds.getSlotWidth(),eds.getslotHeight());
            getGreavesSlot().paintComponent(g,eds.getLegsX(),eds.getLegsY(),eds.getSlotWidth(),eds.getslotHeight());

            System.out.println("Calling paintComponent: " + getHelmetSlot().getItem().getName());
            System.out.println("Testing testing 123");


            // TODO: 4/9/2016 Create a Slot class, where each Slot has an x and a y and then we call slot.paintComponent and the check for whether or not something is null happens in the slot



        }



    }



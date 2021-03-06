package com.wrathOfLoD.Views.ItemDisplayView;

import com.wrathOfLoD.Models.Inventory.Inventory;
import com.wrathOfLoD.Models.Items.TakeableItem;
import com.wrathOfLoD.Views.ContentDisplayStructure.ContentDisplayStructure;
import com.wrathOfLoD.Views.ItemDisplayView.Slot.ItemSlot;
import com.wrathOfLoD.Views.ItemDisplayView.Slot.Slot;
import com.wrathOfLoD.Views.ViewObjects.ItemViewObject;

import java.awt.*;
import java.util.Iterator;

/**
 * Created by echristiansen on 4/8/2016.
 */
public class InventoryView extends ItemDisplayView /*implements Selectable*/ { // TODO: 4/12/2016 segregate the inventory into a content area and description area

    private Inventory inventory;

    /**
     * Getters and Setters
     **/
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
        getInventory().registerObserver(this);
//        initializeInventoryView(); /* edit: good idea to have this here? Like it this way because it sets everything right when we set the inventory, no matter when we do that.
//        so that the inventoryView is always populated when an inventory is added, no matter constructor is used */
        fillInventoryView();
    }


    @Override
    public void update() {

        fillInventoryView();
        System.out.println("ADDING TO THE INVENTORY!!");
    }


    public InventoryView(Inventory inventory, ContentDisplayStructure contentDisplayStructure) {
        setContentDisplayStructure(contentDisplayStructure);
        setInventory(inventory);
        //initializeInventoryView(); // TODO: 4/17/2016 this was in the
        setTitle("Inventory");
        initDefaultUI();
        this.setBackground(new Color(0f, 0f, 0f, 0f));
        add(getContentDisplayStructure(), BorderLayout.CENTER);

    }


    public void fillInventoryView() {
        ItemViewObject itemViewObject;
        Iterator<TakeableItem> itemIterator = this.getInventory().getItemList().iterator();
        getContentDisplayStructure().getSlotList().clear();
        while (itemIterator.hasNext()) {
            itemViewObject = new ItemViewObject(itemIterator.next());
            Slot slot = new ItemSlot(itemViewObject);
            getContentDisplayStructure().addSlot(slot);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int structureWidth = this.getWidth();
        int structureHeight = this.getHeight() - getTitlePanel().getHeight();
        int initialX = 0;
        int initialY = this.getTitlePanel().getHeight();
        getContentDisplayStructure().paintComponent(g, initialX, initialY, structureWidth, structureHeight); //calls cds paint, which calls slot paint, which paints the item
    }
}




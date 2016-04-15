package com.wrathOfLoD.Views.ItemDisplayView;

import com.wrathOfLoD.Models.Inventory.Inventory;
import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Models.Items.TakeableItem;
import com.wrathOfLoD.Views.ContentDisplayStructure.ContentDisplayStructure;
import com.wrathOfLoD.Views.ContentDisplayStructure.GridStructure;
import com.wrathOfLoD.Views.ViewObjectFactory.InventoryIVOFactory;
import com.wrathOfLoD.Views.ViewObjects.InventoryItemViewObject;
import com.wrathOfLoD.Views.ViewObjects.ItemViewObject;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Iterator;

/**
 * Created by echristiansen on 4/8/2016.
 */
public class InventoryView extends ItemDisplayView { // TODO: 4/12/2016 segregate the inventory into a content area and description area  

    /* Need to enforce the invariant that the numRows and numCols do not exceed the max Inventory size? */
    private int currentIndex;
    private Inventory inventory;
    private ContentDisplayStructure cds;

    public ContentDisplayStructure getContentDisplayStructure() {
        return cds;
    }
    public void setContentDisplayStructure(ContentDisplayStructure cds) {
        this.cds = cds;
    }
    public Inventory getInventory() {
        return inventory;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
        getInventory().registerObserver(this);
        initializeInventoryView(); /* edit: good idea to have this here? Like it this way because it sets everything right when we set the inventory, no matter when we do that.
        so that the inventoryView is always populated when an inventory is added, no matter constructor is used */
    }


    @Override
    public void update() {

    }

    public InventoryView(Inventory inventory, ContentDisplayStructure cds) {
        currentIndex = 0;
        setContentDisplayStructure(cds);
        setInventory(inventory);
        this.setBackground(new Color(0f, 0f, 0f, 0f));
    }

    private void initializeInventoryView() { //may need to edit...only works if we maintain the idea that an inventory view must be initialized with an inventory
        InventoryItemViewObject itemViewObject;
        Iterator<TakeableItem> itemIterator = this.getInventory().getItemList().iterator();

        if (itemIterator.hasNext()) {
            itemViewObject = InventoryIVOFactory.generateInventoryIVO(itemIterator.next());
            itemViewObject.setIsSelected(true);
            this.addItemViewObject(itemViewObject);
        }

        while (itemIterator.hasNext()) {
            itemViewObject = InventoryIVOFactory.generateInventoryIVO(itemIterator.next());
            this.addItemViewObject(itemViewObject);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int index = 0;
        int x;
        int y;
        int slotWidth = cds.calculateSlotWidth(this.getWidth());
        int slotHeight = cds.calculateSlotHeight(this.getHeight());

        if (getIvoList().size() > 0) {
            InventoryItemViewObject inventoryItemViewObject;

            for (int i = 0; i < getIvoList().size(); i++) {
                inventoryItemViewObject = (InventoryItemViewObject) this.getIvoList().get(i);
                inventoryItemViewObject.setIsSelected(false);

                x = cds.calculateXCoord(this.getWidth(), index);
                y = cds.calculateYCoord(this.getHeight(), index);


                // Check if this is the selected item
                if (i == this.getCurrentIndex())
                    inventoryItemViewObject.setIsSelected(true);

                inventoryItemViewObject.paintComponent(g, x, y, slotWidth, slotHeight);
                index++;
            }
        }
    }

    public int getCurrentIndex() {
        return this.currentIndex;
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
        int prevRow = cds.determineRow(this.currentIndex++);
        int currRow = cds.determineRow(this.currentIndex);

        if (prevRow != currRow || this.currentIndex == this.getIvoList().size()) {
            this.currentIndex--;
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
        int currRow = cds.determineRow(this.currentIndex--);
        int prevRow = cds.determineRow(this.currentIndex);

        if (prevRow != currRow || this.currentIndex < 0) {
            this.currentIndex++;
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
        int prevIndex = this.currentIndex;
        this.currentIndex -= this.cds.getNumCols();
        if (this.currentIndex < 0)
            this.currentIndex = prevIndex;
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
        int prevIndex = this.currentIndex;
        this.currentIndex += this.cds.getNumCols();

        if (this.currentIndex >= this.getIvoList().size())
            this.currentIndex = prevIndex;
    }

    /**
     * desc: Return the currently selected item
     */
    public Item useSelectedItem() {
        System.out.println(this.getItemViewObject(currentIndex).getItem().getName());
        return this.getItemViewObject(currentIndex).getItem();
    }
}



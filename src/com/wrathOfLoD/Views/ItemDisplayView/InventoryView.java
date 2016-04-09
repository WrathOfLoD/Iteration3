package com.wrathOfLoD.Views.ItemDisplayView;

import com.wrathOfLoD.Models.Inventory.Inventory;
import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Models.Items.TakeableItem;
import com.wrathOfLoD.Views.ContentDisplayStructure.ContentDisplayStructure;
import com.wrathOfLoD.Views.ContentDisplayStructure.GridStructure;
import com.wrathOfLoD.Views.ViewObjectFactory.ItemViewObjectFactory;
import com.wrathOfLoD.Views.ViewObjects.ItemViewObject;

import java.awt.*;

/**
 * Created by echristiansen on 4/8/2016.
 */
public class InventoryView extends ItemDisplayView {

    /* Need to enforce the invariant that the numRows and numCols do not exceed the max Inventory size? */

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
        initializeInventoryView(); /* edit: good idea to have this here? Like it this way because it sets everything right when we set the inventory, no matter when we do that.
        so that the inventoryView is always populated when an inventory is added, no matter constructor is used */
    }

    public InventoryView() { //delete this...just for testing purposes
        //setBackgroundImageFileName("resources/spaceSlothTrade.png");
        this.setBackground(new Color(0f, 0f, 0f, 0f));

    }

    public InventoryView(Inventory inventory, ContentDisplayStructure cds) {
        setContentDisplayStructure(cds);
        setInventory(inventory);
        //initializeInventoryView(); //edit: don't need this anymore, moved to setInventory?
    }

    public InventoryView(ContentDisplayStructure cds) { //maybe delete?
        setContentDisplayStructure(cds);
    }

    private void initializeInventoryView() { //may need to edit...only works if we maintain the idea that an inventory view must be initialized with an inventory
        for(TakeableItem item: getInventory().getItemList()) {
            //getIvoList().add(ItemViewObjectFactory.createItemViewObject(item));
            getIvoList().add(new ItemViewObject(item)); //don't know which is best
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int index = 0;
        int x;
        int y;
        int width = this.getWidth();
        int height = this.getHeight();
        /* //Commenting this out for now....remove the comments when ivoList is set
        for(int i =0; i<getIvoList().size(); i++) {
            //x = GridStructure.calculateXCoord(width, index, numCols); //if the structure has static methods
            //y = GridStructure.calculateYCoord(height, index, numRows, numCols); //if the structure has static methods
            //x = cds.calculateXCoord(width, index, numCols);
            //y = cds.calculateYCoord(height,index,numRows,numCols);
            x = cds.calculateXCoord(width, index);
            y = cds.calculateYCoord(height,index);
            getIvoList().get(i).paintComponent(g, x, y, width, height);
            index++;
       */
        }
    }



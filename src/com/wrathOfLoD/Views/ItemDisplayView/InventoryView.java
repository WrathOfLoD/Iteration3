package com.wrathOfLoD.Views.ItemDisplayView;

import com.wrathOfLoD.Models.Inventory.Inventory;
import com.wrathOfLoD.Models.Items.TakeableItem;
import com.wrathOfLoD.Views.ContentDisplayStructure.ContentDisplayStructure;
import com.wrathOfLoD.Views.ContentDisplayStructure.GridStructure;
import com.wrathOfLoD.Views.ViewObjectFactory.InventoryIVOFactory;
import com.wrathOfLoD.Views.ViewObjects.InventoryItemViewObject;

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

    public InventoryView(Inventory inventory, ContentDisplayStructure cds) {
        setContentDisplayStructure(cds);
        setInventory(inventory);
        this.setBackground(new Color(0f, 0f, 0f, 0f));
    }

    private void initializeInventoryView() { //may need to edit...only works if we maintain the idea that an inventory view must be initialized with an inventory
        for (TakeableItem item : getInventory().getItemList()) { //edit: just access inventory directly?
            addItemViewObject(InventoryIVOFactory.generateInventoryIVO(item));
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
            for (int i = 0; i < getIvoList().size(); i++) {
                x = cds.calculateXCoord(this.getWidth(), index);
                y = cds.calculateYCoord(this.getHeight(), index);
                getIvoList().get(i).paintComponent(g, x, y, slotWidth, slotHeight);
                System.out.println("Attempting to paint " + getIvoList().get(i).getItem().getName());
                index++;
            }
        }
    }


}



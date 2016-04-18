package com.wrathOfLoD.Views.ContentDisplayStructure;

import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Views.ItemDisplayView.Slot.InventorySlot;
import com.wrathOfLoD.Views.Selectable;

import java.util.ArrayList;

/**
 * Created by echristiansen on 4/17/2016.
 */
public class InventoryGridStructure extends GridStructure  {

    private int currentIndex;
    private ArrayList<InventorySlot> inventorySlots = new ArrayList<>();

    public ArrayList<InventorySlot> getInventorySlots() {
        return inventorySlots;
    }
    public void setInventorySlots(ArrayList<InventorySlot> inventorySlots) {
        this.inventorySlots = inventorySlots;
    }

    public InventoryGridStructure(int numRows, int numCols) {
        super(numRows, numCols);
    }


}

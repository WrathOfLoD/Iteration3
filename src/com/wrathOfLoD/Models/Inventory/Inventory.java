package com.wrathOfLoD.Models.Inventory;

import com.wrathOfLoD.Models.Items.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zach on 4/7/16.
 */
public class Inventory {
    private List<Item> itemList;

    public Inventory() {
        this.itemList = new ArrayList();
    }

    public void addItem(Item item) {}

    public void removeItem(Item item) {}
}

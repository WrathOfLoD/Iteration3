package com.wrathOfLoD.Models.Inventory;


import com.wrathOfLoD.Models.Items.TakeableItem;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zach on 4/7/16.
 */
public class Inventory {
    private List<TakeableItem> itemList;

    public Inventory() {
        this.itemList = new ArrayList();
    }

    public void addItem(TakeableItem item) {
        itemList.add(item);
    }

    public void removeItem(TakeableItem item) {
        itemList.remove(item);
    }

    public List getItemList(){
        return this.itemList;
    }

}

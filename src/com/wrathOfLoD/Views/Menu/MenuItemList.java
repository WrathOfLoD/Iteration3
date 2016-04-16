package com.wrathOfLoD.Views.Menu;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by echristiansen on 4/16/2016.
 */
public class MenuItemList {

    private List<MenuItem> itemList;

    private int currentIndex = 0;

    public MenuItemList(){
        itemList = new LinkedList<>();
    }

    public void addItem(MenuItem item){
        itemList.add(item);
    }

    public void removeItem(MenuItem item){
        itemList.remove(item);
    }

    public void addItemAtIndex(MenuItem item, int index){
        itemList.add(index, item);
    }

    public void removeItemAtIndex(int index){
        itemList.remove(index);
    }

    public Iterator<MenuItem> getIterator(){
        return itemList.iterator();
    }

    public int getCurrentIndex(){
        return this.currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        if (currentIndex < 0) return;
        if (currentIndex >= itemList.size()) return;
        this.currentIndex = currentIndex;
    }

    public MenuItem getCurrentMenuItem(){
        return itemList.get(currentIndex);
    }


}

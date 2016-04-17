package com.wrathOfLoD.Views.ItemDisplayView;

import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Observers.Observer;
import com.wrathOfLoD.Views.ContentDisplayStructure.ContentDisplayStructure;
import com.wrathOfLoD.Views.ContentDisplayStructure.GridStructure;
import com.wrathOfLoD.Views.ItemDisplayView.Slot.InventorySlot;
import com.wrathOfLoD.Views.Selectable;
import com.wrathOfLoD.Views.StaticView;
import com.wrathOfLoD.Views.View;
import com.wrathOfLoD.Views.ViewObjects.ItemViewObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by erik on 4/7/2016.
 */
public class ItemDisplayView extends StaticView implements Observer, Selectable {

    private int currentIndex;

    @Override
    public void update() {

    }

    public ItemDisplayView(ContentDisplayStructure contentDisplayStructure) {
        super(contentDisplayStructure);
    }

    public ItemDisplayView() {
        setContentDisplayStructure(new GridStructure(8,4));
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
        int prevRow = getContentDisplayStructure().determineRow(this.currentIndex++);
        int currRow = getContentDisplayStructure().determineRow(this.currentIndex);

        //if (prevRow != currRow || this.currentIndex == this.getSvoList().size()) {
//        if (prevRow != currRow || this.currentIndex == this.getInventorySlots().size()) {
        if (prevRow != currRow || this.currentIndex == this.getContentDisplayStructure().getSlotList().size()) {
            //getContentDisplayStructure().getSlotList().get(currentIndex).setSelected(false);
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
        int currRow = getContentDisplayStructure().determineRow(this.currentIndex--);
        int prevRow = getContentDisplayStructure().determineRow(this.currentIndex);

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
        this.currentIndex -= getContentDisplayStructure().getNumCols();
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
        this.currentIndex += getContentDisplayStructure().getNumCols();

        //if (this.currentIndex >= this.getIvoList().size())
        if (this.currentIndex >= getContentDisplayStructure().getSlotList().size())
            this.currentIndex = prevIndex;
    }

    /**
     * desc: Return the currently selected item
     */
    public Object useSelectedItem() {
        System.out.println(getContentDisplayStructure().getSlotList().get(currentIndex).getStaticViewObject().getObject());
        return getContentDisplayStructure().getSlotList().get(currentIndex).getStaticViewObject().getObject();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        getContentDisplayStructure().getSlotList().stream().forEach(x -> x.setSelected(false));
        getContentDisplayStructure().getSlotList().get(currentIndex).setSelected(true);
    }


}

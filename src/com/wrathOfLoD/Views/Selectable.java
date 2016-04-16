package com.wrathOfLoD.Views;

/**
 * Created by zach on 4/16/16.
 */
public interface Selectable {

    /**
     * desc: Paint view with next item in row selected
     */
    public void selectNextItem();

    /**
     * desc: Increment to next index in row, makes sure not to wrap around
     */
    public void safeIncrementRight();

    /**
     * desc: Paint view with previous item in row selected
     */
    public void selectPrevItem();

    /**
     * desc: Decrement to previous index in row, makes sure not to wrap around
     */
    public void safeDecrementLeft();

    /**
     * desc: Paint view with prev item in col selected
     */
    public void selectUpItem();

    /**
     * desc: Decrement to previous column, makes sure not to wrap around
     */
    public void safeDecrementUp();

    /**
     * desc: Paint view with next item in col selected
     */
    public void selectDownItem();

    /**
     * desc: Increment to next column, makes sure not to wrap around
     */
    public void safeIncrementDown();

    /**
     * desc: Return the currently selected item
     */
    public Object useSelectedItem();
}

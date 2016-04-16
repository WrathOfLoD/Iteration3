package com.wrathOfLoD.Views;

/**
 * Created by zach on 4/16/16.
 */
public interface Selectable {

    public void selectNextItem();
    public void selectPrevItem();
    public void selectUpItem();
    public void selectDownItem();
    public Object useSelectedItem();
}

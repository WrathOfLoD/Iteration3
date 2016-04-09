package com.wrathOfLoD;

import com.wrathOfLoD.Views.AreaView.AreaView;
import com.wrathOfLoD.Views.AvatarIESView.AvatarIESView;
import com.wrathOfLoD.Views.ItemDisplayView.InventoryView;
import com.wrathOfLoD.Views.ViewEngine;

import java.awt.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        AreaView areaView = new AreaView();
        ViewEngine viewEngine = ViewEngine.getInstance();
        viewEngine.registerView(areaView);

        InventoryView inventoryView = new InventoryView();

        Thread.sleep(2000);
        viewEngine.registerView(inventoryView);

        Thread.sleep(3000);
        viewEngine.registerView(areaView);

    }
}

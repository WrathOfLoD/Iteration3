package com.wrathOfLoD;

import com.wrathOfLoD.Models.ModelEngine;
import com.wrathOfLoD.Views.AreaView.AreaView;
import com.wrathOfLoD.Views.AvatarIESView.AvatarIESView;
import com.wrathOfLoD.Views.EquipmentView.EquipmentView;
import com.wrathOfLoD.Views.ItemDisplayView.InventoryView;
import com.wrathOfLoD.Views.StatsView.StatsView;
import com.wrathOfLoD.Views.ViewEngine;
import com.wrathOfLoD.Views.ViewManager.ViewManager;

import java.awt.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        AreaView areaView = new AreaView();
        ViewEngine viewEngine = ViewEngine.getInstance();
        viewEngine.registerView(areaView);

        StatsView statsView = new StatsView();
        EquipmentView equipmentView = new EquipmentView();
        InventoryView inventoryView = new InventoryView();
        AvatarIESView avatarIESView = new AvatarIESView(inventoryView, statsView, equipmentView);
        ViewManager vm = new ViewManager(areaView, avatarIESView);

        viewEngine.registerView(vm);

        Thread.sleep(2000);
        //viewEngine.registerView(inventoryView);
        //viewEngine.registerView(avatarIESView);
        vm.addView(avatarIESView);

        Thread.sleep(3000);
        vm.removeView(avatarIESView);


        ModelEngine.getInstance().start();

    }
}

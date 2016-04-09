package com.wrathOfLoD;

import com.wrathOfLoD.Models.Inventory.Inventory;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.TwoHandWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.Weapon;
import com.wrathOfLoD.Views.AreaView.AreaView;
import com.wrathOfLoD.Views.AvatarIESView.AvatarIESView;
import com.wrathOfLoD.Views.ContentDisplayStructure.GridStructure;
import com.wrathOfLoD.Views.EquipmentView.EquipmentView;
import com.wrathOfLoD.Views.ItemDisplayView.InventoryView;
import com.wrathOfLoD.Views.StatsView.StatsView;
import com.wrathOfLoD.Views.ViewEngine;
import com.wrathOfLoD.Views.ViewManager.ViewManager;

import java.awt.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Inventory inventory = new Inventory();
        //inventory.addItem();

        TwoHandWeapon hammer = new TwoHandWeapon("hammer");
        TwoHandWeapon hammer2 = new TwoHandWeapon("hammer");
        inventory.addItem(hammer);
        inventory.addItem(hammer2);


        AreaView areaView = new AreaView();
        ViewEngine viewEngine = ViewEngine.getInstance();
        viewEngine.registerView(areaView);

        //InventoryView inventoryView = new InventoryView();
        InventoryView inventoryView = new InventoryView(inventory, new GridStructure(new Dimension(6,4)));

        StatsView statsView = new StatsView();
        EquipmentView equipmentView = new EquipmentView();
        AvatarIESView avatarIESView = new AvatarIESView(inventoryView, statsView, equipmentView);
        ViewManager vm = new ViewManager(areaView, avatarIESView);

        viewEngine.registerView(vm);

        Thread.sleep(2000);
        //viewEngine.registerView(inventoryView);
        //viewEngine.registerView(avatarIESView);
        vm.addView(avatarIESView);

        Thread.sleep(3000);
        vm.removeView(avatarIESView);

    }
}

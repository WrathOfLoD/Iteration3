package com.wrathOfLoD;

import com.wrathOfLoD.Controllers.InputStates.InventoryState;
import com.wrathOfLoD.Models.Inventory.Equipment;
import com.wrathOfLoD.Models.Inventory.Inventory;
import com.wrathOfLoD.Models.Items.EquippableItems.Helm;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.FistWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.TwoHandWeapon;



import com.wrathOfLoD.Models.ModelEngine;
import com.wrathOfLoD.Controllers.InputStates.ActionVendor;
import com.wrathOfLoD.Controllers.InputStates.AvatarState;
import com.wrathOfLoD.Controllers.InputStates.InputState;
import com.wrathOfLoD.Controllers.MainController;
import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Occupation.Smasher;
import com.wrathOfLoD.Models.Stats.Stats;
import com.wrathOfLoD.Models.Stats.StatsModifiable;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.AreaView.AreaView;
import com.wrathOfLoD.Views.AvatarIESView.AvatarIESView;
import com.wrathOfLoD.Views.ContentDisplayStructure.GridStructure;
import com.wrathOfLoD.Views.ContentDisplayStructure.ListStructure;
import com.wrathOfLoD.Views.ItemDisplayView.EquipmentView;
import com.wrathOfLoD.Views.ItemDisplayView.InventoryView;
import com.wrathOfLoD.Views.Selectable;
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
        Helm helm = new Helm("helm");

        Equipment equipment = new Equipment(new FistWeapon("default fist", StatsModifiable.createWeaponBonusStatsModifiable(1),1,1));
        equipment.equip(helm);
        equipment.equip(hammer);

        inventory.addItem(hammer);
        inventory.addItem(hammer2);

        for (int i = 0; i < 10; i++) {
            inventory.addItem(new TwoHandWeapon("hammer"));
        }


        AreaView areaView = new AreaView();
        ViewEngine viewEngine = ViewEngine.getInstance();
        viewEngine.registerView(areaView);

        //InventoryView inventoryView = new InventoryView();
        InventoryView inventoryView = new InventoryView(inventory, new GridStructure(6,4));

        ListStructure listStructure = new ListStructure(7,2, 15, 0);
        Avatar avatar = Avatar.getInstance();
        Stats stats = new Stats(avatar);

        StatsView statsView = new StatsView(stats,listStructure);
        //EquipmentView equipmentView = new EquipmentView();
        EquipmentView equipmentView = new EquipmentView(equipment);
        AvatarIESView avatarIESView = new AvatarIESView(inventoryView, statsView, equipmentView);
        ViewManager vm = new ViewManager(areaView, avatarIESView);

        viewEngine.registerView(vm);

        Thread.sleep(2000);
        //viewEngine.registerView(inventoryView);
        //viewEngine.registerView(avatarIESView);
        vm.addView(avatarIESView);

        ModelEngine.getInstance().start();


        //Avatar avatar = Avatar.getInstance();

        avatar.configureAvatar("Dave", new Position(0,0,0,0), new Smasher());

        MainController mainController = MainController.getInstance();

        InputState avatarState = new AvatarState();



        inventory.addToActionSet(ActionVendor.createSelectUpAction(inventoryView));
        inventory.addToActionSet(ActionVendor.createSelectRightAction(inventoryView));
        inventory.addToActionSet(ActionVendor.createSelectLeftAction(inventoryView));
        inventory.addToActionSet(ActionVendor.createSelectDownAction(inventoryView));
        inventory.addToActionSet(ActionVendor.createSelectItemAction(inventoryView));

        InputState inventoryState = new InventoryState(inventory);
        mainController.setActiveState(avatarState);
        mainController.setActiveState(inventoryState);

        //LocationTrackerManager.getInstance().registerEntity(avatar, avatar.getTargetManager());


        Thread.sleep(2000);
        System.out.println("Setting active state");
//        mainController.setActiveState(avatarState);
//        Thread.sleep(3000);
//        vm.removeView(avatarIESView);
//
        Thread.sleep(1000);
        Helm helm2 = new Helm("helm2");
        equipment.equip(helm2);

    }
}

package com.wrathOfLoD;

import com.wrathOfLoD.Models.Inventory.Inventory;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.TwoHandWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.Weapon;

import com.wrathOfLoD.Models.LocationTracker.LocationTrackerManager;
import com.wrathOfLoD.Models.ModelEngine;
import com.wrathOfLoD.Controllers.InputStates.ActionVendor;
import com.wrathOfLoD.Controllers.InputStates.AvatarState;
import com.wrathOfLoD.Controllers.InputStates.InputState;
import com.wrathOfLoD.Controllers.MainController;
import com.wrathOfLoD.Models.Commands.ActionCommandVendor;
import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Occupation.Smasher;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;
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

        ModelEngine.getInstance().start();


        Avatar avatar = Avatar.getInstance();
        avatar.configureAvatar("Dave", new Position(0,0,0,0), new Smasher());

        MainController mainController = MainController.getInstance();

        InputState avatarState = new AvatarState();


        //LocationTrackerManager.getInstance().registerEntity(avatar, avatar.getTargetManager());


        avatar.addToActionSet(ActionVendor.createMoveNorthAction());


        Thread.sleep(2000);
        System.out.println("Setting active state");
        mainController.setActiveState(avatarState);
//        Thread.sleep(3000);
//        vm.removeView(avatarIESView);
//

    }
}

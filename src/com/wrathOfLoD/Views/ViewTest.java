package com.wrathOfLoD.Views;

import com.wrathOfLoD.Controllers.InputStates.ActionVendor;
import com.wrathOfLoD.Controllers.InputStates.EquipmentState;
import com.wrathOfLoD.Controllers.InputStates.InputState;
import com.wrathOfLoD.Controllers.InputStates.InventoryState;
import com.wrathOfLoD.Controllers.MainController;
import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Inventory.Equipment;
import com.wrathOfLoD.Models.Inventory.Inventory;
import com.wrathOfLoD.Models.Items.EquippableItems.Helm;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.FistWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.TwoHandWeapon;
import com.wrathOfLoD.Models.Items.TakeableItem;
import com.wrathOfLoD.Models.ModelEngine;
import com.wrathOfLoD.Models.Stats.Stats;
import com.wrathOfLoD.Models.Stats.StatsModifiable;
import com.wrathOfLoD.Views.AbilityView.AbilityView;
import com.wrathOfLoD.Views.AreaView.AreaView;
import com.wrathOfLoD.Views.AvatarIESView.AvatarIESView;
import com.wrathOfLoD.Views.CameraView.CameraViewManager;
import com.wrathOfLoD.Views.ContentDisplayStructure.GridStructure;
import com.wrathOfLoD.Views.ContentDisplayStructure.ListStructure;
import com.wrathOfLoD.Views.ItemDisplayView.EquipmentView;
import com.wrathOfLoD.Views.ItemDisplayView.InventoryView;
import com.wrathOfLoD.Views.AbilityView.AbilityView;
import com.wrathOfLoD.Views.StatsView.StatsView;
import com.wrathOfLoD.Views.ViewManager.ViewManager;

import javax.swing.*;
import java.io.IOException;
import java.io.InterruptedIOException;

/**
 * Created by echristiansen on 4/17/2016.
 */
public class ViewTest {

    public static void main(String[] args) throws InterruptedException{


        Inventory inventory = new Inventory();
        //inventory.addItem();

        TwoHandWeapon hammer = new TwoHandWeapon("hammer");
        Helm helm = new Helm("helm");

        Equipment equipment = new Equipment(new FistWeapon("default fist", StatsModifiable.createWeaponBonusStatsModifiable(1),1,1));
        equipment.equip(helm);
        equipment.equip(hammer);


        for (int i = 0; i < 10; i++) {
            inventory.addItem(new TwoHandWeapon("hammer"));
        }

        ViewEngine viewEngine = ViewEngine.getInstance();

        InventoryView inventoryView = new InventoryView(inventory, new GridStructure(6,4));


        inventory.addToActionSet(ActionVendor.createSelectUpAction(inventoryView));
        inventory.addToActionSet(ActionVendor.createSelectRightAction(inventoryView));
        inventory.addToActionSet(ActionVendor.createSelectLeftAction(inventoryView));
        inventory.addToActionSet(ActionVendor.createSelectDownAction(inventoryView));
        inventory.addToActionSet(ActionVendor.createSelectItemAction(inventoryView));

        InputState inventoryState = new InventoryState(inventory);
        InputState equipmentState = new EquipmentState(equipment);

        MainController mainController = MainController.getInstance();
//
//        InputState avatarState = new AvatarState();

        mainController.setActiveState(inventoryState);

        ListStructure listStructure = new ListStructure(7,2, 15, 0);
        Avatar avatar = Avatar.getInstance();
        Stats stats = new Stats(avatar);
//
        StatsView statsView = new StatsView(stats,listStructure);
        //EquipmentView equipmentView = new EquipmentView();
        EquipmentView equipmentView = new EquipmentView(equipment);
        AvatarIESView avatarIESView = new AvatarIESView(inventoryView, statsView, equipmentView);
        //ViewManager vm = new ViewManager(areaView, avatarIESView);
        CameraViewManager cvm = new CameraViewManager();
        AreaView areaView = new AreaView(cvm);
        ViewManager vm = new ViewManager(areaView, avatarIESView);
        vm.addView(areaView);
        vm.addView(avatarIESView);

        AbilityView abilityView= new AbilityView(avatar.getAbilityManager(), new GridStructure(6,4));
        //vm.addView(abilityView);

        viewEngine.registerView(vm);

        ModelEngine.getInstance().start();


        Thread.sleep(2000);
        Helm helm2 = new Helm("helm");
        Helm helm3 = new Helm("helm2");
        inventory.addItem(helm2);
        equipment.equip(helm2);
        mainController.setActiveState(equipmentState);
        //viewEngine.registerView(inventoryView);
        //viewEngine.registerView(avatarIESView);
        //vm.addView(avatarIESView);
        //vm.addView(areaView);
        //mainController.setActiveState(equipmentState);
//

    }



}

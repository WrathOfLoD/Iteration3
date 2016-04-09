package com.wrathOfLoD;

import com.wrathOfLoD.Controllers.InputStates.ActionVendor;
import com.wrathOfLoD.Controllers.InputStates.AvatarState;
import com.wrathOfLoD.Controllers.InputStates.InputState;
import com.wrathOfLoD.Controllers.MainController;
import com.wrathOfLoD.Models.Commands.ActionCommandVendor;
import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Utility.Direction;
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



        MainController mainController = MainController.getInstance();

        InputState avatarState = new AvatarState();
        Avatar.getInstance().addToActionSet(ActionVendor.createMoveNorthAction());

        Thread.sleep(2000);
        System.out.println("Setting active state");
        mainController.setActiveState(avatarState);
//        Thread.sleep(3000);
//        vm.removeView(avatarIESView);
//
    }
}

package com.wrathOfLoD.GameLaunching;

import com.wrathOfLoD.Controllers.InputStates.ActionVendor;
import com.wrathOfLoD.Controllers.InputStates.AvatarState;
import com.wrathOfLoD.Controllers.InputStates.InputState;
import com.wrathOfLoD.Controllers.InputStates.InventoryState;
import com.wrathOfLoD.Controllers.MainController;
import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Inventory.Inventory;
import com.wrathOfLoD.Models.ModelEngine;
import com.wrathOfLoD.Models.Occupation.Smasher;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.AvatarIESView.AvatarIESView;
import com.wrathOfLoD.Views.ContentDisplayStructure.GridStructure;
import com.wrathOfLoD.Views.ContentDisplayStructure.ListStructure;
import com.wrathOfLoD.Views.ItemDisplayView.EquipmentView;
import com.wrathOfLoD.Views.ItemDisplayView.InventoryView;
import com.wrathOfLoD.Views.StatsView.StatsView;
import com.wrathOfLoD.Views.ViewEngine;
import com.wrathOfLoD.Views.ViewFactories.ViewObjectFactory.ViewObjectFactory;
import com.wrathOfLoD.Views.ViewManager.ViewManager;
import sun.security.x509.AVA;

/**
 * Created by luluding on 4/15/16.
 */
public class GameLauncher {
    private GameLaunchHelper gameLaunchHelper;

    public GameLauncher(GameLaunchHelper gameLaunchHelper){
        this.gameLaunchHelper = gameLaunchHelper;
    }


    public void launchGame() throws InterruptedException {
        gameLaunchHelper.createMap();
        gameLaunchHelper.populateMap();
        ViewObjectFactory.getInstance().initVOFactory(gameLaunchHelper.getAreaView());
        ViewEngine viewEngine = ViewEngine.getInstance();
        viewEngine.registerView(gameLaunchHelper.getAreaView());
        ListStructure listStructure = new ListStructure(7,2, 15, 0);
        StatsView statsView = new StatsView(Avatar.getInstance().getStats(),listStructure);
        Inventory inventory = Avatar.getInstance().getInventory();
        InventoryView inventoryView = new InventoryView(inventory, new GridStructure(6,4));
        EquipmentView equipmentView = new EquipmentView(Avatar.getInstance().getEquipment());
        AvatarIESView avatarIESView = new AvatarIESView(inventoryView, statsView, equipmentView);
        ViewManager vm = new ViewManager(gameLaunchHelper.getAreaView(), avatarIESView);
        viewEngine.registerView(vm);
        vm.addView(gameLaunchHelper.getAreaView());
        ModelEngine.getInstance().start();
        MainController mainController = MainController.getInstance();

        InputState avatarState = new AvatarState();



        inventory.addToActionSet(ActionVendor.createSelectUpAction(inventoryView));
        inventory.addToActionSet(ActionVendor.createSelectRightAction(inventoryView));
        inventory.addToActionSet(ActionVendor.createSelectLeftAction(inventoryView));
        inventory.addToActionSet(ActionVendor.createSelectDownAction(inventoryView));
        inventory.addToActionSet(ActionVendor.createSelectItemAction(inventoryView));

        InputState inventoryState = new InventoryState(inventory);
        mainController.setActiveState(avatarState);

        Thread.sleep(2000);
        System.out.println("Setting active state");

    }
}

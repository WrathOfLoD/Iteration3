package com.wrathOfLoD.GameLaunching;

import com.wrathOfLoD.Controllers.InputStates.ActionVendor;
import com.wrathOfLoD.Controllers.InputStates.AvatarState;
import com.wrathOfLoD.Controllers.InputStates.InputState;
import com.wrathOfLoD.Controllers.InputStates.InventoryState;
import com.wrathOfLoD.Controllers.MainController;
import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Occupation.Smasher;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.ViewEngine;
import com.wrathOfLoD.Views.ViewManager.ViewManager;

/**
 * Created by luluding on 4/15/16.
 */
public class GameLauncher {
    private GameLaunchHelper gameLaunchHelper;

    public GameLauncher(GameLaunchHelper gameLaunchHelper){
        this.gameLaunchHelper = gameLaunchHelper;
    }


    public void launchGame(){
        gameLaunchHelper.createMap();
        gameLaunchHelper.populateMap();


        ViewEngine viewEngine = ViewEngine.getInstance();
        //viewEngine.registerView(areaView);
        //TODO, let view engine have areaview manager


        //ViewManager vm = new ViewManager(areaView, avatarIESView);

        //viewEngine.registerView(vm);

        Avatar avatar = Avatar.getInstance();
        avatar.configureAvatar("Dave", new Position(0,0,0,0), new Smasher());


        MainController mainController = MainController.getInstance();

        InputState avatarState = new AvatarState();

        /*
        inventory.addToActionSet(ActionVendor.createSelectUpAction(inventoryView));
        inventory.addToActionSet(ActionVendor.createSelectRightAction(inventoryView));
        inventory.addToActionSet(ActionVendor.createSelectLeftAction(inventoryView));
        inventory.addToActionSet(ActionVendor.createSelectDownAction(inventoryView));
        inventory.addToActionSet(ActionVendor.createSelectItemAction(inventoryView));*/

        //InputState inventoryState = new InventoryState(inventory);
        //mainController.setActiveState(avatarState);
        //mainController.setActiveState(inventoryState);

    }
}

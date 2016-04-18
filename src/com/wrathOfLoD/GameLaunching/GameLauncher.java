package com.wrathOfLoD.GameLaunching;

import com.wrathOfLoD.Controllers.InputStates.Action.Action;
import com.wrathOfLoD.Controllers.InputStates.ActionVendor;
import com.wrathOfLoD.Controllers.InputStates.AvatarState;
import com.wrathOfLoD.Controllers.InputStates.InputState;
import com.wrathOfLoD.Controllers.InputStates.InventoryState;
import com.wrathOfLoD.Controllers.MainController;
import com.wrathOfLoD.GameLaunching.Vendors.EntityVendor;
import com.wrathOfLoD.Models.Ability.Abilities.BlastAbilities.FanBlastAbility;
import com.wrathOfLoD.Models.Ability.Abilities.BlastAbilities.FireballAbility;
import com.wrathOfLoD.Models.Ability.Abilities.BoonAbilites.BoonBoostDefenseAbility;
import com.wrathOfLoD.Models.Ability.Abilities.EnchantmentAbilites.EnchantmentMakeWeakAbility;
import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Entity.Mount;
import com.wrathOfLoD.Models.Inventory.Equipment;
import com.wrathOfLoD.Models.Inventory.Inventory;
import com.wrathOfLoD.Models.Items.ConsumableItems.TemporaryConsumable;
import com.wrathOfLoD.Models.Items.EquippableItems.Helm;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.FistWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.TwoHandWeapon;
import com.wrathOfLoD.Models.Items.TakeableItem;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.ModelEngine;
import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Models.Occupation.Smasher;
import com.wrathOfLoD.Models.Stats.StatsModifiable;
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

import java.io.IOException;

/**
 * Created by luluding on 4/15/16.
 */
public class GameLauncher {
    private GameLaunchHelper gameLaunchHelper;

    public GameLauncher(GameLaunchHelper gameLaunchHelper){
        this.gameLaunchHelper = gameLaunchHelper;
    }

    public void launchGame(Occupation occupation) throws InterruptedException, IOException{

        gameLaunchHelper.createMap();
        gameLaunchHelper.populateMap();

        EntityVendor.createNewPlayer("Slothman", occupation, Map.getInstance().getMapAreas()[0].getSpawnPoint(), Map.getInstance().getMapAreas()[0]);


        gameLaunchHelper.setActiveCameraView(Map.getInstance().getActiveMapArea());

        ViewObjectFactory.getInstance().initVOFactory(gameLaunchHelper.getAreaView());
        ViewObjectFactory.getInstance().createAvatarViewObject(Map.getInstance().getActiveMapArea().getSpawnPoint(), Avatar.getInstance());

        Map.getInstance().registerObserver(gameLaunchHelper.getAreaView());

        ViewEngine viewEngine = ViewEngine.getInstance();
        viewEngine.registerView(gameLaunchHelper.getAreaView());
        ListStructure listStructure = new ListStructure(7,2, 15, 0);
        StatsView statsView = new StatsView(Avatar.getInstance().getStats(),listStructure);
        Inventory inventory = Avatar.getInstance().getInventory();
        InventoryView inventoryView = new InventoryView(inventory, new GridStructure(5,5));
        EquipmentView equipmentView = new EquipmentView(Avatar.getInstance().getEquipment());
        AvatarIESView avatarIESView = new AvatarIESView(inventoryView, statsView, equipmentView);
        ViewManager vm = ViewManager.getInstance();
        vm.init(gameLaunchHelper.getAreaView(), avatarIESView);
        viewEngine.registerView(vm);
        vm.addView(gameLaunchHelper.getAreaView());
        ModelEngine.getInstance().start();

        MainController mainController = MainController.getInstance();

        InputState avatarState = new AvatarState();


        // TODO: 4/17/16 Do same for Equipment
        inventory.addToActionSet(ActionVendor.createSelectUpAction(inventoryView));
        inventory.addToActionSet(ActionVendor.createSelectRightAction(inventoryView));
        inventory.addToActionSet(ActionVendor.createSelectLeftAction(inventoryView));
        inventory.addToActionSet(ActionVendor.createSelectDownAction(inventoryView));
        inventory.addToActionSet(ActionVendor.createSelectItemAction(inventoryView));

        Avatar.getInstance().getEquipment().addToActionSet(ActionVendor.createSelectUpAction(equipmentView));
        Avatar.getInstance().getEquipment().addToActionSet(ActionVendor.createSelectRightAction(equipmentView));
        Avatar.getInstance().getEquipment().addToActionSet(ActionVendor.createSelectLeftAction(equipmentView));
        Avatar.getInstance().getEquipment().addToActionSet(ActionVendor.createSelectDownAction(equipmentView));
        Avatar.getInstance().getEquipment().addToActionSet(ActionVendor.createSelectItemAction(equipmentView));

        TakeableItem helmet = new Helm("helm");
        inventory.addItem(helmet);
        Avatar.getInstance().use(helmet);

        inventory.addItem(new TwoHandWeapon("Dragon 2H"));
        inventory.addItem(new Helm("helm2"));


        for (int i = 0; i < 2; i++) {
            //inventory.addItem(new TwoHandWeapon("hammer"));
            inventory.addItem(new TemporaryConsumable("Blue Potion", StatsModifiable.createHealthStatsModifiable(10), 5));
            inventory.addItem(new TwoHandWeapon("Mystical 2H"));
            inventory.addItem(new TemporaryConsumable("Red Potion", StatsModifiable.createHealthStatsModifiable(10),5));

        }

        inventory.addItem(new Helm("helm"));

        InputState inventoryState = new InventoryState(inventory);
        mainController.setActiveState(avatarState);

        //        mainController.setActiveState(inventoryState);

        Thread.sleep(2000);
        System.out.println("Setting active state");

    }
}

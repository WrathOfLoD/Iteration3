package com.wrathOfLoD;

import com.wrathOfLoD.Controllers.InputStates.InventoryState;
import com.wrathOfLoD.GameLaunching.GameLauncher;
import com.wrathOfLoD.GameLaunching.NewGameHelper;
import com.wrathOfLoD.GameLaunching.Vendors.ItemVendor;
import com.wrathOfLoD.Models.Inventory.Equipment;
import com.wrathOfLoD.Models.Inventory.Inventory;
import com.wrathOfLoD.Models.Items.EquippableItems.Helm;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.FistWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.TwoHandWeapon;


import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.MapArea;
import com.wrathOfLoD.Models.Map.Terrain.Ground;
import com.wrathOfLoD.Models.Map.Terrain.NullTerrain;
import com.wrathOfLoD.Models.Map.Terrain.Sky;
import com.wrathOfLoD.Models.Map.Tile;
import com.wrathOfLoD.Models.Map.TilePillar;
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
import com.wrathOfLoD.Views.CameraView.CameraView;
import com.wrathOfLoD.Views.CameraView.CameraViewManager;
import com.wrathOfLoD.Views.ContentDisplayStructure.GridStructure;
import com.wrathOfLoD.Views.ContentDisplayStructure.ListStructure;
import com.wrathOfLoD.Views.ItemDisplayView.EquipmentView;
import com.wrathOfLoD.Views.ItemDisplayView.InventoryView;
import com.wrathOfLoD.Views.Selectable;
import com.wrathOfLoD.Views.StatsView.StatsView;
import com.wrathOfLoD.Views.ViewEngine;
import com.wrathOfLoD.Views.ViewManager.ViewManager;
import com.wrathOfLoD.Views.ViewFactories.ViewObjectFactory.*;

import java.awt.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        GameLauncher gameLauncher = new GameLauncher(new NewGameHelper());
        gameLauncher.launchGame();

    }
}

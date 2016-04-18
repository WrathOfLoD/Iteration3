package com.wrathOfLoD.Views.Menu;

import com.wrathOfLoD.GameLaunching.GameLauncher;
import com.wrathOfLoD.GameLaunching.NewGameHelper;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Views.ViewEngine;

import java.io.IOException;

/**
 * Created by echristiansen on 4/18/2016.
 */
public class CharacterCreationMenuItem extends MenuItem {

    public CharacterCreationMenuItem(String text) {
        super(text);
    }

    @Override
    public void execute() throws IOException, InterruptedException {
        //MainController.getInstance().set
        //ViewEngine viewEngine =
        System.out.println("asdgfsdgdsgsdsad");
        GameLauncher gameLauncher = new GameLauncher(new NewGameHelper());
        gameLauncher.launchGame();
    }


}

package com.wrathOfLoD.Views.Menu;

import com.wrathOfLoD.Controllers.InputStates.InputState;
import com.wrathOfLoD.Controllers.InputStates.MenuState;
import com.wrathOfLoD.Controllers.MainController;
import com.wrathOfLoD.Views.ViewEngine;

import java.io.IOException;

/**
 * Created by echristiansen on 4/18/2016.
 */
public class NewGameMenuItem extends MenuItem {

    public NewGameMenuItem(String text) {
        super(text);
    }

    @Override
    public void execute() throws IOException, InterruptedException{
        //MainController.getInstance().set
        //ViewEngine viewEngine =
        CharacterCreationMenu characterCreationMenu = new CharacterCreationMenu();
        InputState menuState = new MenuState(characterCreationMenu);
        MainController.getInstance().setActiveState(menuState);
        ViewEngine.getInstance().registerView(characterCreationMenu);

    }
}

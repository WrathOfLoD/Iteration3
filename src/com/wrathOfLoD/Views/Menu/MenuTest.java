package com.wrathOfLoD.Views.Menu;

import com.wrathOfLoD.Controllers.InputStates.*;
import com.wrathOfLoD.Controllers.MainController;
import com.wrathOfLoD.Views.SpriteMap.SpriteMap;

import com.wrathOfLoD.Views.SpriteMap.ImageAnimation;
import com.wrathOfLoD.Views.SpriteMap.SpriteMap;
import com.wrathOfLoD.Models.ModelEngine;
import com.wrathOfLoD.Views.ViewEngine;


/**
 * Created by echristiansen on 4/14/2016.
 */
public class MenuTest {


        public static void main(String[] args) {

            MainMenu mainMenu = new MainMenu();
           // SpriteMap sm = new SpriteMap();
           // sm.generateEntityMap();

            PauseMenu pauseMenu = new PauseMenu();
            CharacterCreationMenu characterCreationMenu = new CharacterCreationMenu();
            ModelEngine.getInstance().start();

            MainController mainController = MainController.getInstance();

            InputState avatarState = new AvatarState();

            //InputState menuState = new MenuState(characterCreationMenu);
            InputState menuState = new MenuState(mainMenu);
            mainController.setActiveState(menuState);


            ViewEngine window = ViewEngine.getInstance();
            window.registerView(mainMenu);
//            window.registerView(pauseMenu);
            //window.registerView(characterCreationMenu);
//

            //ScrollableMenu menu = new MainScrollableMenu(120);
            //menu.setPreferredSize(new Dimension(80, 600));
            //window.registerView(menu);
           // MainController mainController = MainController.getInstance();
           // mainController.setMainMenuControllerState(menu);
            //window.start();

/*
            SpriteMap sm = new SpriteMap();
            sm.generateItemMap();
            HashMap<String, ImageAnimation> lol = sm.getItemMap();
            for(String s : lol.keySet()){
                System.out.println(s);
            }

            */
        }
    }


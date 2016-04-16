package com.wrathOfLoD.Views.Menu;

import com.wrathOfLoD.Controllers.InputStates.*;
import com.wrathOfLoD.Controllers.MainController;
import com.wrathOfLoD.Views.SpriteMap.ImageAnimation;
import com.wrathOfLoD.Views.SpriteMap.SpriteMap;
import com.wrathOfLoD.Models.ModelEngine;
import com.wrathOfLoD.Views.ViewEngine;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * Created by echristiansen on 4/14/2016.
 */
public class MenuTest {


        public static void main(String[] args) throws Exception{
            MainMenu mainMenu = new MainMenu();
            ModelEngine.getInstance().start();

            MainController mainController = MainController.getInstance();

            InputState avatarState = new AvatarState();


            System.out.println(mainMenu.getActionSet());

            InputState menuState = new MenuState(mainMenu);
            mainController.setActiveState(menuState);

            /*
            JFrame testFrame = new JFrame();
            mainMenu.setPreferredSize(new Dimension(800,900));
            testFrame.setContentPane(mainMenu);
            testFrame.setLocationRelativeTo(null);
            testFrame.setResizable(false);
            testFrame.pack();
            testFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            testFrame.setVisible(true);
*/

            ViewEngine window = ViewEngine.getInstance();
            window.registerView(mainMenu);



            //ScrollableMenu menu = new MainScrollableMenu(120);
            //menu.setPreferredSize(new Dimension(80, 600));
            //window.registerView(menu);
           // MainController mainController = MainController.getInstance();
           // mainController.setMainMenuControllerState(menu);
            //window.start();


            SpriteMap sm = new SpriteMap();
            sm.generateItemMap();
            HashMap<String, ImageAnimation> lol = sm.getItemMap();
            for(String s : lol.keySet()){
                System.out.println(s);
            }
        }
    }


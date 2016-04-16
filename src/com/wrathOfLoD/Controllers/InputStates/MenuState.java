package com.wrathOfLoD.Controllers.InputStates;

import com.wrathOfLoD.Views.Menu.Menu;

/**
 * Created by zach on 4/16/16.
 */
public class MenuState extends InputState {
    private Menu menu;

    public MenuState(Menu menu) {
        this.menu = menu;

        this.setActiveActionSet(menu.getActionSet());
    }
}

package com.wrathOfLoD.Models.Commands.MenuActionCommands;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Views.Menu.Menu;

/**
 * Created by zach on 4/16/16.
 */
public abstract class MenuSelectCommand extends ActionCommand {
    private Menu menu;

    public MenuSelectCommand(Menu menu) {
        this.menu = menu;
    }

    public Menu getMenu() {
        return this.menu;
    }
}

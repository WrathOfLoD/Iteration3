package com.wrathOfLoD.Models.Commands.MenuActionCommands;

import com.wrathOfLoD.Views.Menu.Menu;

/**
 * Created by zach on 4/16/16.
 */
public class MenuSelectDownCommand extends MenuSelectCommand {

    public MenuSelectDownCommand(Menu menu) {
        super(menu);
    }

    @Override
    public void execute() {
        this.getMenu().selectNextItem();
    }
}

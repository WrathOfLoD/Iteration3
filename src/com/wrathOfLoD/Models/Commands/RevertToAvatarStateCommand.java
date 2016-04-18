package com.wrathOfLoD.Models.Commands;

import com.wrathOfLoD.Controllers.InputStates.AvatarState;
import com.wrathOfLoD.Controllers.MainController;
import com.wrathOfLoD.Views.ViewManager.ViewManager;

/**
 * Created by zach on 4/18/16.
 */
public class RevertToAvatarStateCommand extends ActionCommand {

    @Override
    public void execute() {
        MainController.getInstance().setActiveState(new AvatarState());
        ViewManager.getInstance().addView(ViewManager.getInstance().getAreaView());
    }
}
package com.wrathOfLoD.Views.AreaView;

import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Views.StaticView;
import com.wrathOfLoD.Views.View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by echristiansen on 4/8/2016.
 */
public class AreaView extends StaticView { //need to change to just extending View, perhaps

    public static final int WIDTH = Config.instance().getAreaViewWidth();
    public static final int HEIGHT = Config.instance().getAreaViewHeight();

    public AreaView() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        //setBackgroundImageFileName("resources/spaceSlothDefault.png");
        setBackgroundImageFileName("resources/Backgrounds/spaceSloth.png");

    }
}

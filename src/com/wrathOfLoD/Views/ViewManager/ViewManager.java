package com.wrathOfLoD.Views.ViewManager;

import com.wrathOfLoD.Views.AreaView.AreaView;
import com.wrathOfLoD.Views.AvatarIESView.AvatarIESView;
import com.wrathOfLoD.Views.StaticView;


import javax.swing.*;
import java.awt.*;

/**
 * Created by echristiansen on 4/8/2016.
 */
public class ViewManager extends StaticView { //edit: extend View or extend StaticView?

    //TODO: how to swap b\w area view in viewManager when game starts?

    private AreaView av;
    private AvatarIESView avatarIESView;

    public AreaView getAreaView() {
        return av;
    }

    public void setAreaView(AreaView av) {
        this.av = av;
    }

    public AvatarIESView getAvatarIESView() {
        return avatarIESView;
    }

    public void setAvatarIESView(AvatarIESView avatarIESView) {
        this.avatarIESView = avatarIESView;
    }


    public ViewManager(AreaView av, AvatarIESView ies) {
        setLayout(new BorderLayout());
        setAreaView(av);
        setAvatarIESView(ies);
        this.add(getAreaView(), BorderLayout.CENTER);
    }

    public void addView(JComponent component) {
        this.add(component,0);
        this.revalidate();
        this.repaint();
    }

    public void removeView(JComponent component) {
        this.remove(component);
        this.revalidate();
        this.repaint();
    }

}

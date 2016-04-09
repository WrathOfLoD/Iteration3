package com.wrathOfLoD.Views;

import com.wrathOfLoD.Utility.Config;

import javax.swing.*;
import java.awt.*;

/**
 * Created by echristiansen on 4/8/2016.
 */
public class ViewEngine extends JFrame {

    private static ViewEngine instance = new ViewEngine();
    public static ViewEngine getInstance(){return instance;}

    private ViewEngine(){}

    private JComponent target;

    private void initialize() {
        add(target);
        setTitle("Wrath of LoD");
        setResizable(false);
        pack();
        this.setPreferredSize(new Dimension(Config.instance().getWindowWidth(), Config.instance().getWindowHeight())); //edit
        this.setSize(Config.instance().getWindowWidth(), Config.instance().getWindowHeight()); //edit
        this.pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    public void registerView(JComponent view){
        if(target != null) {
            removeOldView();
        }
        target = view;
        initialize();
    }

    public void registerView(View view){
        if(target != null) {
            removeOldView();
        }
        target = view;
        initialize();
    }

    public void removeOldView(){
        if (target != null)
            remove(target);
    }



}

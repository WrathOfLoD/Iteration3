package com.wrathOfLoD;

import com.wrathOfLoD.Views.AreaView.AreaView;
import com.wrathOfLoD.Views.ViewEngine;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Test Test");

        AreaView areaView = new AreaView();
        ViewEngine ve = ViewEngine.getInstance();
        ve.registerView(areaView);

    }
}

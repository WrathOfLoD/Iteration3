package com.wrathOfLoD.Views.SpriteMap;

import java.io.IOException;
import java.util.HashMap;


/**
 * Created by matthewdiaz on 4/16/16.
 */
public class SpriteTestOutPut {
    public static void main(String args[]) throws IOException {
        SpriteMap sm = new SpriteMap();
        sm.generateItemMap();
        HashMap<String, ImageAnimation> h = sm.getItemMap();
        for(String str: h.keySet()){
            System.out.println(h.get(str));
            System.out.println(str);
            System.out.println("");
        }
    }
}

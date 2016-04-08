package com.wrathOfLoD.Views.ContentDisplayStructure;

import javax.swing.*;

/**
 * Created by erik on 4/7/2016.
 */
public abstract class ContentDisplayStructure extends JPanel {


    /* Could probably have this abstract class then have the subclasses implement the methods
        but no need to make static. Will just have an instance in whatever class uses?
        Probably not necessary.
        Which is better: have classes that use a contentstructure have a reference to the structure and instantiate with
        their width and so forth? Or have Static methods that can be used when passed in the appropriate parameters?
     */

}
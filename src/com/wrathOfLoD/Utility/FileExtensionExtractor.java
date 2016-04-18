package com.wrathOfLoD.Utility;

/**
 * Created by zach on 4/17/16.
 */
public class FileExtensionExtractor {

    public static String getFileExtension(String fileName) {
        String ext = "";

        int i = fileName.lastIndexOf('.');
        if (i >= 0)
            ext = fileName.substring(i+1);
        return ext;
    }
}

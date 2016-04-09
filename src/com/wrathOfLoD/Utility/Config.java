package com.wrathOfLoD.Utility;

/**
 * Created by echristiansen on 4/8/2016.
 */
public class Config {

    private static final int WINDOW_WIDTH = 1300; //set the overall window width. Was 1400
    private static final int WINDOW_HEIGHT = 900; //was 900

    private static final int AREA_VIEW_WIDTH = WINDOW_WIDTH; //set the overall window width
    private static final int AREA_VIEW_HEIGHT = WINDOW_HEIGHT;

    private static final double HUD_VIEW_WIDTH_PROPORTION = 0.35;
    private static final double HUD_VIEW_HEIGHT_PROPORTION = .13;
    private static final double AVATARIES_VIEW_WIDTH_PROPORTION = 0.80;
    private static final double AVATARIES_VIEW_HEIGHT_PROPORTION = 0.70;

    private static final int HUD_VIEW_WIDTH = (int) (HUD_VIEW_WIDTH_PROPORTION * AREA_VIEW_WIDTH);
    private static final int HUD_VIEW_HEIGHT = (int) (HUD_VIEW_HEIGHT_PROPORTION * AREA_VIEW_HEIGHT);
    private static final int AVATARIES_VIEW_WIDTH = (int) (AVATARIES_VIEW_WIDTH_PROPORTION * WINDOW_WIDTH);
    private static final int AVATARIES_VIEW_HEIGHT = (int) (AVATARIES_VIEW_HEIGHT_PROPORTION * WINDOW_HEIGHT);


    public static int getWindowWidth() {
        return WINDOW_WIDTH;
    }
    public static int getWindowHeight() {
        return WINDOW_HEIGHT;
    }

    public static int getAreaViewWidth() {
        return AREA_VIEW_WIDTH;
    }
    public static int getAreaViewHeight() {
        return AREA_VIEW_HEIGHT;
    }

    public static int getHudViewWidth() {
        return HUD_VIEW_WIDTH;
    }
    public static int getHudViewHeight() {
        return HUD_VIEW_HEIGHT;
    }

    public static int getAvatarIESViewWidth() {
        return AVATARIES_VIEW_WIDTH;
    }
    public static int getAvatarIESViewHeight() { return AVATARIES_VIEW_HEIGHT; }

    private static Config instance = null;
    private Config() {

    }

    public static Config instance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }
}

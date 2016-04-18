package com.wrathOfLoD.Utility;

/**
 * Created by echristiansen on 4/8/2016.
 */
public class Config {

    private static final String IVOPath = "resources/Items/";
    private static final String EntityVOPath = "resources/Entity/";
    private static final String MapIVOPath = "resources/MapItems/";
    private static final String InventoryIVOPath = "resources/InventoryItems/";
    private static final String EquippedIVOPath = "resources/EquippedItems/";
    private static final String AbilityVOPath = "resources/Abilities/";
    private static final String ImageExtension = ".png";

    public static String getAbilityVOPath() {
        return AbilityVOPath;
    }
    public static String getIVOPath() {
        return IVOPath;
    }
    public static String getEntityVOPath() {
        return EntityVOPath;
    }
    public static String getMapIVOPath() {
        return MapIVOPath;
    }
    public static String getInventoryIVOPath() {
        return InventoryIVOPath;
    }
    public static String getEquippedIVOPath() {
        return EquippedIVOPath;
    }
    public static String getImageExtension() {
        return ImageExtension;
    }

    private static final int EntityZLevel = 50;
    private static final int TerrainZLevel = 10;
    private static final int TakeableItemZLevel = 20;
    private static final int OneShotItemZLevel = 15;
    private static final int ObstacleZLevel = 15;
    private static final int InteractiveItemZLevel = 15;
    private static final int AreaEffectZLevel = 25;
    private static final int HitBoxZLevel = 55;

    public static int getHitBoxZLevel() {
        return HitBoxZLevel;
    }

    public static int getEntityZLevel(){
        return EntityZLevel;
    }

    public static int getTerrainZLevel(){
        return TerrainZLevel;
    }

    public static int getTakeableItemZLevel(){
        return TakeableItemZLevel;
    }

    public static int getOneShotItemZLevel() {
        return OneShotItemZLevel;
    }

    public static int getObstacleZLevel() {
        return ObstacleZLevel;
    }

    public static int getInteractiveItemZLevel() {
        return InteractiveItemZLevel;
    }

    public static int getAreaEffectZLevel(){
        return AreaEffectZLevel;
    }


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

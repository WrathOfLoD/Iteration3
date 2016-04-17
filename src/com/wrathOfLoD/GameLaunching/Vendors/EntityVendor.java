package com.wrathOfLoD.GameLaunching.Vendors;

import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.LocationTracker.LocationTrackerManager;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.MapArea;
import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Models.Occupation.Smasher;
import com.wrathOfLoD.Models.Occupation.Sneak;
import com.wrathOfLoD.Models.Occupation.Summoner;
import com.wrathOfLoD.Models.Stats.Stats;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by luluding on 4/15/16.
 */
public class EntityVendor {

    public static Avatar createNewSmasherPlayer(String name, Position startingPosition, MapArea mapArea){
        Avatar avatar = Avatar.getInstance();
        Stats stats = new Stats(avatar);
        avatar.configureAvatar(name, startingPosition, new Smasher());
        mapArea.addEntity(avatar, startingPosition);
        Map.getInstance().setActiveMapArea(mapArea);
        LocationTrackerManager.getInstance().registerEntity(avatar,mapArea);
        return avatar;
    }
    public static Avatar createNewSummonerPlayer(String name, Position startingPosition, MapArea mapArea){
        Avatar avatar = Avatar.getInstance();
        Stats stats = new Stats(avatar);
        avatar.configureAvatar(name, startingPosition, new Summoner());
        mapArea.addEntity(avatar, startingPosition);
        Map.getInstance().setActiveMapArea(mapArea);
        LocationTrackerManager.getInstance().registerEntity(avatar,mapArea);
        return avatar;
    }
    public static Avatar createNewSneakPlayer(String name, Position startingPosition, MapArea mapArea){
        Avatar avatar = Avatar.getInstance();
        Stats stats = new Stats(avatar);
        avatar.configureAvatar(name, startingPosition, new Sneak());
        mapArea.addEntity(avatar, startingPosition);
        Map.getInstance().setActiveMapArea(mapArea);
        LocationTrackerManager.getInstance().registerEntity(avatar,mapArea);
        return avatar;
    }

}

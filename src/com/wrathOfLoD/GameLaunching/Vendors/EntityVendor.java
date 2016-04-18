package com.wrathOfLoD.GameLaunching.Vendors;

import com.wrathOfLoD.Controllers.NPCControllers.FlyingNPCController;
import com.wrathOfLoD.Controllers.NPCControllers.NPCController;
import com.wrathOfLoD.Controllers.NPCControllers.NotFlyingNPCController;
import com.wrathOfLoD.Controllers.NPCControllers.PetController;
import com.wrathOfLoD.GameClock.TimeModel;
import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Entity.Character.NPC;
import com.wrathOfLoD.Models.Entity.Character.Pet;
import com.wrathOfLoD.Models.Entity.EntityCanMoveVisitor.FlyingCanMoveVisitor;
import com.wrathOfLoD.Models.Entity.EntityCanMoveVisitor.TerrestrialCanMoveVisitor;
import com.wrathOfLoD.Models.LocationTracker.LocationTrackerManager;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.MapArea;
import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Models.Occupation.Smasher;
import com.wrathOfLoD.Models.Occupation.Sneak;
import com.wrathOfLoD.Models.Occupation.Summoner;
import com.wrathOfLoD.Models.Skill.SmasherSkillManager;
import com.wrathOfLoD.Models.Skill.SneakSkillManager;
import com.wrathOfLoD.Models.Skill.SummonerSkillManager;
import com.wrathOfLoD.Models.Stats.Stats;
import com.wrathOfLoD.Utility.Position;


/**
 * Created by luluding on 4/15/16.
 */
public class EntityVendor {

    public static Avatar createNewPlayer(String name, Occupation occupation, Position startingPosition, MapArea mapArea){
        Avatar avatar = Avatar.getInstance();
        //Stats stats = new Stats(avatar);
        avatar.configureAvatar(name, startingPosition, occupation, occupation.createSkillManager());
        avatar.populateAbilities();
        mapArea.addEntity(avatar, startingPosition);
        Map.getInstance().setActiveMapArea(mapArea);
        LocationTrackerManager.getInstance().registerEntity(avatar,mapArea);
        return avatar;
    }

    public static Avatar createNewSmasherPlayer(String name, Position startingPosition, MapArea mapArea){
        Avatar avatar = Avatar.getInstance();
        Stats stats = new Stats(avatar);
        avatar.configureAvatar(name, startingPosition, new Smasher(), new SmasherSkillManager());
        avatar.populateAbilities();
        mapArea.addEntity(avatar, startingPosition);
        Map.getInstance().setActiveMapArea(mapArea);
        LocationTrackerManager.getInstance().registerEntity(avatar,mapArea);
        return avatar;
    }
    public static Avatar createNewSummonerPlayer(String name, Position startingPosition, MapArea mapArea){
        Avatar avatar = Avatar.getInstance();
        Stats stats = new Stats(avatar);
        avatar.configureAvatar(name, startingPosition, new Summoner(), new SummonerSkillManager());
        avatar.populateAbilities();
        mapArea.addEntity(avatar, startingPosition);
        Map.getInstance().setActiveMapArea(mapArea);
        LocationTrackerManager.getInstance().registerEntity(avatar,mapArea);
        return avatar;
    }
    public static Avatar createNewSneakPlayer(String name, Position startingPosition, MapArea mapArea){
        Avatar avatar = Avatar.getInstance();
        Stats stats = new Stats(avatar);
        avatar.configureAvatar(name, startingPosition, new Sneak(), new SneakSkillManager());
        avatar.populateAbilities();
        mapArea.addEntity(avatar, startingPosition);
        Map.getInstance().setActiveMapArea(mapArea);
        LocationTrackerManager.getInstance().registerEntity(avatar,mapArea);
        return avatar;
    }

    public static NPC createEnemy(Position startingPosition, MapArea mapArea){
        NPC enemy = new NPC("SlothHater", startingPosition, new Smasher(), 1, 1, new TerrestrialCanMoveVisitor());
        enemy.setAggroLevel(1);
        mapArea.addEntity(enemy, startingPosition);
        LocationTrackerManager.getInstance().registerEntity(enemy,mapArea);
        NPCController controller = new NotFlyingNPCController(enemy);
        TimeModel.getInstance().registerTickable(controller);
        return enemy;
    }

    public static Pet createPet(Position position, MapArea mapArea){
        Pet pet = new Pet("SlothHater", position, new Smasher(), new TerrestrialCanMoveVisitor());
        pet.setAggroLevel(0);
        mapArea.addEntity(pet, position);
        LocationTrackerManager.getInstance().registerEntity(pet, mapArea);
        NPCController controller = new PetController(pet);
        TimeModel.getInstance().registerTickable(controller);
        return pet;
    }

    public static NPC createFlyingEnemy(Position startingPosition, MapArea mapArea){
        NPC enemy = new NPC("FlyingSlothHater", startingPosition, new Smasher(), 1, 1, new FlyingCanMoveVisitor());
        enemy.setAggroLevel(1);
        mapArea.addEntity(enemy, startingPosition);
        LocationTrackerManager.getInstance().registerEntity(enemy,mapArea);
        NPCController controller = new FlyingNPCController(enemy);
        TimeModel.getInstance().registerTickable(controller);
        return enemy;
    }

}

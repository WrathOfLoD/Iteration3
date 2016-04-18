package com.wrathOfLoD.Views.Menu;

import com.wrathOfLoD.GameLaunching.GameLauncher;
import com.wrathOfLoD.GameLaunching.NewGameHelper;
import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Models.Occupation.Sneak;
import com.wrathOfLoD.Models.Occupation.Summoner;

import java.io.IOException;

/**
 * Created by echristiansen on 4/18/2016.
 */
public class SneakCreationMenuItem extends MenuItem{

    public SneakCreationMenuItem(String text) {
        super(text);
    }

    public void execute() throws IOException, InterruptedException {
        Occupation occupation = new Sneak();
        System.out.println("Creating game with a Sneak");
        GameLauncher gameLauncher = new GameLauncher(new NewGameHelper());
        gameLauncher.launchGame(occupation);
    }
}

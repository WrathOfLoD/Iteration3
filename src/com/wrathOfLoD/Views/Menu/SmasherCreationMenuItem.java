package com.wrathOfLoD.Views.Menu;

import com.wrathOfLoD.GameLaunching.GameLauncher;
import com.wrathOfLoD.GameLaunching.NewGameHelper;
import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Models.Occupation.Smasher;
import com.wrathOfLoD.Models.Occupation.Summoner;

import java.io.IOException;

/**
 * Created by echristiansen on 4/18/2016.
 */
public class SmasherCreationMenuItem extends MenuItem{


    public SmasherCreationMenuItem(String text) {
        super(text);
    }

    public void execute() throws IOException, InterruptedException {
        Occupation occupation = new Smasher();
        System.out.println("Creating game with a Smasher");
        GameLauncher gameLauncher = new GameLauncher(new NewGameHelper());
        gameLauncher.launchGame(occupation);
    }
}

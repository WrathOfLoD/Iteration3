package com.wrathOfLoD.Models.Commands.FogOfWarActionCommands;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.TilePillar;
import com.wrathOfLoD.Utility.Position;

import java.util.List;

/**
 * Created by Mitchell on 4/17/2016.
 */
public class DiscoverTilesCommand extends ActionCommand{

	private List<Position> positions;

	public DiscoverTilesCommand(List<Position> positions){
		this.positions = positions;
	}

	@Override
	public void execute(){
		for(Position pos: positions){
			TilePillar pillar = Map.getInstance().getTilePillar(pos);
			pillar.discover();
		}
	}
}

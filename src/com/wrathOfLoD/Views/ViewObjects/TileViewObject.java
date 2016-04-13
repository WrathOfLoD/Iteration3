package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.Tile;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.SpriteMap.ImageAnimation;

/**
 * Created by Mitchell on 4/12/2016.
 */
public class TileViewObject extends ViewObject{

	private Tile tile;
	private Position pos;

	public TileViewObject(Position pos, ImageAnimation animation){

		this.pos = pos;
		this.tile = Map.getInstance().getTile(pos);
	}


}

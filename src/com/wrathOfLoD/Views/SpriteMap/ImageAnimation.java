package com.wrathOfLoD.Views.SpriteMap;

import java.awt.*;
import java.io.File;
import java.util.List;

/**
 * Created by Mitchell on 4/12/2016.
 */
public abstract class ImageAnimation{

	protected int currentFrame = 0;

	public final Image getFrame(){
		nextFrame();
		return getFrame(currentFrame);
	}

	protected abstract Image getFrame(int currentFrame);

	protected abstract void nextFrame();

	public abstract boolean isFinished();

}

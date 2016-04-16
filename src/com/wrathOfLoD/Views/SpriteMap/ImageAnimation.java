package com.wrathOfLoD.Views.SpriteMap;

import java.awt.*;
import java.io.File;
import java.util.List;

/**
 * Created by Mitchell on 4/12/2016.
 */
public class ImageAnimation{

	private int currentFrame = 0;
	private List<Image> frames;

	public ImageAnimation(List<Image> frames){
		this.frames = frames;
	}

	public final Image getFrame(){
		nextFrame();
		return getFrame(currentFrame);
	}

	protected Image getFrame(int currentFrame){
		Image current = this.frames.get(currentFrame);
		nextFrame();
		return current;
	}

	private void nextFrame(){
		currentFrame++;
		currentFrame %= frames.size();
	}

	public boolean isFinished(){
		return (this.currentFrame == this.frames.size() - 1);
	}

}

package com.wrathOfLoD.Views.SpriteMap;

import java.util.*;
import java.awt.Image;


/**
 * Created by Mitchell on 4/12/2016.
 */
public class ConcreteAnimation extends ImageAnimation{

	private List<Image> frames;

	public ConcreteAnimation(List<Image> frames){
		this.frames = frames;
		this.currentFrame = 0;
	}

	@Override
	protected Image getFrame(int currentFrame){
		return frames.get(currentFrame);
	}

	@Override
	protected void nextFrame(){
		this.currentFrame = (this.currentFrame + 1) % frames.size();
	}

	@Override
	public boolean isFinished(){
		return (this.currentFrame == frames.size()-1);
	}
}

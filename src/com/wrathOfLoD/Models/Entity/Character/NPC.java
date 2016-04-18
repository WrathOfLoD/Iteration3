package com.wrathOfLoD.Models.Entity.Character;

import com.wrathOfLoD.Models.Entity.EntityCanMoveVisitor.CanMoveVisitor;
import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.VisitorInterfaces.EntityVisitor;

/**
 * Created by zach on 4/7/16.
 */
public class NPC extends Character {
    private int aggression;
    private int greed;
    private Position homePosition;

    public NPC(String name, Position pos, Occupation occupation, CanMoveVisitor canMoveVisitor){
        super(name, pos, occupation, canMoveVisitor);
        this.aggression = 0;
        this.greed = 0;
        this.homePosition = pos;
    }

    public NPC(String name, Position pos, Occupation occupation, int aggression, int greed, CanMoveVisitor canMoveVisitor){
        super(name, pos, occupation, canMoveVisitor);
        this.aggression = aggression;
        this.greed = greed;
        this.homePosition = pos;
    }

    /***** getter & setter for NPC *******/

    public int getAggression(){
        return this.aggression;
    }

    public int getGreed(){
        return this.greed;
    }

    public Position getHomePosition(){
        return this.homePosition;
    }

    public void setAggression(int newAggression){
        this.aggression = newAggression;
    }

    public void setGreed(int newGreed){
        this.aggression = newGreed;
    }

	/********* END Getters and Setters *********/

    public void accept(EntityVisitor ev){
        ev.visitNPC(this);
    }

	@Override
	public void hideTiles(){
		System.out.println("Silly NPC, you can't hide tiles");
	}

	@Override
	public void showTiles(){
		System.out.println("Silly NPC, you can't show tiles");
	}

}

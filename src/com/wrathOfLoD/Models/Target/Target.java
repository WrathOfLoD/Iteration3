package com.wrathOfLoD.Models.Target;

import com.wrathOfLoD.Utility.Position;

/**
 * Created by zach on 4/7 /16.
 */
public abstract class Target {
    private int priority;
    private Position position;
//    public void accept(TargetVisitor visitor)
    public void setPriority(int priority){
        this.priority = priority;
    }
    public int getPriority(){
        return priority;
    }
    public abstract Object getTarget();

    public Position getPosition(){
        return position;
    }

    protected void setPosition(Position pos){
        position = pos;
    }
}

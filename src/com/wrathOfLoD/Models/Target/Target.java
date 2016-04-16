package com.wrathOfLoD.Models.Target;

import com.wrathOfLoD.Utility.Position;

/**
 * Created by zach on 4/7 /16.
 */
public abstract class Target {
    private int priority;

//    public void accept(TargetVisitor visitor)
    protected void setPriority(int priority){
        this.priority = priority;
    }
    public int getPriority(){
        return priority;
    }
    public abstract Object getTarget();
}

package com.wrathOfLoD.Views.CameraView;

import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Observers.ViewObjectObservers.MovableVOObserver;
import com.wrathOfLoD.Observers.ViewObjectObservers.VOObserver;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.ViewObjects.ModelViewObject;
import javafx.geometry.Pos;

/**
 * Created by luluding on 4/17/16.
 */
public class CameraCenter implements VOObserver{

    private Position cameraCenter;
    private Position initialCenter;

    public CameraCenter(){
        this.cameraCenter = Avatar.getInstance().getPosition();
    }

    public void setCameraCenter(Position pos){
        this.cameraCenter = pos;
    }

    public Position getCameraCenter(){
        return cameraCenter;
    }

    @Override
    public void notifyDestroy(ModelViewObject vo, Position position) {
        setCameraCenter(initialCenter);
    }

    @Override
    public void notifyOnMove(ModelViewObject mvo, Position src, Position dest, Direction dir, int ticks) {
        setCameraCenter(dest);
    }

    public void setInitialCenter(Position position){
        this.initialCenter = position;
    }
}

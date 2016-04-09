package com.wrathOfLoD.Views.AvatarIESView;


import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Views.EquipmentView.EquipmentView;
import com.wrathOfLoD.Views.ItemDisplayView.InventoryView;
import com.wrathOfLoD.Views.StaticView;
import com.wrathOfLoD.Views.StatsView.StatsView;
import com.wrathOfLoD.Views.View;

/**
 * Created by echristiansen on 4/8/2016.
 */
public class AvatarIESView extends StaticView {

    private InventoryView iv;
    private StatsView sv;
    private EquipmentView ev;

    private static final int AVATARIES_VIEW_WIDTH =(int) Config.instance().getAvatarIESViewWidth();
    private static final int AVATARIES_VIEW_HEIGHT = (int) Config.instance().getAvatarIESViewHeight();

    public InventoryView getInventoryView() {
        return iv;
    }
    public void setInventoryView(InventoryView iv) {
        this.iv = iv;
    }
    public StatsView getStatsView() {
        return sv;
    }
    public void setStatsView(StatsView sv) {
        this.sv = sv;
    }
    public EquipmentView getEquipmentView() {
        return ev;
    }
    public void setEquipmentView(EquipmentView ev) {
        this.ev = ev;
    }

    public AvatarIESView(InventoryView iv, StatsView sv, EquipmentView ev) {
        setInventoryView(iv);
        setStatsView(sv);
        setEquipmentView(ev);
        setBackgroundImageFileName("resources/slothSpaceTrade.png");
    }


}

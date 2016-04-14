package com.wrathOfLoD.Views.StatsView;


import com.wrathOfLoD.Models.Stats.Stats;
import com.wrathOfLoD.Observers.Observer;
import com.wrathOfLoD.Views.ContentDisplayStructure.ContentDisplayStructure;
import com.wrathOfLoD.Views.ContentDisplayStructure.ListStructure;
import com.wrathOfLoD.Views.StaticView;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by echristiansen on 4/8/2016.
 */
public class StatsView extends StaticView implements Observer {
    private Stats stats;
    private ListStructure ls;
    private ContentDisplayStructure cds;
    private ArrayList<StatsViewObject> svoList = new ArrayList<StatsViewObject>();

    public Stats getStats() {
        return stats;
    }
    public void setStats(Stats stats) {
        this.stats = stats;
        getStats().registerObserver(this);
    }
    public ContentDisplayStructure getCds() {
        return cds;
    }
    public void setCds(ContentDisplayStructure cds) {
        this.cds = cds;
    }
    public ArrayList<StatsViewObject> getSVOList() {
        return svoList;
    }
    public void setSVOList(ArrayList<StatsViewObject> svoList) {
        this.svoList = svoList;
    }

    @Override
    public void update() {
        generateSVOList();
    }

    public StatsView() {
        this.setBackground(new Color(0f, 0f, 0f, 0f));
    }

    public StatsView(Stats stats, ContentDisplayStructure cds) {
        setStats(stats);
        setCds(cds);
        generateSVOList();
    }

    public void generateSVOList() {
        setSVOList(StatsViewObjectFactory.generateStatsViewObjects(getStats()));
    }


    public void paintComponent(Graphics g) {
        int x;
        int y;
        int index = 0;
        g.setColor(Color.WHITE);
        for (StatsViewObject s: svoList) {
            x = getCds().calculateXCoord(this.getWidth(), index);
            y = getCds().calculateYCoord(this.getHeight(), index);
            s.paintComponent(g,x,y);
            index++;
        }
    }


}

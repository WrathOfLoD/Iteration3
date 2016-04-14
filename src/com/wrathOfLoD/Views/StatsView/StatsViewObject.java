package com.wrathOfLoD.Views.StatsView;

import java.awt.*;

/**
 * Created by echristiansen on 4/13/2016.
 */
public class StatsViewObject {
    private String statName;
    private int statValue; // TODO: 4/13/2016 int or string?
    private String statString;

    public String getStatName() {
        return statName;
    }
    public void setStatName(String statName) {
        this.statName = statName;
    }
    public int getStatValue() {
        return statValue;
    }
    public void setStatValue(int statValue) {
        this.statValue = statValue;
    }
    public String getStatString() {
        return statString;
    }
    public void setStatString(String statString) {
        this.statString = statString;
    }

    String stat = statName+": " +statValue;

    public StatsViewObject(String statName, int statValue) {
        setStatName(statName);
        setStatValue(statValue);
        setStatString(createStatString());
    }

    public String createStatString() {
        String statString = getStatName()+": " +getStatValue();
        return statString;
    }

    public void paintComponent(Graphics g, int x, int y) {
        g.drawString(getStatString(), x, y);
    }
}

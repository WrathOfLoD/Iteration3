package com.wrathOfLoD.Views;

import com.wrathOfLoD.Views.ContentDisplayStructure.ContentDisplayStructure;
import com.wrathOfLoD.Views.ContentDisplayStructure.GridStructure;
import com.wrathOfLoD.Views.ViewFactories.TextLabelFactory;

import javax.swing.*;
import java.awt.*;

/**
 * Created by echristiansen on 4/8/2016.
 */
public class StaticView extends View {

    private String title;
    private JPanel titlePanel;
    private ContentDisplayStructure contentDisplayStructure;

    /** Getters and Setters **/
    public StaticView(ContentDisplayStructure cds) {
        setContentDisplayStructure(cds);
    }
    public StaticView() { //// TODO: 4/17/2016 maybe delete default constructor
       setContentDisplayStructure(new GridStructure(8,4));
    }
    public ContentDisplayStructure getContentDisplayStructure() {
        return contentDisplayStructure;
    }
    public void setContentDisplayStructure(ContentDisplayStructure cds) {
        this.contentDisplayStructure = cds;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public JPanel getTitlePanel() {
        return titlePanel;
    }
    public void setTitlePanel(JPanel titlePanel) {
        this.titlePanel = titlePanel;
    }


    public final void generateTitle() {
        setTitlePanel(new JPanel());
        getTitlePanel().setLayout(new BorderLayout());
        getTitlePanel().setBackground(new Color(0f, 0f, 0f, 0f));
        getTitlePanel().setPreferredSize(new Dimension(this.getWidth(), 50));
        JLabel titleLabel = TextLabelFactory.generateTextLabel(getTitle(), 30, Color.white);
        getTitlePanel().add(titleLabel, BorderLayout.SOUTH);
    }


    public final void initDefaultUI() {
        this.setLayout(new BorderLayout());
        generateTitle();
        this.add(getTitlePanel(), BorderLayout.NORTH);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        /*
        if(getTitle()==null) {
            setTitle("");
        }
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
        int titleHeight = g.getFontMetrics().getAscent();
        int titleWidth = g.getFontMetrics().stringWidth(getTitle());
        int titleX = this.getWidth()/2 - titleWidth/2;
        int titleY = titleHeight + 10;
        g.drawString(getTitle(), titleX, titleY);
        */
    }

}

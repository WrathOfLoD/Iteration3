package com.wrathOfLoD.VisitorInterfaces;

import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.MapArea;
import com.wrathOfLoD.Models.Map.TilePillar;

/**
 * Created by icavitt on 4/12/2016.
 */
public interface MapVisitor {

    public void visitMap(Map map);
    public void visitMapArea(MapArea mapArea);
    public void visitTilePillar(TilePillar tilePillar);
}

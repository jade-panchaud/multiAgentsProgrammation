package jgrapht_custom;

import java.util.ArrayList;

public class EdgeFactory {

    public static DefaultEdgeList getDefaultEdgeList() {
        return new DefaultEdgeList(new ArrayList<>());
    }
}

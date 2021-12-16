package jgrapht_custom;

import org.jgrapht.graph.DefaultEdge;

import java.util.List;

public class DefaultEdgeList extends DefaultEdge {

    private List<Double> values;

    public DefaultEdgeList(List<Double> values) {
        super();
        this.values = values;
    }

    public void addValue(Double value) {
        values.add(value);
    }

    public List<Double> getValues() {
        return values;
    }

    public void setValues(List<Double> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return super.toString() + values.toString();
    }
}

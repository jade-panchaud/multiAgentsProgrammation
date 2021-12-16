package trust.graph;

import agent.Agent;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.nio.Attribute;
import org.jgrapht.nio.DefaultAttribute;
import org.jgrapht.nio.dot.DOTExporter;

import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReputationGraph {

    public final Graph<Agent, DefaultWeightedEdge> reputationGraph;

    public ReputationGraph(Graph<Agent, DefaultWeightedEdge> reputationGraph) {
        this.reputationGraph = reputationGraph;
    }

    public String toDot() {
        DOTExporter<Agent, DefaultWeightedEdge> exporter = new DOTExporter<>(
                v -> v.toString()
                        .replace('.', '_')
                        .replace(' ', '_')
                        .replace('[', '_')
                        .replace(']', '_')
                        .replace('@', '_')
        );
        exporter.setVertexAttributeProvider(v -> {
            return v.getDot().getStyle();
        });
        exporter.setEdgeAttributeProvider(v -> {
            Map<String, Attribute> map = new HashMap<>();
            double displayWeight = new BigDecimal(reputationGraph.getEdgeWeight(v)).setScale(2, RoundingMode.HALF_UP).doubleValue();
            map.put("label", DefaultAttribute.createAttribute(displayWeight));
            map.put("len", DefaultAttribute.createAttribute((1 - displayWeight) * 2));
            return map;
        });
        exporter.setGraphAttributeProvider(() -> {
            Map<String, Attribute> map = new LinkedHashMap<>();
            map.put("label", DefaultAttribute.createAttribute(
                    "\"Reputation Graph\""
            ));
            return map;
        });
        Writer writer = new StringWriter();
        exporter.exportGraph(reputationGraph, writer);
        return writer.toString();
    }
}

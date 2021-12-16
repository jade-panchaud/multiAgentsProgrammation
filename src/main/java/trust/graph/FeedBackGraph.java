package trust.graph;

import agent.Agent;
import jgrapht_custom.DefaultEdgeList;
import jgrapht_custom.EdgeFactory;
import org.jgrapht.Graph;
import org.jgrapht.nio.Attribute;
import org.jgrapht.nio.DefaultAttribute;
import org.jgrapht.nio.dot.DOTExporter;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FeedBackGraph {

    public final Graph<Agent, DefaultEdgeList> feedBackGraph;

    public FeedBackGraph(Graph<Agent, DefaultEdgeList> feedBackGraph) {
        this.feedBackGraph = feedBackGraph;
    }

    public void addFeedBack(Agent watcher, Agent actor, Double feedBackValue) {
        if (feedBackGraph.containsEdge(watcher, actor)) {
            DefaultEdgeList edge = (DefaultEdgeList) feedBackGraph.getEdge(watcher, actor);
            edge.addValue(feedBackValue);
        } else {
            DefaultEdgeList edge = EdgeFactory.getDefaultEdgeList();
            edge.addValue(feedBackValue);
            feedBackGraph.addEdge(watcher, actor, edge);
        }
    }

    public String toDot() {
        DOTExporter<Agent, DefaultEdgeList> exporter = new DOTExporter<>(
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
            map.put("label", DefaultAttribute.createAttribute(v.getValues().toString()));
            return map;
        });
        exporter.setGraphAttributeProvider(() -> {
            Map<String, Attribute> map = new LinkedHashMap<>();
            map.put("label", DefaultAttribute.createAttribute(
                    "\"FeedBack Graph\""
            ));
            return map;
        });
        Writer writer = new StringWriter();
        exporter.exportGraph(feedBackGraph, writer);
        return writer.toString();
    }
}

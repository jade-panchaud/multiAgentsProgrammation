package trust.graph;

import agent.Agent;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;

public class TrustGraph {
    public final Graph<Agent, DefaultWeightedEdge> trustGraph;

    public TrustGraph(Graph<Agent, DefaultWeightedEdge> trustGraph) {
        this.trustGraph = trustGraph;
    }
}

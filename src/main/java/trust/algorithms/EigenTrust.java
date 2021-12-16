package trust.algorithms;

import agent.Agent;
import jgrapht_custom.DefaultEdgeList;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import trust.graph.FeedBackGraph;
import trust.graph.ReputationGraph;
import trust.graph.TrustGraph;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class EigenTrust implements TrustAlgorithmsInterfaces {

    private double threshold;

    public EigenTrust(double threshold) {
        this.threshold = threshold;
    }

    @Override
    public ReputationGraph calculateReputationGraph(FeedBackGraph feedBackGraph) {

        Graph<Agent, DefaultEdgeList> graph = feedBackGraph.feedBackGraph;
        Graph<Agent, DefaultWeightedEdge> outputGraph = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);

        Set<Agent> agentSet = graph.vertexSet();

        for (Agent agent : agentSet) {
            outputGraph.addVertex(agent);
        }

        for (Agent agent : agentSet) {
            Set<Agent> otherAgents = new java.util.HashSet<>(Set.copyOf(agentSet));
            otherAgents.remove(agent);

            for (Agent otherAgent : otherAgents) {
                DefaultEdgeList currentEdge = graph.getEdge(agent, otherAgent);

                if (Objects.isNull(currentEdge)) {
                    outputGraph.addEdge(agent, otherAgent);
                    outputGraph.setEdgeWeight(agent, otherAgent, 1.0);
                    continue;
                }

                List<Integer> normalisedSatisfactions = currentEdge.getValues().stream().map(v -> {
                    if (v >= threshold) {
                        return 1;
                    }
                    return -1;
                }).collect(Collectors.toList());

                outputGraph.addEdge(agent, otherAgent);
                outputGraph.setEdgeWeight(agent, otherAgent, normalisedSatisfactions.stream().reduce(0, Integer::sum));
            }
        }

        for (Agent agent : agentSet) {
            Set<DefaultWeightedEdge> outGoingEdge = outputGraph.outgoingEdgesOf(agent);
            double sum = 0.0;
            for (DefaultWeightedEdge edge : outGoingEdge) {
                sum += outputGraph.getEdgeWeight(edge);
            }

            for (DefaultWeightedEdge edge : outGoingEdge) {
                double edgeWeight = outputGraph.getEdgeWeight(edge);
                outputGraph.setEdgeWeight(edge, edgeWeight / sum);
            }
        }

        return new ReputationGraph(outputGraph);
    }

    @Override
    public TrustGraph calculateTrustGraph(ReputationGraph reputationGraphGraph) {
        return null;
    }
}

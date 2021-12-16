package trust.algorithms;

import agent.Agent;
import trust.graph.FeedBackGraph;
import trust.graph.ReputationGraph;
import trust.graph.TrustGraph;

public interface TrustAlgorithmsInterfaces {

    ReputationGraph calculateReputationGraph(FeedBackGraph feedBackGraph, Agent currentAgent);

    TrustGraph calculateTrustGraph(ReputationGraph reputationGraphGraph);

}

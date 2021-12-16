package trust.algorithms;

import trust.graph.FeedBackGraph;
import trust.graph.ReputationGraph;
import trust.graph.TrustGraph;

public interface TrustAlgorithmsInterfaces {

    ReputationGraph calculateReputationGraph(FeedBackGraph feedBackGraph);

    TrustGraph calculateTrustGraph(ReputationGraph reputationGraphGraph);

}

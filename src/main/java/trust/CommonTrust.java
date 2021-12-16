package trust;

import trust.algorithms.TrustAlgorithmsInterfaces;
import trust.graph.FeedBackGraph;
import trust.graph.ReputationGraph;
import trust.graph.TrustGraph;

public class CommonTrust {

    private final FeedBackGraph feedBackGraph;
    private ReputationGraph reputationGraph;
    private TrustGraph trustGraph;
    private final TrustAlgorithmsInterfaces trustAlgorithm;

    public CommonTrust(
            FeedBackGraph feedBackGraph,
            ReputationGraph reputationGraph,
            TrustGraph trustGraph,
            TrustAlgorithmsInterfaces trustAlgorithm
    ) {
        this.feedBackGraph = feedBackGraph;
        this.reputationGraph = reputationGraph;
        this.trustGraph = trustGraph;
        this.trustAlgorithm = trustAlgorithm;
    }

    private void calculateReputationGraph() {
//        reputationGraph = trustAlgorithm.calculateReputationGraph(feedBackGraph, this);
    }

    private void calculateTrustGraph() {
        trustGraph = trustAlgorithm.calculateTrustGraph(reputationGraph);
    }

    public FeedBackGraph getFeedBackGraph() {
        return feedBackGraph;
    }

    public ReputationGraph getReputationGraph() {
        return reputationGraph;
    }

    public TrustGraph getTrustGraph() {
        return trustGraph;
    }
}

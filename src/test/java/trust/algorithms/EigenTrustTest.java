package trust.algorithms;

import graphviz.GraphVizFactory;
import org.junit.jupiter.api.Test;
import trust.graph.FeedBackGraph;
import trust.graph.GraphFactory;
import trust.graph.ReputationGraph;

import java.io.IOException;

class EigenTrustTest {


    @Test
    void reputationGraph() throws IOException {

        FeedBackGraph feedBackGraph = GraphFactory.getFeedBackTestGraph();
        EigenTrust eigenTrust = new EigenTrust(0);

        ReputationGraph reputationGraph = eigenTrust.calculateReputationGraph(feedBackGraph);


        System.out.println(feedBackGraph.toDot());
        System.out.println("----------");
        System.out.println(reputationGraph.toDot());

        GraphVizFactory.generateSvg(feedBackGraph);
        GraphVizFactory.generateSvg(reputationGraph);
    }

}
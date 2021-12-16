package trust.graph;

import agent.Agent;
import agent.AgentFactory;
import jgrapht_custom.DefaultEdgeList;
import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleDirectedGraph;

public class GraphFactory {


    public static FeedBackGraph getFeedBackTestGraph() {
        Agent agentA = AgentFactory.getBlueCommonAgent();
        Agent agentB = AgentFactory.getBlueCommonAgent();
        Agent agentC = AgentFactory.getRedCommonAgent();

        agentA.setName("A");
        agentB.setName("B");
        agentC.setName("C");

        Graph<Agent, DefaultEdgeList> feedBackGraph = new SimpleDirectedGraph<>(DefaultEdgeList.class);

        feedBackGraph.addVertex(agentA);
        feedBackGraph.addVertex(agentB);
        feedBackGraph.addVertex(agentC);

        FeedBackGraph backGraph = new FeedBackGraph(feedBackGraph);

        backGraph.addFeedBack(agentB, agentA, 1.0);
        backGraph.addFeedBack(agentC, agentA, 0.0);


        backGraph.addFeedBack(agentA, agentB, 1.0);
        backGraph.addFeedBack(agentA, agentB, 1.0);
        backGraph.addFeedBack(agentA, agentB, -1.0);
        backGraph.addFeedBack(agentC, agentB, 0.0);

        backGraph.addFeedBack(agentA, agentC, 0.0);
        backGraph.addFeedBack(agentB, agentC, 1.0);
        backGraph.addFeedBack(agentB, agentC, 1.0);
        backGraph.addFeedBack(agentB, agentC, 1.0);

        return backGraph;
    }

}

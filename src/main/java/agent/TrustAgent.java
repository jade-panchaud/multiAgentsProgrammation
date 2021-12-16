package agent;

import card.Card;
import card_hand.CardHandInterface;
import card_hand_score.CardHandScore;
import card_hand_score.Score;
import comportment.ComportmentInterface;
import dot.DotInterface;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import team.Team;
import trust.algorithms.TrustAlgorithmsInterfaces;
import trust.graph.FeedBackGraph;
import trust.graph.ReputationGraph;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TrustAgent extends AgentCommon {

    protected FeedBackGraph feedBackGraph;
    protected TrustAlgorithmsInterfaces trustAlgorithms;


    public TrustAgent(CardHandScore cardHandScore, Team team, ComportmentInterface comportment, DotInterface dot) {
        super(cardHandScore, team, comportment, dot);
    }


    @Override
    public Agent choseAgent(List<Agent> agents) {
        ReputationGraph reputation = getReputation();
        Graph<Agent, DefaultWeightedEdge> reputationGraph = reputation.reputationGraph;
        TreeSet<Score> agentsScores = scoreAllAgents(reputationGraph);
        return agentsScores.last().getAgent();
    }

    @Override
    public void setFeedBack(Agent agent, CardHandInterface cardHand, Card card) {
        super.setFeedBack(agent, cardHand, card);
    }

    private TreeSet<Score> scoreAllAgents(Graph<Agent, DefaultWeightedEdge> agentsGraph) {

        TreeSet<Score> agentsScores = new TreeSet<>();

        Set<Agent> agentSet = agentsGraph.vertexSet();
        agentSet.remove(this);

        int handScore = 0;
        for (Agent agent : agentSet) {
            if (!agent.getHand().getCardsInHand().isEmpty()) {
                double trustValue = getTrust(agent, agentsGraph);
                handScore = cardHandScore.getHandScore(agent.makeAnAnnonce());
                agentsScores.add(new Score(agent, (handScore * trustValue)));
            }
        }
        return agentsScores;
    }

    private double getTrust(Agent agent, Graph<Agent, DefaultWeightedEdge> agentsGraph) {
        DefaultWeightedEdge edge = agentsGraph.getEdge(this, agent);
        return agentsGraph.getEdgeWeight(edge);
    }

    public ReputationGraph getReputation() {
        return trustAlgorithms.calculateReputationGraph(feedBackGraph);
    }
}

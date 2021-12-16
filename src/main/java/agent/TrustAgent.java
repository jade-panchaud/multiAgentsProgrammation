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
import trust.graph.ReputationGraph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TrustAgent extends AgentCommon {


    protected TrustAlgorithmsInterfaces trustAlgorithms;


    public TrustAgent(CardHandScore cardHandScore, Team team, ComportmentInterface comportment, DotInterface dot, TrustAlgorithmsInterfaces trustAlgorithms) {
        super(cardHandScore, team, comportment, dot);
        this.trustAlgorithms = trustAlgorithms;
    }


    @Override
    public Agent choseAgent(List<Agent> agents) {
        ReputationGraph reputation = getReputationGraph();
        Graph<Agent, DefaultWeightedEdge> reputationGraph = reputation.reputationGraph;
        TreeSet<Score> agentsScores = scoreAllAgents(reputationGraph);
        return agentsScores.last().getAgent();
    }

    @Override
    public void setFeedBack(Agent agent, CardHandInterface cardHand, Card card) {
        feedBackGraph.addFeedBack(
                this,
                agent,
                cardHandScore.getFeedBackScore(cardHand, card)
        );
    }

    private TreeSet<Score> scoreAllAgents(Graph<Agent, DefaultWeightedEdge> agentsGraph) {

        TreeSet<Score> agentsScores = new TreeSet<>();

        Set<Agent> agentSet = new HashSet<>(Set.copyOf(agentsGraph.vertexSet()));
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

    @Override
    public ReputationGraph getReputationGraph() {
        return trustAlgorithms.calculateReputationGraph(feedBackGraph, this);
    }
}

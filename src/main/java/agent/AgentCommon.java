package agent;

import card.Card;
import card.CardType;
import card_hand.CardHandInterface;
import card_hand_score.CardHandScore;
import card_hand_score.Score;
import comportment.ComportmentInterface;
import dot.DotInterface;
import team.Team;
import trust.graph.FeedBackGraph;
import trust.graph.ReputationGraph;

import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class AgentCommon implements Agent {

    protected FeedBackGraph feedBackGraph;
    protected CardHandInterface hand;
    protected final HashMap<CardHandInterface, CardType> actions;
    protected final CardHandScore cardHandScore;
    protected final ComportmentInterface comportment;
    protected Team team;
    protected DotInterface dot;
    protected String name = "";

    public AgentCommon(CardHandScore cardHandScore, Team team, ComportmentInterface comportment, DotInterface dot) {
        actions = new HashMap<>();
        this.cardHandScore = cardHandScore;
        this.team = team;
        this.comportment = comportment;
        this.dot = dot;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    @Override
    public void setFeedBack(Agent agent, CardHandInterface cardHand, Card card) {
    }

    @Override
    public Agent choseAgent(List<Agent> agents) {
        TreeSet<Score> agentsScores = scoreAllAgents(agents);
        return agentsScores.last().getAgent();
    }

    private TreeSet<Score> scoreAllAgents(List<Agent> agents) {

        TreeSet<Score> agentsScores = new TreeSet<>();

        int handScore = 0;
        for (Agent agent : agents) {
            if (!agent.getHand().getCardsInHand().isEmpty()) {
                handScore = cardHandScore.getHandScore(agent.makeAnAnnonce());
                agentsScores.add(new Score(agent, handScore));
            }
        }

        return agentsScores;
    }

    @Override
    public CardHandInterface makeAnAnnonce() {
        return hand;
    }

    @Override
    public CardHandInterface getHand() {
        return hand;
    }

    @Override
    public void setHand(CardHandInterface hand) {
        this.hand = hand;
    }

    @Override
    public Card pickACard() {
        CardHandInterface lastHand = hand.Clone();
        Card pickedCard = hand.pick();
        actions.put(lastHand, pickedCard.getType());
        return pickedCard;
    }

    @Override
    public HashMap<CardHandInterface, CardType> getActions() {
        return actions;
    }

    @Override
    public DotInterface getDot() {
        dot.setLabel(name);
        return dot;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public FeedBackGraph getFeedBackGraph() {
        return feedBackGraph;
    }

    public void setFeedBackGraph(FeedBackGraph feedBackGraph) {
        this.feedBackGraph = feedBackGraph;
    }

    @Override
    public ReputationGraph getReputationGraph() {
        return null;
    }
}

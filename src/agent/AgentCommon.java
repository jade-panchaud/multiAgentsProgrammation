package agent;

import card.CardHand;
import card.CardType;
import card_hand_score.BlueScoreCommon;
import card_hand_score.CardHandScore;
import card_hand_score.Score;

import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class AgentCommon implements Agent {

    private CardHand hand;
    private HashMap<CardHand, CardType> actions;
    private final CardHandScore cardHandScore = new BlueScoreCommon();

    @Override
    public Agent choseAgent(List<Agent> agents) {
        TreeSet<Score> agentsScores = scoreAllAgents(agents);
        return agentsScores.last().getAgent();
    }

    private TreeSet<Score> scoreAllAgents(List<Agent> agents) {

        TreeSet<Score> agentsScores = new TreeSet<>();

        int handScore = 0;
        for (Agent agent : agents) {
            handScore = cardHandScore.getHandScore(agent.makeAnAnnonce());
            agentsScores.add(new Score(agent, handScore));
        }

        return agentsScores;
    }

    @Override
    public CardHand makeAnAnnonce() {
        return hand;
    }

    @Override
    public CardHand getHand() {
        return hand;
    }

    @Override
    public void setHand(CardHand hand) {
        this.hand = hand;
    }
}

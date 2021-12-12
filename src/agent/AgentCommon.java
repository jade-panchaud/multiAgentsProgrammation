package agent;

import card.Card;
import card.CardType;
import card_hand.CardHandInterface;
import card_hand_score.BlueScoreCommon;
import card_hand_score.CardHandScore;
import card_hand_score.Score;
import team.Team;

import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class AgentCommon implements Agent {

    private CardHandInterface hand;
    private final HashMap<CardHandInterface, CardType> actions;
    private final CardHandScore cardHandScore = new BlueScoreCommon();
    private Team team;

    public AgentCommon() {
        actions = new HashMap<>();
    }

    public AgentCommon(Team team) {
        actions = new HashMap<>();
        this.team = team;
    }

    public Team getTeam() {
        return team;
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
            handScore = cardHandScore.getHandScore(agent.makeAnAnnonce());
            agentsScores.add(new Score(agent, handScore));
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
}

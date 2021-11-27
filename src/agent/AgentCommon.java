package agent;

import card.CardHand;
import card.CardType;

import java.util.HashMap;
import java.util.List;

public class AgentCommon implements Agent {

    private CardHand hand;
    private HashMap<CardHand, CardType> actions;

    @Override
    public Agent choseAgent(List<Agent> agents) {
        return null;
    }

    @Override
    public CardHand makeAnAnnonce() {
        return hand;
    }
}

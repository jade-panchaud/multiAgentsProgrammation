package agent;

import card.CardHand;

import java.util.List;

/**
 * A CopyCat has the same behavior with the Agent that
 * he had with him.
 */
public class CopyCat implements Agent{
    private CardHand cardInHands;

    /**
     * Give cards to an Agent (distribution of the cards)
     * @param cardInHands the cards of the Agent
     */
    public void setCardInHands(CardHand cardInHands) {
        this.cardInHands = cardInHands;
    }

    @Override
    public Agent choseAgent(List<Agent> agents) {
        //TODO
        return agents.get(0);
    }

    @Override
    public void confidenceAndReputationCalcul() {
        //TODO
    }

    @Override
    public boolean makeAnAnnonce() {
        //TODO
        return false;
    }
}

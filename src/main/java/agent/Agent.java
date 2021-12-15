package agent;

import card.Card;
import card.CardType;
import card_hand.CardHandInterface;
import team.Team;

import java.util.HashMap;
import java.util.List;

public interface Agent {

    CardHandInterface getHand();

    void setHand(CardHandInterface hand);

    Team getTeam();

    /**
     * Choose an test.java.agent to pick a card, in order to make
     * win his team.
     *
     * @param agents the list of agents playing the game
     * @return the test.java.agent choosen to pick a card
     */
    Agent choseAgent(List<Agent> agents);

    /**
     * In function of this cards in hands, strategy and his team, an
     * Agent is going to make an annonce at the beginning of a new turn.
     * First step is to have a "yes/no" annonce. Yes means other
     * agents can take a card from us, no means their rather not
     * because they don't have any green card or has a bomb card
     * maybe.
     * In a second step, it's gonna be number from 0 to x (the
     * number of cards in hands), to indicate the number of
     * green cards in hands.
     * @return TRUE if another Agent can pick one of his cards,
     *         FALSE if other Agents shouldn't.
     */
    CardHandInterface makeAnAnnonce();

    Card pickACard();

    HashMap<CardHandInterface, CardType> getActions();
}

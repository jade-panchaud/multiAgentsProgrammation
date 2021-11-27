package card;

import agent.Agent;

import java.util.ArrayList;
import java.util.List;

public class CardSet implements CardListener {
    private int greenCardsReturned;
    private List<Card> cardsInGame;
    private boolean bombReturned;

    public CardSet(int numberOfAgents) {
        this.greenCardsReturned = 0;
        createCardSet(numberOfAgents);
        this.bombReturned = false;
    }

    /**
     * Create the set of cards.
     * A set of cards has 1 bomb, x green cards (x the number of
     * players) and 15 + (x - 4) * 4 yellow cards/
     * @param numberOfAgents the number of players.
     */
    public void createCardSet(int numberOfAgents){
       cardsInGame = new ArrayList<>();

       cardsInGame.add(new Card(CardType.BOMB));

       for(int i = 0; i < numberOfAgents; i++){
           cardsInGame.add(new Card(CardType.GREEN));
       }

       int yellowCards = 15 + ((numberOfAgents - 4) * 4);
       for(int i = 0; i < yellowCards; i++){
           cardsInGame.add(new Card(CardType.YELLOW));
       }

    }

    /**
     * Give a hand of cards for each agent, depending of how many cards
     * are still in the game (should be one less than the previous
     * round)
     * @param players all the players
     */
    public void giveCards(List<Agent> players){
        int numberOfCardsPerAgent = this.getRemainedCardsInGame() / players.size();
        for (Agent agent: players) {
            CardHand cardHand = new CardHand();
        }

    }

    public int getGreenCardsReturned() {
        return greenCardsReturned;
    }

    public boolean isBombReturned() {
        return bombReturned;
    }

    public int getRemainedCardsInGame(){
        return cardsInGame.size();
    }

    @Override
    public void greenReturned(Card card) {
        greenCardsReturned++;
        cardsInGame.remove(card);
    }

    @Override
    public void yellowReturned(Card card) {
        cardsInGame.remove(card);
    }

    @Override
    public void bombReturned(Card card) {
        bombReturned = true;
        cardsInGame.remove(card);
    }
}

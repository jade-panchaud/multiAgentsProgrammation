package card;

import agent.Agent;

import java.util.List;

public class CardSet implements CardListener {
    private int greenCardsReturned;
    private List<Card> cardsInGame;
    private boolean bombReturned;

    public CardSet(int numberOfAgents) {
        this.greenCardsReturned = 0;
        this.cardsInGame = createCardSet(numberOfAgents);
        this.bombReturned = false;
    }

    public List<Card> createCardSet(int numberOfAgents){
        return null;
    }

    public void giveCards(List<Agent> players){

    }

    public int getGreenCardsReturned() {
        return greenCardsReturned;
    }

    public boolean isBombReturned() {
        return bombReturned;
    }

    @Override
    public void greenReturned(Card card) {
        greenCardsReturned++;
    }

    @Override
    public void yellowReturned(Card card) {

    }

    @Override
    public void bombReturned(Card card) {
        bombReturned = true;
    }
}

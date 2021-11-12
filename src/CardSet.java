import java.util.List;

public class CardSet {
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
}

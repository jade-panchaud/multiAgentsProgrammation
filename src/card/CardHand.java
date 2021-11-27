package card;

import tools.Util;

import java.util.List;

public class CardHand {
    private List<Card> cardsInHand;

    public void setCardsInHand(List<Card> cardsInHand) {
        this.cardsInHand = cardsInHand;
    }

    public List<Card> getCardsInHand() {
        return cardsInHand;
    }

    public Card pick() {
        Card cardPicked = cardsInHand.remove(Util.randomInt(cardsInHand.size()));
        cardPicked.pick();

        return cardPicked;
    }
}

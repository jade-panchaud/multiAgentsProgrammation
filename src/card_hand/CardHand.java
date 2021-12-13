package card_hand;

import card.Card;
import card.CardType;
import tools.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CardHand implements CardHandInterface {
    private List<Card> cardsInHand;

    @Override
    public void setCardsInHand(List<Card> cardsInHand) {
        this.cardsInHand = cardsInHand;
    }

    @Override
    public List<Card> getCardsInHand() {
        return cardsInHand;
    }

    @Override
    public Card pick() {
        Card cardPicked = cardsInHand.remove(Util.randomInt(cardsInHand.size()));
        cardPicked.pick();

        return cardPicked;
    }

    @Override
    public CardHandInterface Clone() {
        try {
            CardHand clone = (CardHand) super.clone();
            clone.cardsInHand = new ArrayList<>(cardsInHand);

            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public boolean hasBomb() {
        boolean hasBomb = false;

        for (Card card : cardsInHand) {
            hasBomb = card.getType() == CardType.BOMB;
        }

        return hasBomb;
    }

    @Override
    public int greenCardCount() {
        int greenCardCount = 0;
        for (Card card : cardsInHand) {
            if (card.getType() == CardType.GREEN) {
                greenCardCount++;
            }
        }
        return greenCardCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardHand cardHand = (CardHand) o;
        return Objects.equals(cardsInHand, cardHand.cardsInHand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardsInHand);
    }
}

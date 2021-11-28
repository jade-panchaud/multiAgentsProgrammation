package card_hand;

import card.Card;

import java.util.List;

public interface CardHandInterface extends Cloneable {
    void setCardsInHand(List<Card> cardsInHand);

    List<Card> getCardsInHand();

    Card pick();

    CardHandInterface Clone();

    boolean equals(Object o);
}

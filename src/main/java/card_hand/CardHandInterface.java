package card_hand;

import card.Card;
import card.CardType;

import java.util.List;

public interface CardHandInterface extends Cloneable {
    void setCardsInHand(List<Card> cardsInHand);

    List<Card> getCardsInHand();

    Card pick();

    CardHandInterface Clone();

    boolean hasBomb();

    int greenCardCount();

    boolean equals(Object o);

    int countCard();

    int countCardType(CardType cardType);
}

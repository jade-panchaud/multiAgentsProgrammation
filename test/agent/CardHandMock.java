package agent;

import card.Card;
import card_hand.CardHand;

public class CardHandMock extends CardHand {

    @Override
    public Card pick() {
        return getCardsInHand().remove(0);
    }
}

package card;

import tools.Util;

import java.util.List;

public class CardHand {
    List<Card> cardsInHand;

    public Card pick() {
        return cardsInHand.remove(Util.randomInt(cardsInHand.size()));
    }
}

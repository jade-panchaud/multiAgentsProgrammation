package comportment;

import card_hand.CardHandInterface;

public class CommonComportment implements ComportmentInterface {

    @Override
    public CardHandInterface announceHand(CardHandInterface cardHand) {
        return cardHand.Clone();
    }
}

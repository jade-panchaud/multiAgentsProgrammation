package comportment.hide_comportment;

import card_hand.CardHandInterface;

public class RedHiddenComportment extends HiddenComportment {

    @Override
    public CardHandInterface announceHand(CardHandInterface cardHand) {
        if (cardHand.hasBomb()) {
            return getGreenHand(cardHand, 2);
        }
        if (cardHand.greenCardCount() > 0) {
            return getYellowHand(cardHand);
        }
        return cardHand;
    }
}

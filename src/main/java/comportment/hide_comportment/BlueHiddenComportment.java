package comportment.hide_comportment;

import card_hand.CardHandInterface;

public class BlueHiddenComportment extends HiddenComportment {

    @Override
    public CardHandInterface announceHand(CardHandInterface cardHand) {
        if (cardHand.hasBomb()) {
            return super.getYellowHand(cardHand);
        } else {
            return cardHand;
        }
    }
}

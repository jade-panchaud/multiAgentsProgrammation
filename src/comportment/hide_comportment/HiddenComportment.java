package comportment.hide_comportment;

import card.Card;
import card.CardType;
import card_hand.CardHand;
import card_hand.CardHandInterface;
import comportment.CommonComportment;

import java.util.ArrayList;
import java.util.List;

public class HiddenComportment extends CommonComportment {

    protected CardHandInterface getYellowHand(CardHandInterface hand) {
        List<Card> cardList = new ArrayList<>();

        for (int i = 0; i < hand.getCardsInHand().size(); i++) {
            Card yellow = new Card(CardType.YELLOW);
            cardList.add(yellow);
        }
        CardHandInterface fakeHand = new CardHand();
        fakeHand.setCardsInHand(cardList);
        return fakeHand;
    }

    protected CardHandInterface getGreenHand(CardHandInterface hand, int greenCardNumber) {
        List<Card> cardList = new ArrayList<>();
        int handSize = hand.getCardsInHand().size();

        for (int i = 0; i < greenCardNumber; i++) {
            cardList.add(new Card(CardType.GREEN));
        }

        for (int i = greenCardNumber; i < handSize; i++) {
            cardList.add(new Card(CardType.YELLOW));
        }

        CardHandInterface fakeHand = new CardHand();
        fakeHand.setCardsInHand(cardList);
        return fakeHand;
    }
}

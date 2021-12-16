package card_hand_score;

import card.Card;
import card_hand.CardHandInterface;

public interface CardHandScore {

    public int getHandScore(CardHandInterface cardHand);

    public double getFeedBackScore(CardHandInterface cardHand, Card pickCard);
}

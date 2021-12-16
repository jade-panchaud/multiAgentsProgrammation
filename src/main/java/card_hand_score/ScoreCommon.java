package card_hand_score;

import card.Card;
import card_hand.CardHandInterface;

import java.util.List;

public abstract class ScoreCommon implements CardHandScore {

    @Override
    public int getHandScore(CardHandInterface cardHand) {

        List<Card> hand = cardHand.getCardsInHand();

        int totalScore = 0;

        for (Card card : hand) {
            totalScore += getCardScore(card);
        }

        return totalScore;
    }

    protected abstract int getCardScore(Card card);

    @Override
    public double getFeedBackScore(CardHandInterface cardHand, Card pickCard) {
        if (isObjectiveCard(pickCard)) {
            return 1;
        }
        return getProbability(cardHand, pickCard);
    }

    protected abstract boolean isObjectiveCard(Card card);

    protected double getProbability(CardHandInterface cardHand, Card card) {
        double totalCard = cardHand.countCard();
        double cardTypeCount = cardHand.countCardType(card.getType());
        return (cardTypeCount / totalCard);
    }
}

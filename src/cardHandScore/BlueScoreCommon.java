package cardHandScore;

import card.Card;
import card.CardHand;
import card.CardType;

import java.util.HashMap;
import java.util.List;

public class BlueScoreCommon implements CardHandScore {

    private final HashMap<CardType, Integer> cardScore;

    public BlueScoreCommon(HashMap<CardType, Integer> cardScore) {
        this.cardScore = cardScore;
    }

    public BlueScoreCommon() {
        cardScore = new HashMap<>();
        cardScore.put(CardType.GREEN, 1);
        cardScore.put(CardType.YELLOW, 0);
        cardScore.put(CardType.BOMB, -10);
    }

    @Override
    public int getHandScore(CardHand cardHand) {

        List<Card> hand = cardHand.getCardsInHand();

        int totalScore = 0;

        for (Card card : hand) {
            totalScore += getCardScore(card);
        }

        return totalScore;
    }

    private int getCardScore(Card card) {
        return cardScore.get(card.getType());
    }
}

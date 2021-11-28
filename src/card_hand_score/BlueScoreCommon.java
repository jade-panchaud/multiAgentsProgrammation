package card_hand_score;

import card.CardType;

import java.util.HashMap;

public class BlueScoreCommon extends ScoreCommon implements CardHandScore {

    public BlueScoreCommon() {
        super(getCardScore());
    }

    private static HashMap<CardType, Integer> getCardScore() {
        HashMap<CardType, Integer> cardScore = new HashMap<>();
        cardScore.put(CardType.GREEN, 1);
        cardScore.put(CardType.YELLOW, 0);
        cardScore.put(CardType.BOMB, -10);
        return cardScore;
    }
}

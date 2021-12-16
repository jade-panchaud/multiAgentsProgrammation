package card_hand_score;

import card.Card;
import card.CardType;

public class BlueScoreCommon extends ScoreCommon implements CardHandScore {

    @Override
    protected int getCardScore(Card card) {
        return switch (card.getType()) {
            case GREEN -> 1;
            case YELLOW -> 0;
            case BOMB -> -10;
        };
    }

    @Override
    protected boolean isObjectiveCard(Card card) {
        return (card.getType() == CardType.GREEN);
    }
}

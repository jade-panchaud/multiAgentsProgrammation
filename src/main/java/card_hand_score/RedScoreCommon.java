package card_hand_score;

import card.Card;
import card.CardType;
import card_hand.CardHandInterface;

public class RedScoreCommon extends ScoreCommon implements CardHandScore {

    @Override
    protected int getCardScore(Card card) {
        return switch (card.getType()) {
            case GREEN -> -1;
            case YELLOW -> 0;
            case BOMB -> 10;
        };
    }

    @Override
    protected boolean isObjectiveCard(Card card) {
        return (card.getType() == CardType.BOMB) || (card.getType() == CardType.YELLOW);
    }
}

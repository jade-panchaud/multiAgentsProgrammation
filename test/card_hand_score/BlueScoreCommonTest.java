package card_hand_score;

import card.Card;
import card_hand.CardHand;
import card.CardType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BlueScoreCommonTest {

    private BlueScoreCommon blueScoreCommon = new BlueScoreCommon();

    @Test
    void getHandScore_all_yellow() {

        CardHand hand = new CardHand();
        List<Card> cardInHand = new ArrayList<>();
        cardInHand.add(new Card(CardType.YELLOW));
        cardInHand.add(new Card(CardType.YELLOW));
        cardInHand.add(new Card(CardType.YELLOW));
        cardInHand.add(new Card(CardType.YELLOW));
        cardInHand.add(new Card(CardType.YELLOW));

        hand.setCardsInHand(cardInHand);

        assertEquals(0, blueScoreCommon.getHandScore(hand));
    }

    @Test
    void getHandScore_3_green() {

        CardHand hand = new CardHand();
        List<Card> cardInHand = new ArrayList<>();
        cardInHand.add(new Card(CardType.GREEN));
        cardInHand.add(new Card(CardType.GREEN));
        cardInHand.add(new Card(CardType.GREEN));
        cardInHand.add(new Card(CardType.YELLOW));
        cardInHand.add(new Card(CardType.YELLOW));

        hand.setCardsInHand(cardInHand);

        assertEquals(3, blueScoreCommon.getHandScore(hand));
    }

    @Test
    void getHandScore_1_bomb_2_green() {

        CardHand hand = new CardHand();
        List<Card> cardInHand = new ArrayList<>();
        cardInHand.add(new Card(CardType.GREEN));
        cardInHand.add(new Card(CardType.BOMB));
        cardInHand.add(new Card(CardType.GREEN));
        cardInHand.add(new Card(CardType.YELLOW));
        cardInHand.add(new Card(CardType.YELLOW));

        hand.setCardsInHand(cardInHand);

        assertEquals(-8, blueScoreCommon.getHandScore(hand));
    }
}
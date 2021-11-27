package agent;

import card.Card;
import card.CardHand;
import card.CardType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class AgentCommonTest {

    private AgentCommon agentCommon = new AgentCommon();

    @Test
    public void test_make_hand_annonce() {

        CardHand hand = new CardHand();
        List<Card> cardInHand = new ArrayList<>();
        cardInHand.add(new Card(CardType.GREEN));
        cardInHand.add(new Card(CardType.GREEN));
        cardInHand.add(new Card(CardType.YELLOW));
        cardInHand.add(new Card(CardType.YELLOW));
        cardInHand.add(new Card(CardType.BOMB));

        hand.setCardsInHand(cardInHand);
        agentCommon.setHand(hand);
        Assertions.assertEquals(hand, agentCommon.makeAnAnnonce());
    }

}
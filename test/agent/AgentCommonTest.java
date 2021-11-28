package agent;

import card.Card;
import card.CardType;
import card_hand.CardHand;
import card_hand.CardHandInterface;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgentCommonTest {

    private final AgentCommon agentCommon = new AgentCommon();

    @Test
    void test_make_hand_annonce() {

        CardHand hand = new CardHand();
        List<Card> cardInHand = new ArrayList<>();
        cardInHand.add(new Card(CardType.GREEN));
        cardInHand.add(new Card(CardType.GREEN));
        cardInHand.add(new Card(CardType.YELLOW));
        cardInHand.add(new Card(CardType.YELLOW));
        cardInHand.add(new Card(CardType.BOMB));

        hand.setCardsInHand(cardInHand);
        agentCommon.setHand(hand);
        assertEquals(hand, agentCommon.makeAnAnnonce());
    }


    @Test
    void test_choose_agent() {

        Agent agentA = agentFactory(new CardType[]{
                CardType.BOMB,
                CardType.GREEN,
                CardType.YELLOW,
                CardType.YELLOW,
                CardType.YELLOW,
        });
        Agent agentB = agentFactory(new CardType[]{
                CardType.GREEN,
                CardType.GREEN,
                CardType.YELLOW,
                CardType.YELLOW,
                CardType.YELLOW,
        });
        Agent agentC = agentFactory(new CardType[]{
                CardType.GREEN,
                CardType.YELLOW,
                CardType.YELLOW,
                CardType.YELLOW,
                CardType.YELLOW,
        });

        List<Agent> agents = new ArrayList<>();
        agents.add(agentA);
        agents.add(agentB);
        agents.add(agentC);

        assertEquals(agentB, agentCommon.choseAgent(agents));
    }

    Agent agentFactory(CardType[] cardTypes) {

        CardHand hand = new CardHand();
        List<Card> cardInHand = new ArrayList<>();
        Agent agent = new AgentCommon();

        for (CardType cardType : cardTypes) {
            cardInHand.add(new Card(cardType));
        }

        hand.setCardsInHand(cardInHand);
        agent.setHand(hand);
        return agent;
    }

    @Test
    void pickACard() {

        Agent agent = new AgentCommon();

        CardHandInterface hand = new CardHandMock();
        List<Card> cardInHand = new ArrayList<>();
        cardInHand.add(new Card(CardType.GREEN));
        cardInHand.add(new Card(CardType.GREEN));
        cardInHand.add(new Card(CardType.YELLOW));
        cardInHand.add(new Card(CardType.YELLOW));
        cardInHand.add(new Card(CardType.BOMB));

        hand.setCardsInHand(cardInHand);

        CardHandInterface handClone = hand.Clone();
        agent.setHand(handClone);
        Card pickedCard = agent.pickACard();

        HashMap<CardHandInterface, CardType> actions = new HashMap<>();
        actions.put(hand, pickedCard.getType());

        assertEquals(actions, agent.getActions());

    }
}
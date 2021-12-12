package agent;

import card.Card;
import card.CardType;
import card_hand.CardHand;
import card_hand.CardHandInterface;
import card_hand_score.CardHandScore;
import team.Team;

import java.util.ArrayList;
import java.util.List;

public class AgentHideBomb extends AgentCommon {
    public AgentHideBomb(CardHandScore cardHandScore, Team team) {
        super(cardHandScore, team);
    }

    @Override
    public CardHandInterface makeAnAnnonce() {
        if(!hand.hasBomb()) {
            return hand;
        } else {
            return getYellowHand();
        }
    }

    private CardHandInterface getYellowHand(){
        CardHand yellowCardHand = new CardHand();
        List<Card> cardList = new ArrayList<>();

        for(int i = 0; i < hand.getCardsInHand().size(); i++){
            Card yellow = new Card(CardType.YELLOW);
            cardList.add(yellow);
        }
        yellowCardHand.setCardsInHand(cardList);

        return  yellowCardHand;
    }
}

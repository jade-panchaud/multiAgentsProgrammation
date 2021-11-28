//package agent;
//
//import card_hand.CardHand;
//
//import java.util.List;
//
///**
// * A CopyCat has the same behavior with the Agent that
// * he had with him.
// */
//public class CopyCat implements Agent{
//    private CardHand cardInHands;
//
//    /**
//     * Give cards to an Agent (distribution of the cards)
//     * @param cardInHands the cards of the Agent
//     */
//    public void setCardInHands(CardHand cardInHands) {
//        this.cardInHands = cardInHands;
//    }
//
//    @Override
//    public Agent choseAgent(List<Agent> agents) {
//        //TODO
//        return agents.get(0);
//    }
//
///**
// * Every new turn, each agent calcul the confidence he has
// * in each other agent and also their reputation in order
// * to make the decision to pick a card from an Agent rather
// * than another one
// */
//private void confidenceAndReputationCalcul() {
//
//        }
////
//    @Override
//    public boolean makeAnAnnonce() {
//        //TODO
//        return false;
//    }
//}

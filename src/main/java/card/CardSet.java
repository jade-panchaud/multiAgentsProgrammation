package card;

import tools.Util;

import agent.Agent;
import card_hand.CardHand;
import game.VictoryListener;

import java.util.ArrayList;
import java.util.List;

public class CardSet {
    private int greenCardsReturned;
    private List<Card> cardsInGame;
    private final int greenCardNeededToWin;
    private final VictoryListener victoryListener;

    public CardSet(int numberOfAgents, VictoryListener victoryListener) {
        this.greenCardsReturned = 0;
        createCardSet(numberOfAgents);
        this.victoryListener = victoryListener;
        this.greenCardNeededToWin = numberOfAgents;
    }

    /**
     * Create the set of cards.
     * A set of cards has 1 bomb, x green cards (x the number of
     * players) and 15 + (x - 4) * 4 yellow cards/
     * @param numberOfAgents the number of players.
     */
    public void createCardSet(int numberOfAgents){
       cardsInGame = new ArrayList<>();

       CardListener cardListener = new CardListener() {
           @Override
           public void greenReturned(Card card) {
               greenCardsReturned++;
               cardsInGame.remove(card);

               if(greenCardsReturned == greenCardNeededToWin){
                   victoryListener.blueTeamWins();
               } else if (cardsInGame.size() < greenCardNeededToWin) {
                   victoryListener.redTeamWins(1);
               }
           }

           @Override
           public void yellowReturned(Card card) {
               cardsInGame.remove(card);

               if(cardsInGame.size() < greenCardNeededToWin) {
                   victoryListener.redTeamWins(1);
               }
           }

           @Override
           public void bombReturned(Card card) {
               cardsInGame.remove(card);
               victoryListener.redTeamWins(2);
           }
       };

       cardsInGame.add(new Card(CardType.BOMB, cardListener));

       for(int i = 0; i < numberOfAgents; i++){
           cardsInGame.add(new Card(CardType.GREEN, cardListener));
       }

       int yellowCards = 15 + ((numberOfAgents - 4) * 4);
       for(int i = 0; i < yellowCards; i++){
           cardsInGame.add(new Card(CardType.YELLOW, cardListener));
       }

    }

    /**
     * Give a hand of cards for each test.java.agent, depending of how many cards
     * are still in the game (should be one less than the previous
     * round)
     *
     * @param players all the players
     */
    public void giveCards(List<Agent> players){
        int numberOfCardsPerAgent = (this.getRemainedCardsInGame() / players.size());

        for (Agent agent: players) {
            CardHand cardHand = new CardHand();
            List<Card> listOfCards = new ArrayList<>();

            for(int i = 0; i < numberOfCardsPerAgent; i++){
                int giveRandomCard = Util.randomInt(cardsInGame.size());
                listOfCards.add(cardsInGame.get(giveRandomCard));
            }

            cardHand.setCardsInHand(listOfCards);
            agent.setHand(cardHand);
        }

    }

    public int getGreenCardsReturned() {
        return greenCardsReturned;
    }

    public int getRemainedCardsInGame(){
        return cardsInGame.size();
    }
}

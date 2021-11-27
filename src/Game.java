import agent.Agent;
import card.CardSet;
import display.Display;

import java.util.List;

public class Game {
    private final Display display;
    private List<Agent> players;
    private CardSet cards;

    public Game(Display display) {
        this.display = display;
    }

    /**
     * Start the game
     * @param choosenPlayers the list of Agent playing the game
     */
    public void startGame(List<Agent> choosenPlayers) {
        this.players = choosenPlayers;
        this.cards = new CardSet(this.players.size());

        Agent firstAgentToPlay = this.chooseRandomPlayer();
        int numberOfCardsPerAgent = this.players.size();

        //While there is no victory, start a new round with less
        //cards in each round
        while(!victoryCondition()){
            Agent agentStartingNewRound = startNewRound(firstAgentToPlay, numberOfCardsPerAgent);
            --numberOfCardsPerAgent;
            firstAgentToPlay = agentStartingNewRound;
        }
    }

    /**
     * Mecanism of a round in the game.
     * @param agentBeginningTheRound agent who begin the round (and choose an agent to pick a card)
     * @param numberOfCardsPerAgent number of cards in each agent hands.
     * @return the agent that will begin the next round.
     */
    public Agent startNewRound(Agent agentBeginningTheRound,int numberOfCardsPerAgent){
       //TODO: faire le mécanisme d'un tour (piocher chez l'un, l'autre etc)
        this.cards.giveCards(this.players);

        for (Agent agent: this.players) {
            agent.makeAnAnnonce();
            //TODO : calculer confiance et réputation de l'agent qui choisi après chaque annonce ? ou à la fin ?
            //TODO : choisir le moment du calcul
        }

        return agentBeginningTheRound.choseAgent(this.players);
    }

    /**
     * Choose a random player to begin the game on the first round.
     * @return the agent choosen.
     */
    private Agent chooseRandomPlayer(){
        int random = (int)(Math.random()*(this.players.size()));
        return this.players.get(random);
    }

    /**
     * Verify victory condition. If the bomb is returned, or their is
     * no more cards, red team win.
     * If all green cards are returned, blue team win.
     * @return TRUE if any team has win or FALSE if their is no victory.
     */
    private boolean victoryCondition(){
        if(this.cards.isBombReturned() || this.cards.getRemainedCardsInGame() < this.players.size()){
            this.display.showWinners(Team.RED);
            return true;
        } else if(this.cards.getGreenCardsReturned() == this.players.size()){
            this.display.showWinners(Team.BLUE);
            return true;
        } else {
            return false;
        }
    }
}

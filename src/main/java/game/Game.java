package game;

import agent.Agent;
import card.Card;
import card.CardSet;
import card_hand.CardHandInterface;
import display.Display;
import team.Team;

import java.util.List;

public class Game {
    private final Display display;
    private List<Agent> players;
    private CardSet cards;
    private boolean gameStillRunning;
    private int numberOfTheTurn = 1;

    public Game(Display display) {
        this.display = display;
        this.gameStillRunning = true;
    }

    /**
     * Start the game
     *
     * @param choosenPlayers the list of Agent playing the game
     */
    public void startGame(List<Agent> choosenPlayers) {
        this.players = choosenPlayers;

        this.cards = new CardSet(this.players.size(), this.giveVictoryListener());
        display.showAgents(this.players);

        Agent firstAgentToPlay = this.chooseRandomPlayer();

        //While there is no victory, start a new round with less
        //cards in each round
        while (this.gameStillRunning) {
            display.newTurn(this.numberOfTheTurn);
            Agent agentStartingNewRound = startNewRound(firstAgentToPlay);
            firstAgentToPlay = agentStartingNewRound;
            this.numberOfTheTurn++;
        }
    }

    /**
     * Mecanism of a round in the game.
     *
     * @param agentBeginningTheRound test.java.agent who begin the round (and choose an test.java.agent to pick a card)
     * @return the test.java.agent that will begin the next round.
     */
    public Agent startNewRound(Agent agentBeginningTheRound) {
        this.cards.giveCards(this.players);

        Agent agentFromWhomWeWillPickACard;
        int numberOfActions = this.players.size();

        do {
            agentFromWhomWeWillPickACard = agentBeginningTheRound.choseAgent(this.players);
            display.showChoosenAgent(agentFromWhomWeWillPickACard, agentBeginningTheRound);

            CardHandInterface handAnnounced = agentFromWhomWeWillPickACard.makeAnAnnonce();
            Card pickedCard = agentFromWhomWeWillPickACard.pickACard();

            List<Agent> watcherAgents = new java.util.ArrayList<>(List.copyOf(players));
            watcherAgents.remove(agentFromWhomWeWillPickACard);

            for (Agent watcherAgent : watcherAgents) {
                watcherAgent.setFeedBack(agentFromWhomWeWillPickACard, handAnnounced, pickedCard);
            }

            display.showReturnedCard(pickedCard);

            numberOfActions--;
            display.showGreenReturnedCards(cards.getGreenCardsReturned());
            agentBeginningTheRound = agentFromWhomWeWillPickACard;
        } while (numberOfActions > 0 && this.gameStillRunning);

        return agentFromWhomWeWillPickACard;
    }

    /**
     * Choose a random player to begin the game on the first round.
     *
     * @return the test.java.agent choosen.
     */
    private Agent chooseRandomPlayer() {
        int random = (int) (Math.random() * (this.players.size()));
        return this.players.get(random);
    }

    private VictoryListener giveVictoryListener() {
        return new VictoryListener() {
            @Override
            public void blueTeamWins() {
                gameStillRunning = false;
                display.showWinners(Team.BLUE);
                //Output.updateResultsFile(1, players, 0, numberOfTheTurn, cards.getGreenCardsReturned(), -1, -1);
            }

            @Override
            public void redTeamWins(int victoryType) {
                gameStillRunning = false;
                display.showWinners(Team.RED);
                //Output.updateResultsFile(0, players, victoryType, numberOfTheTurn, cards.getGreenCardsReturned(), -1, -1);
            }
        };
    }
}

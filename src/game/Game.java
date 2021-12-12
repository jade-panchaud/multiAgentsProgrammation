package game;

import team.Team;
import agent.Agent;
import card.CardSet;
import display.Display;

import java.util.List;

public class Game {
    private final Display display;
    private List<Agent> players;
    private CardSet cards;
    private boolean gameStillRunning;

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
        int numberOfTheTurn = 1;
        while (this.gameStillRunning) {
            display.newTurn(numberOfTheTurn);
            Agent agentStartingNewRound = startNewRound(firstAgentToPlay);
            firstAgentToPlay = agentStartingNewRound;
            numberOfTheTurn++;
        }
    }

    /**
     * Mecanism of a round in the game.
     *
     * @param agentBeginningTheRound agent who begin the round (and choose an agent to pick a card)
     * @return the agent that will begin the next round.
     */
    public Agent startNewRound(Agent agentBeginningTheRound) {
        this.cards.giveCards(this.players);

        for (Agent agent : this.players) {
            agent.makeAnAnnonce();
        }

        Agent agentFromWhomWeWillPickACard;
        int numberOfActions = this.players.size();

        do {
            agentFromWhomWeWillPickACard = agentBeginningTheRound.choseAgent(this.players);
            display.showChoosenAgent(agentFromWhomWeWillPickACard, agentBeginningTheRound);

            display.showReturnedCard(agentFromWhomWeWillPickACard.pickACard());

            numberOfActions--;
            display.showGreenReturnedCards(cards.getGreenCardsReturned());
        } while (numberOfActions > 0 && this.gameStillRunning);

        return agentFromWhomWeWillPickACard;
    }

    /**
     * Choose a random player to begin the game on the first round.
     *
     * @return the agent choosen.
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
            }

            @Override
            public void redTeamWins() {
                gameStillRunning = false;
                display.showWinners(Team.RED);
            }
        };
    }
}

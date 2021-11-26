import agent.Agent;
import agent.CopyCat;
import card.CardSet;
import display.Display;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Display display;
    private List<Agent> players;
    private CardSet cards;

    public Game(Display display) {
        this.display = display;
    }

    //Has to ask :
    //How many agents
    //Which strategies ?
    public void startGame(List<Agent> choosenPlayers) {
        this.players = choosenPlayers;
        this.cards = new CardSet(players.size() * players.size());
    }

    public void startNewRound(Agent agentBeginningTheRound,int numberOfCardsPerAgent){

    }

    //Create the players set
    private void createPlayers(int playersNumber){
    }

    //Choose with random a player
    private Agent chooseRandomPlayer(){
        int random = (int)(Math.random()*(players.size() + 1));
        return players.get(random);
    }

    //If the bomb card is returned, or all of the green card are returned, it's a
    //victory for one of the team
    private void victoryCondition(){
        if(cards.isBombReturned()){
            display.showWinners(Team.RED);
        } else if(cards.getGreenCardsReturned() == players.size()){
            display.showWinners(Team.BLUE);
        };
    }
}

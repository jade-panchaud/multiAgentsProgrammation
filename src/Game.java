import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Agent> players;
    private CardSet cards;

    //Has to ask :
    //How many agents
    //Which strategies ?
    public void startGame() {
        Scanner clavier = new Scanner(System.in);
        int playersNumber = 0;

        System.out.println("Quel sera le nombre d'agents ? \n");
        playersNumber = clavier.nextInt();

        this.cards = new CardSet(playersNumber);
    }

    //Create the players set
    private void createPlayers(int playersNumber){
        int redTeam = 1;
        List<Agent> newPlayers = new ArrayList<>();

        //Adapt the number of read players in function of
        //the total of players
        if(playersNumber >= 5) {
            redTeam = 2;
        }

        //Create the blue players
        for(int i = 0; i < playersNumber - redTeam; i++){
            Agent newBlueTeamPlayer = new Agent();
            newBlueTeamPlayer.setTeam(Team.BLUE);
            newPlayers.add(newBlueTeamPlayer);
        }

        //Create the red players
        for(int i = 0; i < redTeam; i++){
            Agent newRedTeamPlayer = new Agent();
            newRedTeamPlayer.setTeam(Team.RED);
            newPlayers.add(newRedTeamPlayer);
        }

        this.players = newPlayers;
    }

    //Choose with random a player
    private Agent chooseRandomPlayer(){
        int random = (int)(Math.random()*(players.size() + 1));
        return players.get(random);
    }

    //If the bomb card is returned, or all of the green card are returned, it's a
    //victory for one of the team
    private boolean victoryCondition(){
        if(cards.isBombReturned()){
            return true;
        } else return cards.getGreenCardsReturned() == players.size();
    }
}

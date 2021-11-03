import java.util.List;

public class Party {
    private List<Agent> players;
    private CardSet cards;

    //Has to ask :
    //How many agents
    //Which strategies ?
    public void startGame(){

    }

    private Agent chooseRandomAgent(){
        int random = (int)(Math.random()*(players.size() + 1));
        return players.get(random);
    }

    private boolean victoryCondition(){
        if(cards.isBombReturned()){
            return true;
        } else return cards.getGreenCardsReturned() == players.size();
    }
}

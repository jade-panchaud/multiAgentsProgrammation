import java.util.List;
import java.util.Map;

public class Agent {
    private Team team;
    private List<Card> cards;
    Map<Agent, Integer> trustInOtherAgents;

    public Card showACard(){
       return cards.remove(0);
    }

    public boolean makeAnAnnonce(){
        if(team == Team.BLUE) {
            if(hasBomb()){
                return false;
            }
        } else {

        }
        return false;
    }

    private boolean hasBomb(){
        for (Card aCard: cards) {
            if(aCard == Card.BOMB){
                return true;
            }
        }

        return false;
    }

    private void trustAgent(){

    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public void distributeCards(List<Card> newCards){
        this.cards = newCards;
    }
}

import card.Card;

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
        return false;
    }

    private boolean hasBomb(){
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

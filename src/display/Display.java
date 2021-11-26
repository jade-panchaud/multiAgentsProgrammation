package display;

import agent.Agent;
import card.Card;
import java.util.List;

//Interface for the IHM system
public interface Display {

    //Show all the agents playing the game
    public void showAgents(List<Agent> agentList);

    //Show how many green cards remained in the game
    public void showGreenRemainedCards(int remainedCards);

    //Show how many green cards has been returned
    public void showGreenReturnedCards(int returnedCards);

    //Show what is the card that has been returned by an Agent
    public void showReturnedCard(Card returnedCard);

    public void showAnnoncement(Agent agent, boolean annonce);

    //Show the choosen agent for the beginning of the turn
    public void showChoosenAgent(Agent choosenAgent);

    //Show the all agents where the agent can pick a card
    public void showMenuChoice(List<Agent> agentList);

    //Show the team of an agent
    public void showAgentTeam(Agent agent);

    //Show the card hand of an agent
    public void showAgentCardHand(Agent agent);

    //Show the winner team
    public void showWinners(Enum team);


}

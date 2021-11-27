package display;

import agent.Agent;
import card.Card;
import java.util.List;

//Interface for the IHM system
public interface Display {

    //Show all the agents playing the game
    void showAgents(List<Agent> agentList);

    //Show how many green cards remained in the game
    void showGreenRemainedCards(int remainedCards);

    //Show how many green cards has been returned
    void showGreenReturnedCards(int returnedCards);

    //Show what is the card that has been returned by an Agent
    void showReturnedCard(Card returnedCard);

    void showAnnoncement(Agent agent, boolean annonce);

    //Show the choosen agent for the beginning of the turn
    void showChoosenAgent(Agent choosenAgent, Agent agentWhoChoose);

    //Show the all agents where the agent can pick a card
    void showMenuChoice(List<Agent> agentList);

    //Show the team of an agent
    void showAgentTeam(Agent agent);

    //Show the card hand of an agent
    void showAgentCardHand(Agent agent);

    //Show the winner team
    void showWinners(Enum team);


}

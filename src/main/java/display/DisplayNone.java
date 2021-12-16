package display;

import agent.Agent;
import card.Card;
import team.Team;

import java.util.List;

public class DisplayNone implements Display {
    @Override
    public void showAgents(List<Agent> agentList) {

    }

    @Override
    public void showGreenRemainedCards(int remainedCards) {

    }

    @Override
    public void showGreenReturnedCards(int returnedCards) {

    }

    @Override
    public void showReturnedCard(Card returnedCard) {

    }

    @Override
    public void showAnnoncement(Agent agent, boolean annonce) {

    }

    @Override
    public void showChoosenAgent(Agent choosenAgent, Agent agentWhoChoose) {

    }

    @Override
    public void showMenuChoice(List<Agent> agentList) {

    }

    @Override
    public void showAgentTeam(Agent agent) {

    }

    @Override
    public void showAgentCardHand(Agent agent) {

    }

    @Override
    public void showWinners(Team team) {

    }

    @Override
    public void newTurn(int numberOfTheTurn) {

    }
}

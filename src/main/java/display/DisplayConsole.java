package display;

import team.Team;
import agent.Agent;
import card.Card;

import java.util.List;

public class DisplayConsole implements Display{

    @Override
    public void showAgents(List<Agent> agentList) {
        for (Agent agent: agentList) {
            System.out.println("");
        }
    }

    @Override
    public void showGreenRemainedCards(int remainedCards) {
        System.out.println("Cartes vertes restantes : " + remainedCards + "\n");
    }

    @Override
    public void showGreenReturnedCards(int returnedCards) {
        System.out.println("Cartes vertes retournées : " + returnedCards + "\n");
    }

    @Override
    public void showReturnedCard(Card returnedCard) {
        System.out.println("Carte retournée : " + returnedCard.getType());
    }

    @Override
    public void showAnnoncement(Agent agent, boolean annonce) {
        System.out.println("L'test.java.agent " + agent.getClass().getName() + " annonce " + annonce + "\n");
    }

    @Override
    public void showChoosenAgent(Agent choosenAgent, Agent agentWhoChoose) {
        System.out.println(agentWhoChoose.getClass().getName() + " a pioché chez " + choosenAgent.getClass().getName());
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
        if(team == Team.BLUE){
            System.out.println("L'équipe bleue a gagné !");
        } else {
            System.out.println("L'équipe rouge a gagné !");
        }
    }

    @Override
    public void newTurn(int numberOfTheTurn) {
        System.out.println("Tour " + numberOfTheTurn + "\n");
    }
}

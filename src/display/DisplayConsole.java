package display;

import agent.Agent;
import card.Card;

import java.util.List;
import java.util.Scanner;

public class DisplayConsole implements Display{

    @Override
    public void showAgents(List<Agent> agentList) {
        for (Agent agent: agentList) {
            System.out.println("");
        }
    }

    @Override
    public void showGreenRemainedCards(int remainedCards) {
        System.out.println("Nombre de cartes vertes restantes : " + remainedCards + "\n");
    }

    @Override
    public void showGreenReturnedCards(int returnedCards) {
        System.out.println("Nombre de cartes vertes retournées : " + returnedCards + "\n");
    }

    @Override
    public void showReturnedCard(Card returnedCard) {
        System.out.println("Carte retournée : ");
    }

    @Override
    public void showAnnoncement(Agent agent, boolean annonce) {
        System.out.println("L'agent " + agent + " annonce " + annonce + "\n");
    }

    @Override
    public void showChoosenAgent(Agent choosenAgent, Agent agentWhoChoose) {
        System.out.println("L'agent " + agentWhoChoose + " a pioché chez " + choosenAgent + "\n");
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
    public void showWinners(Enum team) {

    }
}

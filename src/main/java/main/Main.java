package main;

import agent.Agent;
import agent.AgentFactory;
import display.Display;
import display.DisplayConsole;
import game.Game;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String [ ] args) {
        Display display = new DisplayConsole();

        Agent bill = AgentFactory.getBlueCommonAgent();
        Agent bruno = AgentFactory.getBlueCommonAgent();
        Agent barbara = AgentFactory.getBlueCommonAgent();
        Agent baptiste = AgentFactory.getBlueCommonAgent();
        Agent beatrice = AgentFactory.getBlueCommonAgent();
        Agent bernard = AgentFactory.getBlueCommonAgent();

        Agent robin = AgentFactory.getRedCommonAgent();
        Agent raphael = AgentFactory.getRedCommonAgent();

        bill.setName("bill");
        bruno.setName("bruno");
        barbara.setName("barbara");
        baptiste.setName("baptiste");
        beatrice.setName("beatrice");
        bernard.setName("bernard");
        robin.setName("robin");
        raphael.setName("raphael");

        ArrayList<Agent> players = new ArrayList<>();
        players.add(bill);
        players.add(bruno);
        players.add(barbara);
        players.add(baptiste);
        players.add(beatrice);
        players.add(bernard);
        players.add(robin);
        players.add(raphael);

        for(int i = 0; i < 1000; i++) {
            Game game = new Game(display);


            game.startGame(players);
        }
    }
}

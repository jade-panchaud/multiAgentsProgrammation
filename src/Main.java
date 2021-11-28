import agent.Agent;
import agent.AgentCommon;
import display.Display;
import display.DisplayConsole;
import game.Game;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String [ ] args)
    {
        Display display = new DisplayConsole();

        Game game = new Game(display);

        List<Agent> players = new ArrayList<>();
        players.add(new AgentCommon());
        players.add(new AgentCommon());
        players.add(new AgentCommon());
        players.add(new AgentCommon());
        players.add(new AgentCommon());


        game.startGame(players);
    }
}

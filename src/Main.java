import agent.Agent;
import agent.AgentCommon;
import agent.AgentFactory;
import display.Display;
import display.DisplayConsole;
import game.Game;
import team.Team;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String [ ] args)
    {
        Display display = new DisplayConsole();

        for(int i = 0; i < 1000; i++) {
            Game game = new Game(display);

            List<Agent> players = new ArrayList<>();
            players.add(AgentFactory.getRedCommonAgent());
            players.add(AgentFactory.getRedCommonAgent());
            players.add(AgentFactory.getBlueCommonAgent());
            players.add(AgentFactory.getBlueCommonAgent());
            players.add(AgentFactory.getBlueCommonAgent());

            game.startGame(players);
        }
    }
}

import agent.Agent;
import agent.CopyCat;
import display.Display;
import display.DisplayConsole;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String [ ] args)
    {
        Display display = new DisplayConsole();

        Game game = new Game(display);

        List<Agent> players = new ArrayList<>();
        players.add(new CopyCat());
        players.add(new CopyCat());
        players.add(new CopyCat());
        players.add(new CopyCat());
        players.add(new CopyCat());

        game.startGame(players);
    }
}

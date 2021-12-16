package game;

import agent.Agent;
import agent.AgentFactory;
import display.DisplayNone;
import graphviz.GraphVizFactory;
import org.junit.jupiter.api.Test;
import trust.graph.GraphFactory;

import java.io.IOException;
import java.util.ArrayList;

class GameTest {


    @Test
    void trustGameTest() throws IOException {

        Agent bill = AgentFactory.getBlueTrustAgent();
        Agent bruno = AgentFactory.getBlueTrustAgent();
        Agent barbara = AgentFactory.getBlueTrustAgent();
        Agent baptiste = AgentFactory.getBlueTrustAgent();
        Agent beatrice = AgentFactory.getBlueTrustAgent();
        Agent bernard = AgentFactory.getBlueTrustAgent();

        Agent robin = AgentFactory.getRedTrustAgent();
        Agent raphael = AgentFactory.getRedTrustAgent();

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

        for (Agent agent : players) {
            agent.setFeedBackGraph(GraphFactory.createFeedbackGraph(players));
        }


        for (int i = 0; i < 1; i++) {
            Game game = new Game(new DisplayNone());
            game.startGame(players);
        }

        GraphVizFactory.generateFeedBackSvg(bill);
        GraphVizFactory.generateFeedBackSvg(robin);
        GraphVizFactory.generateReputationSvg(bill);
        GraphVizFactory.generateReputationSvg(robin);
        System.out.println(robin.getReputationGraph().toDot());

    }


}
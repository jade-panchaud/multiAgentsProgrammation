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


        for (int i = 0; i < 1000; i++) {
            Game game = new Game(new DisplayNone());
            game.startGame(players);
        }


        GraphVizFactory.generateReputationSvg(bill);
        GraphVizFactory.generateReputationSvg(robin);
        GraphVizFactory.generateReputationSvg(bruno);
        GraphVizFactory.generateReputationSvg(barbara);
        GraphVizFactory.generateReputationSvg(baptiste);
        GraphVizFactory.generateReputationSvg(beatrice);
        GraphVizFactory.generateReputationSvg(bernard);
        GraphVizFactory.generateReputationSvg(raphael);

        System.out.println(robin.getReputationGraph().toDot());
    }

    @Test
    void trustGameBehaviorRedTest() throws IOException {

        Agent bill = AgentFactory.getBlueTrustAgent();
        Agent bruno = AgentFactory.getBlueTrustAgent();
        Agent barbara = AgentFactory.getBlueTrustAgent();
        Agent baptiste = AgentFactory.getBlueTrustAgent();
        Agent beatrice = AgentFactory.getBlueTrustAgent();
        Agent bernard = AgentFactory.getBlueTrustAgent();

        Agent robin = AgentFactory.getRedTrustHiddenBombAgent();
        Agent raphael = AgentFactory.getRedTrustHiddenBombAgent();

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


        for (int i = 0; i < 1000; i++) {
            Game game = new Game(new DisplayNone());
            game.startGame(players);
        }


        GraphVizFactory.generateReputationSvg(bill);
        GraphVizFactory.generateReputationSvg(robin);
        GraphVizFactory.generateReputationSvg(bruno);
        GraphVizFactory.generateReputationSvg(barbara);
        GraphVizFactory.generateReputationSvg(baptiste);
        GraphVizFactory.generateReputationSvg(beatrice);
        GraphVizFactory.generateReputationSvg(bernard);
        GraphVizFactory.generateReputationSvg(raphael);

        System.out.println(robin.getReputationGraph().toDot());
    }

    @Test
    void trustGameBlueBehaviorTest() throws IOException {

        Agent bill = AgentFactory.getBlueTrustHiddenBombAgent();
        Agent bruno = AgentFactory.getBlueTrustHiddenBombAgent();
        Agent barbara = AgentFactory.getBlueTrustHiddenBombAgent();
        Agent baptiste = AgentFactory.getBlueTrustHiddenBombAgent();
        Agent beatrice = AgentFactory.getBlueTrustHiddenBombAgent();
        Agent bernard = AgentFactory.getBlueTrustHiddenBombAgent();

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


        for (int i = 0; i < 1000; i++) {
            Game game = new Game(new DisplayNone());
            game.startGame(players);
        }


        GraphVizFactory.generateReputationSvg(bill);
        GraphVizFactory.generateReputationSvg(robin);
        GraphVizFactory.generateReputationSvg(bruno);
        GraphVizFactory.generateReputationSvg(barbara);
        GraphVizFactory.generateReputationSvg(baptiste);
        GraphVizFactory.generateReputationSvg(beatrice);
        GraphVizFactory.generateReputationSvg(bernard);
        GraphVizFactory.generateReputationSvg(raphael);

        System.out.println(robin.getReputationGraph().toDot());
    }

    @Test
    void commonGameTest() throws IOException {

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

        for (Agent agent : players) {
            agent.setFeedBackGraph(GraphFactory.createFeedbackGraph(players));
        }


        for (int i = 0; i < 1000; i++) {
            Game game = new Game(new DisplayNone());
            game.startGame(players);
        }

    }

    @Test
    void commonGameBehaviorTest() throws IOException {

        Agent bill = AgentFactory.getBlueHiddenBombAgent();
        Agent bruno = AgentFactory.getBlueHiddenBombAgent();
        Agent barbara = AgentFactory.getBlueHiddenBombAgent();
        Agent baptiste = AgentFactory.getBlueHiddenBombAgent();
        Agent beatrice = AgentFactory.getBlueHiddenBombAgent();
        Agent bernard = AgentFactory.getBlueHiddenBombAgent();

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

        for (Agent agent : players) {
            agent.setFeedBackGraph(GraphFactory.createFeedbackGraph(players));
        }


        for (int i = 0; i < 1000; i++) {
            Game game = new Game(new DisplayNone());
            game.startGame(players);
        }

    }


}
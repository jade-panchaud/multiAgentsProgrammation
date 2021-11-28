package cardHandScore;

import agent.Agent;
import agent.AgentCommon;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreTest {

    @Test
    void compareTo() {

        Agent agent = new AgentCommon();

        Score scoreA = new Score(agent, 10);
        Score scoreB = new Score(agent, 2);

        assertEquals(1, scoreA.compareTo(scoreB));
        assertEquals(-1, scoreB.compareTo(scoreA));
    }

    @Test
    void sort() {
        Agent agent = new AgentCommon();

        Score scoreA = new Score(agent, 10);
        Score scoreB = new Score(agent, 5);
        Score scoreC = new Score(agent, 2);
        Score scoreD = new Score(agent, 1);
        Score scoreE = new Score(agent, 0);


        TreeSet<Score> treeSetUnSort = new TreeSet<>();

        treeSetUnSort.add(scoreD);
        treeSetUnSort.add(scoreC);
        treeSetUnSort.add(scoreA);
        treeSetUnSort.add(scoreE);
        treeSetUnSort.add(scoreB);

        TreeSet<Score> treeSetSort = new TreeSet<>();
        treeSetSort.add(scoreA);
        treeSetSort.add(scoreB);
        treeSetSort.add(scoreC);
        treeSetSort.add(scoreD);
        treeSetSort.add(scoreE);

        assertEquals(treeSetSort, treeSetUnSort);
    }
}
package card_hand_score;

import agent.Agent;
import com.google.common.primitives.Doubles;

public class Score implements Comparable<Score> {

    private Agent agent;
    private double score;

    public Score(Agent agent, double score) {
        this.agent = agent;
        this.score = score;
    }

    @Override
    public int compareTo(Score o) {
        return Doubles.compare(score, o.score);
    }

    public Agent getAgent() {
        return agent;
    }

    public Double getScore() {
        return score;
    }
}

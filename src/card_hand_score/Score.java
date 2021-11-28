package card_hand_score;

import agent.Agent;

public class Score implements Comparable<Score> {

    private Agent agent;
    private Integer score;

    public Score(Agent agent, Integer score) {
        this.agent = agent;
        this.score = score;
    }

    @Override
    public int compareTo(Score o) {
        return score.compareTo(o.score);
    }

    public Agent getAgent() {
        return agent;
    }

    public Integer getScore() {
        return score;
    }
}

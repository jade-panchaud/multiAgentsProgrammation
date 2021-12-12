package agent;

import card_hand_score.BlueScoreCommon;
import card_hand_score.RedScoreCommon;
import team.Team;

public class AgentFactory {
    public static Agent getBlueCommonAgent(){
       return new AgentCommon(new BlueScoreCommon(), Team.BLUE);
    }

    public static Agent getRedCommonAgent(){
        return new AgentCommon(new RedScoreCommon(), Team.RED);
    }
}

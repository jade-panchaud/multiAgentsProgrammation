package agent;

import card_hand_score.BlueScoreCommon;
import card_hand_score.RedScoreCommon;
import comportment.CommonComportment;
import comportment.hide_comportment.BlueHiddenComportment;
import comportment.hide_comportment.RedHiddenComportment;
import team.Team;

public class AgentFactory {
    public static Agent getBlueCommonAgent() {
        return new AgentCommon(new BlueScoreCommon(), Team.BLUE, new CommonComportment());
    }

    public static Agent getRedCommonAgent() {
        return new AgentCommon(new RedScoreCommon(), Team.RED, new CommonComportment());
    }

    public static Agent getBlueHiddenBombAgent() {
        return new AgentCommon(new BlueScoreCommon(), Team.BLUE, new BlueHiddenComportment());
    }

    public static Agent getRedHiddenBombAgent() {
        return new AgentCommon(new RedScoreCommon(), Team.RED, new RedHiddenComportment());
    }
}

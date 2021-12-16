package agent;

import card_hand_score.BlueScoreCommon;
import card_hand_score.RedScoreCommon;
import comportment.CommonComportment;
import comportment.hide_comportment.BlueHiddenComportment;
import comportment.hide_comportment.RedHiddenComportment;
import dot.DotNodeFactory;
import team.Team;
import trust.algorithms.EigenTrust;

public class AgentFactory {
    public static Agent getBlueCommonAgent() {
        return new AgentCommon(new BlueScoreCommon(), Team.BLUE, new CommonComportment(), DotNodeFactory.getBlueDotNode());
    }

    public static Agent getRedCommonAgent() {
        return new AgentCommon(new RedScoreCommon(), Team.RED, new CommonComportment(), DotNodeFactory.getRedDotNode());
    }

    public static Agent getBlueHiddenBombAgent() {
        return new AgentCommon(new BlueScoreCommon(), Team.BLUE, new BlueHiddenComportment(), DotNodeFactory.getBlueDotNode());
    }

    public static Agent getRedHiddenBombAgent() {
        return new AgentCommon(new RedScoreCommon(), Team.RED, new RedHiddenComportment(), DotNodeFactory.getRedDotNode());
    }

    public static Agent getRedTrustAgent() {
        return new TrustAgent(
                new RedScoreCommon(),
                Team.RED,
                new CommonComportment(),
                DotNodeFactory.getRedDotNode(),
                new EigenTrust(0.4));
    }

    public static Agent getRedTrustHiddenBombAgent() {
        return new TrustAgent(
                new RedScoreCommon(),
                Team.RED,
                new RedHiddenComportment(),
                DotNodeFactory.getRedDotNode(),
                new EigenTrust(0.4));
    }

    public static Agent getBlueTrustAgent() {
        return new TrustAgent(
                new BlueScoreCommon(),
                Team.BLUE,
                new CommonComportment(),
                DotNodeFactory.getBlueDotNode(),
                new EigenTrust(0.4));
    }

    public static Agent getBlueTrustHiddenBombAgent() {
        return new TrustAgent(
                new BlueScoreCommon(),
                Team.BLUE,
                new BlueHiddenComportment(),
                DotNodeFactory.getBlueDotNode(),
                new EigenTrust(0.4));
    }

}

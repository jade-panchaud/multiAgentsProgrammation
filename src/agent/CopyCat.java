package agent;

import java.util.List;

/**
 * A CopyCat has the same behavior with the Agent that
 * he had with him.
 */
public class CopyCat implements Agent{
    @Override
    public Agent choseAgent(List<Agent> agents) {
        return null;
    }

    @Override
    public void confidenceAndReputationCalcul() {

    }

    @Override
    public boolean makeAnAnnonce() {
        return false;
    }
}

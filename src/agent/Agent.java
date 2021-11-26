package agent;

import java.util.List;

public interface Agent {
    //Chose an agent to pick a card, in order to make
    //win his team.
    public Agent choseAgent(List<Agent> agents);

    //Every new turn, each agent calcul the confidence he has
    //in each other agent, and also their reputation in order
    //to make the decision to pick a card from an Agent rather
    //than another one.
    public void confidenceAndReputationCalcul();

    //In function of his cards in his hands and also his strategy
    //and his team, an Agent is going to make an annonce at the
    //beginning of a new turn.
    //First step is to have a "yes/no" annonce. Yes means other
    //agents can take a card from us, no means their rather not
    //because they don't have any green card or has a bomb card
    //maybe.
    //In a second step, it's gonna be number from 0 to x (the
    //number of cards in hands), to indicate the number of
    //green cards in hands.
    public boolean makeAnAnnonce();
}

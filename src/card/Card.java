package card;

import java.util.Observable;

public abstract class Card extends Observable {

    public Card pick() {
        return this;
    }
}

package card;

import javafx.beans.Observable;

public abstract class Card implements Observable {

    public Card pick() {
        return this;
    }
}

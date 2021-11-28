package card;

public class Card {
    CardType type;
    private CardListener listener;

    public Card(CardType type, CardListener listener) {
        this.type = type;
        this.listener = listener;
    }

    /**
     * The card is returned by an Agent.
     * In function of the type of the Card,
     * it does something different.
     * @return the card
     */
    public Card pick() {
        if (this.type == CardType.GREEN) {
            listener.greenReturned(this);
        } else if (this.type == CardType.BOMB) {
            listener.bombReturned(this);
        } else {
            listener.yellowReturned(this);
        }

        return this;
    }

    public CardType getType() {
        return type;
    }
}

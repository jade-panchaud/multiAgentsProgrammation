package card;

public abstract class Card {
    CardType type;
    private CardListener listener;

    public Card pick() {
        if(this.type == CardType.GREEN){
            listener.greenReturned(this);
        } else if(this.type == CardType.BOMB){
            listener.bombReturned(this);
        } else {
            listener.yellowReturned(this);
        }

        return this;
    }
}

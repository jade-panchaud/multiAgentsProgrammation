package card;

public interface CardListener {
    void greenReturned(Card card);
    void yellowReturned(Card card);
    void bombReturned(Card card);
}

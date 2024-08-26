package org.example.game.board.card;

public class Card {
    private final Suit suit;
    private final int point;
    private final CardIdentifier cid;

    public Card(Suit suit, int point, CardIdentifier cid) {
        this.suit = suit;
        this.point = point;
        this.cid = cid;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getPoint() {
        return point;
    }

    public CardIdentifier getCid() {
        return cid;
    }

    @Override
    public String toString() {
        return "Card(" + suit + ", " + point +  ", " + this.cid.getName() + ")";
    }

    public String toStringInLine(){
        return "[" + suit + " " + point + " " + this.cid.getName() + "]";
    }
}

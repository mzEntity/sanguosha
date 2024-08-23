package org.example.game.board.card;

public class Card {
    public Suit suit;
    public int point;
    public CardIdentifier cid;

    public Card(Suit suit, int point, CardIdentifier cid) {
        this.suit = suit;
        this.point = point;
        this.cid = cid;
    }


    @Override
    public String toString() {
        return "Card(" + suit + ", " + point +  ", " + this.cid.getName() + ")";
    }
}

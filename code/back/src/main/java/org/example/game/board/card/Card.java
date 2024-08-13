package org.example.game.board.card;

public class Card {
    public Suit suit;
    public int point;
    public String id;

    public Card(Suit suit, int point, String id) {
        this.suit = suit;
        this.point = point;
        this.id = id;
    }

    @Override
    public String toString() {
        String name = CardDict.getCardName(this.id);
        return "Card(" + suit + ", " + point +  ", " + name + ")";
    }
}

package org.example.game.board.card;

public enum Suit{
    Heart("heart", Color.RED),
    Spade("spade", Color.BLACK),
    Diamond("diamond", Color.RED),
    Club("club", Color.BLACK),
    None("none", Color.NONE),
    Red_None("redNone", Color.RED),
    Black_None("blackNone", Color.BLACK);


    private String name;
    private Color color;

    Suit(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public static Suit getSuit(String name){
        return switch (name) {
            case "heart", "H" -> Heart;
            case "diamond", "D" -> Diamond;
            case "club", "C" -> Club;
            case "spade", "S" -> Spade;
            default -> None;
        };
    }

    public Color getColor() {
        return this.color;
    }

    public Suit removeColor(){
        return switch (this) {
            case Heart, Diamond, Red_None -> Red_None;
            case Club, Spade, Black_None -> Black_None;
            default -> None;
        };
    }

    @Override
    public String toString() {
        return name;
    }


}

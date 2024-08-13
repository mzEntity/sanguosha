package org.example.game.board.card;

public enum Color {
    RED("Red"),
    BLACK("Black"),
    NONE("None");
    private String name;

    Color(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

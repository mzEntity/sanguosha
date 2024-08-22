package org.example;

import org.example.game.Game;
import org.example.game.GameBuilder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final int ROLE_NUM = 8;

    public static boolean SGS_DEBUG = true;
    public static void main(String[] args) {
        Game game = new GameBuilder().buildGame(ROLE_NUM);
        game.start();
    }
}
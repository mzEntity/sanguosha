package game;

import org.example.game.Game;
import org.example.game.GameBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void gameTest1(){
        int roleNum = 3;

        Game game = new GameBuilder().buildGame(roleNum);
        Assertions.assertTrue(game.start());
    }
}

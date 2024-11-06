package org.example.game.logic.action.role;

import org.example.Main;
import org.example.game.board.card.deck.Deck;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class AskToSelectFromDeckProcess {
    private final Role subject;
    private final Deck targetDeck;
    private final int count;
    private Deck result;

    public AskToSelectFromDeckProcess(Role subject, Deck targetDeck, int count) {
        this.subject = subject;
        this.targetDeck = targetDeck;
        this.count = count;
        this.result = null;
    }

    public void process(){
        if(this.targetDeck.size() < this.count){
            System.err.println("牌不够选择！\n");
            return;
        }
        if(!Main.SGS_DEBUG){
            //TODO: for user
            return;
        } else {
            this.result = this.targetDeck.selectSomeAsDeck(0, count);
        }
    }

    public Deck getResult() {
        return result;
    }
}

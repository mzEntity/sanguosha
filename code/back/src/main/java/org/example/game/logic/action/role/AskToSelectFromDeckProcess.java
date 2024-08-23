package org.example.game.logic.action.role;

import org.example.game.board.card.deck.Deck;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class AskToSelectFromDeckProcess {
    private Role subject;
    private Deck target;
    private int count;
    private Deck result;

    public AskToSelectFromDeckProcess(Role subject, Deck target, int count) {
        this.subject = subject;
        this.target = target;
        this.count = count;
        this.result = null;
    }

    public void process(){
        if(this.target.size() < this.count){
            System.err.println("牌不够选择！\n");
        }
        this.result = this.target.selectSomeAsDeck(0, count);
    }

    public Deck getResult() {
        return result;
    }
}

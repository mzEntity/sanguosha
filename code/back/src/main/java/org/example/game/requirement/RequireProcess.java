package org.example.game.requirement;

import org.example.game.board.card.deck.Deck;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/22
 */
public class RequireProcess {
    private CardRequirement cardRequirement;
    private Deck result;

    public RequireProcess(CardRequirement cardRequirement) {
        this.cardRequirement = cardRequirement;
        this.result = null;
    }

    public void decide(){
        return;
    }

    public Deck getResult(){
        return result;
    }
}

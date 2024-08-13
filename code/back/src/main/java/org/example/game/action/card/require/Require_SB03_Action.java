package org.example.game.action.card.require;

import org.example.game.action.Action;
import org.example.game.board.card.Card;
import org.example.game.board.card.Deck;
import org.example.game.board.card.logic.LogicCard;
import org.example.game.role.Role;
import org.example.log.Logger;

import java.util.ArrayList;
import java.util.List;

public class Require_SB03_Action extends Action {
    private LogicCard requireResult;

    public Require_SB03_Action(Role subject) {
        super("Require_SB03_Action", subject);
        this.requireResult = null;
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("Require_SB03_Action:%s请使用或打出一张【桃】\n", this.subject.code);
        Deck cardDeck = this.subject.playerArea.handArea.cards.containCard("SB03");
        this.requireResult = null;
        if(cardDeck != null){
            Card card = cardDeck.getCard(0);
            this.requireResult = new LogicCard(cardDeck, card);
        }
    }

    public LogicCard getRequireResult() {
        return this.requireResult;
    }
}

package org.example.game.logic.action.card;

import org.example.game.board.card.deck.Deck;
import org.example.game.logic.Action;
import org.example.game.role.Role;
import org.example.log.Logger;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class MoveToArmorAreaAction extends Action{
    private final Role subject;
    private final Deck equipment;

    public MoveToArmorAreaAction(Role subject, Deck equipment) {
        this.subject = subject;
        this.equipment = equipment;
    }

    @Override
    protected void mainLogic(Action from) {
        if(equipment.size() != 1){
            System.err.printf("必须一次性将1张装备置入装备区，而不是%s张\n", equipment.size());
        }
        Deck armorAreaDeck = this.subject.getPlayerArea().getArmorArea().getDeck();
        if(!armorAreaDeck.isEmpty()){
            // 替换装备
            Logger.printf("%s失去了装备%s\n", this.subject, armorAreaDeck);
            new MoveToDiscardAreaAction(armorAreaDeck).process(this);
        }
        this.equipment.moveAllToBack(armorAreaDeck);
    }
}

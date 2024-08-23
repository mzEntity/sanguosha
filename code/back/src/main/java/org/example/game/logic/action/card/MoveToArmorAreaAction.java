package org.example.game.logic.action.card;

import org.example.game.board.card.deck.Deck;
import org.example.game.logic.Action;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class MoveToArmorAreaAction extends Action{
    private Role subject;
    private Deck equipment;

    public MoveToArmorAreaAction(Role subject, Deck equipment) {
        this.subject = subject;
        this.equipment = equipment;
    }

    @Override
    protected void mainLogic(Action from) {
        if(equipment.size() != 1){
            System.err.printf("必须一次性将1张装备置入装备区，而不是%s张\n", equipment.size());
        }
        Deck target = this.subject.getPlayerArea().getArmorArea().getDeck();
        if(!target.isEmpty()){
            new MoveToDiscardAreaAction(target).process(this);
        }
        this.equipment.moveAllToBack(target);
    }
}

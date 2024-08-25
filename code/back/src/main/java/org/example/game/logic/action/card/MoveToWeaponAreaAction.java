package org.example.game.logic.action.card;

import org.example.game.board.card.deck.Deck;
import org.example.game.logic.Action;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class MoveToWeaponAreaAction extends Action {
    private final Role subject;
    private final Deck weapon;

    public MoveToWeaponAreaAction(Role subject, Deck weapon) {
        this.subject = subject;
        this.weapon = weapon;
    }

    @Override
    protected void mainLogic(Action from) {
        if(weapon.size() != 1){
            System.err.printf("必须一次性将1张装备置入装备区，而不是%s张\n", weapon.size());
        }
        Deck targetDeck = this.subject.getPlayerArea().getWeaponArea().getDeck();
        if(!targetDeck.isEmpty()){
            // 替换武器
            new MoveToDiscardAreaAction(targetDeck).process(this);
        }
        this.weapon.moveAllToBack(targetDeck);
    }
}

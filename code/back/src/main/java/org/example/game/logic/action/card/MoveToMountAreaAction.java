package org.example.game.logic.action.card;

import org.example.game.board.card.concrete.equipment.MountCard;
import org.example.game.board.card.concrete.equipment.mount.MountType;
import org.example.game.board.card.deck.Deck;
import org.example.game.logic.Action;
import org.example.game.role.Role;
import org.example.view.Logger;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class MoveToMountAreaAction extends Action {
    private final Role subject;
    private final Deck mountDeck;

    public MoveToMountAreaAction(Role subject, Deck mountDeck) {
        this.subject = subject;
        this.mountDeck = mountDeck;
    }

    @Override
    protected void mainLogic(Action from) {
        if(mountDeck.size() != 1){
            System.err.printf("必须一次性将1张装备置入装备区，而不是%s张\n", mountDeck.size());
        }
        Logger.log("%s装备了%s\n", this.subject, this.mountDeck.toStringInLine());
        MountCard card = (MountCard) mountDeck.getCard(0);
        Deck targetDeck = null;
        if(card.getMountType() == MountType.March){
            targetDeck = this.subject.getPlayerArea().getMarchMountArea().getDeck();
        } else {
            targetDeck = this.subject.getPlayerArea().getRetreatMountArea().getDeck();
        }
        if(!targetDeck.isEmpty()){
            // 替换坐骑
            new MoveToDiscardAreaAction(targetDeck).process(this);
        }
        this.mountDeck.moveAllToBack(targetDeck);
    }
}

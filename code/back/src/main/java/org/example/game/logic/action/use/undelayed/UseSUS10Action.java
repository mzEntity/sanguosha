package org.example.game.logic.action.use.undelayed;

import org.example.game.board.card.deck.Deck;
import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.logic.action.play.PlaySB01Action;
import org.example.game.logic.action.require.RequirePlaySB01Action;
import org.example.game.logic.action.require.RequireUseSB01Action;
import org.example.game.logic.action.role.GetCardFromPlayerAreaAction;
import org.example.game.logic.action.role.InjurySettleAction;
import org.example.game.logic.action.use.PollAndUseSUS09Process;
import org.example.game.logic.action.use.UseSB01Action;
import org.example.game.role.Role;
import org.example.log.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/24
 */
public class UseSUS10Action extends Action {
    private final Role subject;
    private final List<List<Role>> targets;
    private final LogicCard logicCard;

    public UseSUS10Action(Role subject, List<List<Role>> targets, LogicCard logicCard) {
        super();
        this.subject = subject;
        this.targets = targets;
        this.logicCard = logicCard;
    }

    @Override
    protected void mainLogic(Action from) {
        new MoveToDiscardAreaAction(this.logicCard.getDeck()).process(this);
        for(List<Role> targetPair : targets) {
            Role user = targetPair.get(0);
            Role target = targetPair.get(1);
            Logger.printf("[借刀杀人]: %s指定%s对%s使用一张杀\n", this.subject, user, target);
            PollAndUseSUS09Process a = new PollAndUseSUS09Process(this, this.logicCard);
            a.process();
            if (a.getResult() != null) {
                continue;
            }
            RequireUseSB01Action r = new RequireUseSB01Action(user, target);
            r.process(this);
            if (r.getResult() != null) {
                new UseSB01Action(user, new ArrayList<>(Collections.singletonList(target)), r.getResult()).process(this);
            } else {
                Deck d = user.getPlayerArea().getWeaponArea().getDeck();
                new GetCardFromPlayerAreaAction(this.subject, user, d).process(this);
            }
        }
    }
}

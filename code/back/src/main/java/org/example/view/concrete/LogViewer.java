package org.example.view.concrete;

import org.example.game.logic.action.card.DiscardAction;
import org.example.game.logic.action.card.GetCardFromDrawAreaAction;
import org.example.game.logic.action.divination.SDS01WorkAction;
import org.example.game.logic.action.divination.SDS02WorkAction;
import org.example.game.logic.action.global.GameOverAction;
import org.example.game.logic.action.play.PlaySB01Action;
import org.example.game.logic.action.play.PlaySB02Action;
import org.example.game.logic.action.role.*;
import org.example.game.logic.action.use.*;
import org.example.game.logic.action.use.delayed.UseSDS01Action;
import org.example.game.logic.action.use.delayed.UseSDS02Action;
import org.example.game.logic.action.use.undelayed.*;
import org.example.game.role.Role;
import org.example.view.Viewer;

import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/25
 */
public class LogViewer extends Viewer {
    @Override
    public void display(GetCardFromDrawAreaAction getCardFromDrawAreaAction) {
        System.out.printf("%s从牌堆中获得%s\n", getCardFromDrawAreaAction.getSubject(), getCardFromDrawAreaAction.getDeck().toStringInLine());
    }

    @Override
    public void display(DiscardAction discardAction) {
        System.out.printf("%s弃置%s\n", discardAction.getSubject(), discardAction.getDiscard().toStringInLine());
    }

    @Override
    public void display(SDS01WorkAction sds01WorkAction) {
        if(sds01WorkAction.getDivination() == null){
            System.out.printf("%s的%s失效\n", sds01WorkAction.getSubject(), sds01WorkAction.getTarget().toStringInLine());
        } else {
            System.out.printf("%s%s的判定结果为%s\n", sds01WorkAction.getSubject(), sds01WorkAction.getTarget().toStringInLine(), sds01WorkAction.getDivination().getResult().toStringInLine());
        }
    }

    @Override
    public void display(SDS02WorkAction sds02WorkAction) {
        if(sds02WorkAction.getDivination() == null){
            System.out.printf("%s的%s失效\n", sds02WorkAction.getSubject(), sds02WorkAction.getTarget().toStringInLine());
        } else {
            System.out.printf("%s%s的判定结果为%s\n", sds02WorkAction.getSubject(), sds02WorkAction.getTarget().toStringInLine(), sds02WorkAction.getDivination().getResult().toStringInLine());
        }
    }

    @Override
    public void display(GameOverAction gameOverAction) {
        System.out.printf("%s\n", gameOverAction.getMsg());
    }

    @Override
    public void display(PlaySB01Action playSB01Action) {
        System.out.printf("%s打出%s\n", playSB01Action.getSubject(), playSB01Action.getTargetSB01().toStringInLine());
    }

    @Override
    public void display(PlaySB02Action playSB02Action) {
        System.out.printf("%s打出%s\n", playSB02Action.getSubject(), playSB02Action.getTargetSB02().toStringInLine());
    }

    @Override
    public void display(DiscardFromPlayerAreaAction discardFromPlayerAreaAction) {
        System.out.printf("%s弃置%s的%s\n", discardFromPlayerAreaAction.getBy(), discardFromPlayerAreaAction.getTo(), discardFromPlayerAreaAction.getDeck().toStringInLine());
    }

    @Override
    public void display(GainHealthAction gainHealthAction) {
        System.out.printf("%s让%s回复%d点体力值，体力值为%d\n", gainHealthAction.getBy(), gainHealthAction.getTo(), gainHealthAction.getCount(), gainHealthAction.getHpBefore() + gainHealthAction.getCount());
    }

    @Override
    public void display(GetCardFromPlayerAreaAction getCardFromPlayerAreaAction) {
        System.out.printf("%s获得%s的%s\n", getCardFromPlayerAreaAction.getBy(), getCardFromPlayerAreaAction.getTo(), getCardFromPlayerAreaAction.getDeck().toStringInLine());
    }

    @Override
    public void display(InjurySettleAction injurySettleAction) {
        if(injurySettleAction.getBy() == null){
            System.out.printf("%s受到无来源的%d点伤害，体力值为%d\n", injurySettleAction.getTo(), injurySettleAction.getCount(), injurySettleAction.getHpBefore() - injurySettleAction.getCount());
        } else {
            System.out.printf("%s对%s造成%d点伤害，体力值为%d\n", injurySettleAction.getBy(), injurySettleAction.getTo(), injurySettleAction.getCount(), injurySettleAction.getHpBefore() - injurySettleAction.getCount());
        }
    }

    @Override
    public void display(UseSB01Action useSB01Action) {
        System.out.printf("%s使用%s，指定%s为目标\n", useSB01Action.getSubject(), useSB01Action.getLogicCard().toStringInLine(), useSB01Action.getTargets());
    }

    @Override
    public void display(UseSB02Action useSB02Action) {
        System.out.printf("%s使用%s\n", useSB02Action.getSubject(), useSB02Action.getLogicCard().toStringInLine());
    }

    @Override
    public void display(UseSB03Action useSB03Action) {
        System.out.printf("%s使用%s，指定%s为目标\n", useSB03Action.getSubject(), useSB03Action.getLogicCard().toStringInLine(), useSB03Action.getTargets());
    }

    @Override
    public void display(UseSUS01Action useSUS01Action) {
        System.out.printf("%s使用%s，指定%s为目标\n", useSUS01Action.getSubject(), useSUS01Action.getLogicCard().toStringInLine(), useSUS01Action.getTargets());
    }

    @Override
    public void display(UseSUS02Action useSUS02Action) {
        System.out.printf("%s使用%s，指定%s为目标\n", useSUS02Action.getSubject(), useSUS02Action.getLogicCard().toStringInLine(), useSUS02Action.getTargets());
    }

    @Override
    public void display(UseSUS03Action useSUS03Action) {
        System.out.printf("%s使用%s，指定%s为目标\n", useSUS03Action.getSubject(), useSUS03Action.getLogicCard().toStringInLine(), useSUS03Action.getTargets());
    }

    @Override
    public void display(UseSUS04Action useSUS04Action) {
        System.out.printf("%s使用%s，指定%s为目标\n", useSUS04Action.getSubject(), useSUS04Action.getLogicCard().toStringInLine(), useSUS04Action.getTargets());
    }

    @Override
    public void display(UseSUS05Action useSUS05Action) {
        System.out.printf("%s使用%s，指定%s为目标\n", useSUS05Action.getSubject(), useSUS05Action.getLogicCard().toStringInLine(), useSUS05Action.getTargets());
    }

    @Override
    public void display(UseSUS06Action useSUS06Action) {
        System.out.printf("%s使用%s，指定%s为目标\n", useSUS06Action.getSubject(), useSUS06Action.getLogicCard().toStringInLine(), useSUS06Action.getTargets());
    }

    @Override
    public void display(UseSUS07Action useSUS07Action) {
        System.out.printf("%s使用%s，指定%s为目标\n", useSUS07Action.getSubject(), useSUS07Action.getLogicCard().toStringInLine(), useSUS07Action.getTargets());
    }

    @Override
    public void display(UseSUS08Action useSUS08Action) {
        System.out.printf("%s使用%s，指定%s为目标\n", useSUS08Action.getSubject(), useSUS08Action.getLogicCard().toStringInLine(), useSUS08Action.getTargets());
    }

    @Override
    public void display(UseSUS09Action useSUS09Action) {
        System.out.printf("%s使用%s，用于抵消%s的效果\n", useSUS09Action.getSubject(), useSUS09Action.getLogicCard().toStringInLine(), useSUS09Action.getTargetSkill().toStringInLine());
    }

    @Override
    public void display(UseSUS10Action useSUS10Action) {
        System.out.printf("%s使用%s\n", useSUS10Action.getSubject(), useSUS10Action.getLogicCard().toStringInLine());
        for(List<Role> targets: useSUS10Action.getTargets()){
            System.out.printf("指定%s对%s使用一张杀\n", targets.get(0), targets.get(1));
        }
    }

    @Override
    public void display(UseSDS01Action sds01Action) {
        System.out.printf("%s使用%s，指定%s为目标\n", sds01Action.getSubject(), sds01Action.getLogicCard().toStringInLine(), sds01Action.getTarget());
    }

    @Override
    public void display(UseSDS02Action sds02Action) {
        System.out.printf("%s使用%s，指定%s为目标\n", sds02Action.getSubject(), sds02Action.getLogicCard().toStringInLine(), sds02Action.getTarget());
    }

    @Override
    public void display(UseWeaponAction useWeaponAction) {
        System.out.printf("%s装备了%s\n", useWeaponAction.getSubject(), useWeaponAction.getTarget().toStringInLine());
    }

    @Override
    public void display(UseArmorAction useArmorAction) {
        System.out.printf("%s装备了%s\n", useArmorAction.getSubject(), useArmorAction.getTarget().toStringInLine());
    }

    @Override
    public void display(UseMountAction useMountAction) {
        System.out.printf("%s装备了%s\n", useMountAction.getSubject(), useMountAction.getTarget().toStringInLine());
    }

    @Override
    public void display(DeadAction deadAction) {
        System.out.printf("%s死亡\n", deadAction.getSubject());
    }
}

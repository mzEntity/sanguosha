package org.example.game.logic.action.stage;


import org.example.game.board.card.Card;
import org.example.game.board.card.deck.Deck;
import org.example.game.board.card.deck.LogicCard;
import org.example.game.filter.FilterTable;
import org.example.game.logic.action.use.UseSB01Action;
import org.example.game.logic.action.use.UseWeaponAction;
import org.example.game.requirement.subrequirement.IsSpecificCardRequirement;
import org.example.game.requirement.subrequirement.IsWeaponCardRequirement;
import org.example.game.role.Role;
import org.example.game.logic.Action;
import org.example.log.Logger;

import java.util.List;


public class PunchingStage extends Action {
    private Role subject;
    public PunchingStage(Role subject) {
        super();
        this.subject = subject;
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("PunchingStage:出牌阶段\n");
        tryToCarryWeapon();
        tryToSB01();
//        tryToSUS06(handDeck);
//        tryToSUS05(handDeck);
//        tryToSUS04(handDeck);
//        tryToSUS03(handDeck);
//        tryToSUS07(handDeck);
//        tryToSB03(handDeck);
//        tryToSUS01(handDeck);
//        tryToSUS02(handDeck);
//        tryToSUS08(handDeck);
    }

    private void tryToSB01(){
        Deck handDeck = this.subject.getHandDeck();
        Deck cardDeck = handDeck.getCardDeckIfContain(new IsSpecificCardRequirement("SB01"));
        if(cardDeck != null){
            List<Role> allTargets = FilterTable.getAvailableTargets(this.subject, "SB01");
            Logger.printf("%s可以杀到的目标为：%s\n", this.subject.code, allTargets);
            if(allTargets.isEmpty()){
               Logger.printf("[杀]: 没有可用的目标\n");
               return;
            }
            List<Role> targets = allTargets.subList(0, 1);
            Logger.printf("[杀]: %s对%s出杀\n", this.subject.code, targets.get(0).code);

            new UseSB01Action(this.subject, targets, new LogicCard(cardDeck, cardDeck.transform("SB01"))).process(this);
        }
    }

    private void tryToCarryWeapon(){
        Deck handDeck = this.subject.getHandDeck();
        Deck cardDeck = handDeck.getCardDeckIfContain(new IsWeaponCardRequirement());
        if(cardDeck != null){
            Logger.printf("%s装备了%s\n", this.subject.code, cardDeck);
            new UseWeaponAction(this.subject, cardDeck).process(this);
        }
    }
//
//    private void tryToSB03(Deck handDeck){
//        Deck cardDeck = handDeck.containCard("SB03");
//        if(cardDeck != null && this.subject.getHero().condition.isHurt()){
//            Logger.printf("受伤且有桃\n");
//            Card card = cardDeck.getCard(0);
//            List<Role> targets = new ArrayList<>();
//            targets.add(this.subject);
//            new Use_SB03_Action(this.subject, new LogicCard(cardDeck, card), targets).process(this);
//        } else {
//            Logger.printf("没有桃或没受伤\n");
//        }
//    }
//
//    private void tryToSUS01(Deck handDeck){
//        Deck cardDeck = handDeck.containCard("SUS01");
//        if(cardDeck != null){
//            Logger.printf("有桃园结义，使用\n");
//            Card card = cardDeck.getCard(0);
//            new Use_SUS01_Action(this.subject, new LogicCard(cardDeck, card)).process(this);
//        } else {
//            Logger.printf("没有桃园结义，过\n");
//        }
//    }
//
//    private void tryToSUS02(Deck handDeck){
//        Deck cardDeck = handDeck.containCard("SUS02");
//        if(cardDeck != null){
//            Logger.printf("有万箭齐发，使用\n");
//            Card card = cardDeck.getCard(0);
//            new Use_SUS02_Action(this.subject, new LogicCard(cardDeck, card)).process(this);
//        } else {
//            Logger.printf("没有万箭齐发，过\n");
//        }
//    }
//
//    private void tryToSUS03(Deck handDeck){
//        Deck cardDeck = handDeck.containCard("SUS03");
//        if(cardDeck != null){
//            Logger.printf("有决斗，对下家出决斗\n");
//            Card card = cardDeck.getCard(0);
//            List<Role> targets = new ArrayList<>();
//            targets.add(this.subject.right);
//            new Use_SUS03_Action(this.subject, new LogicCard(cardDeck, card), targets).process(this);
//        } else {
//            Logger.printf("没有决斗，过\n");
//        }
//    }
//
//    private void tryToSUS04(Deck handDeck){
//        Deck cardDeck = handDeck.containCard("SUS04");
//        if(cardDeck != null){
//            Logger.printf("有顺手牵羊，对下家出顺手牵羊\n");
//            Card card = cardDeck.getCard(0);
//            List<Role> targets = new ArrayList<>();
//            targets.add(this.subject.right);
//            new Use_SUS04_Action(this.subject, new LogicCard(cardDeck, card), targets).process(this);
//        } else {
//            Logger.printf("没有顺手牵羊，过\n");
//        }
//    }
//
//    private void tryToSUS05(Deck handDeck){
//        Deck cardDeck = handDeck.containCard("SUS05");
//        if(cardDeck != null){
//            Logger.printf("有五谷丰登，使用\n");
//            Card card = cardDeck.getCard(0);
//            new Use_SUS05_Action(this.subject, new LogicCard(cardDeck, card)).process(this);
//        } else {
//            Logger.printf("没有五谷丰登，过\n");
//        }
//    }
//
//    private void tryToSUS06(Deck handDeck){
//        Deck cardDeck = handDeck.containCard("SUS06");
//        if(cardDeck != null){
//            Logger.printf("有过河拆桥，对下家出过河拆桥\n");
//            Card card = cardDeck.getCard(0);
//            List<Role> targets = new ArrayList<>();
//            targets.add(this.subject.right);
//            new Use_SUS06_Action(this.subject, new LogicCard(cardDeck, card), targets).process(this);
//        } else {
//            Logger.printf("没有过河拆桥，过\n");
//        }
//    }
//
//    private void tryToSUS07(Deck handDeck){
//        Deck cardDeck = handDeck.containCard("SUS07");
//        if(cardDeck != null){
//            Logger.printf("有无中生有，使用无中生有\n");
//            Card card = cardDeck.getCard(0);
//            List<Role> targets = new ArrayList<>();
//            targets.add(this.subject);
//            new Use_SUS07_Action(this.subject, new LogicCard(cardDeck, card), targets).process(this);
//        } else {
//            Logger.printf("没有无中生有，过\n");
//        }
//    }
//
//    private void tryToSUS08(Deck handDeck){
//        Deck cardDeck = handDeck.containCard("SUS08");
//        if(cardDeck != null){
//            Logger.printf("有南蛮入侵，使用\n");
//            Card card = cardDeck.getCard(0);
//            new Use_SUS08_Action(this.subject, new LogicCard(cardDeck, card)).process(this);
//        } else {
//            Logger.printf("无万箭齐发，过\n");
//        }
//    }
}

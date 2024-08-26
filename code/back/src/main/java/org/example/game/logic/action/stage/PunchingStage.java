package org.example.game.logic.action.stage;


import org.example.game.board.card.Card;
import org.example.game.board.card.CardIdentifier;
import org.example.game.board.card.deck.Deck;
import org.example.game.board.card.deck.LogicCard;
import org.example.game.filter.FilterTable;
import org.example.game.logic.action.use.*;
import org.example.game.logic.action.use.delayed.UseSDS01Action;
import org.example.game.logic.action.use.delayed.UseSDS02Action;
import org.example.game.logic.action.use.undelayed.*;
import org.example.game.requirement.subrequirement.IsArmorCardRequirement;
import org.example.game.requirement.subrequirement.IsMountCardRequirement;
import org.example.game.requirement.subrequirement.IsSpecificCardRequirement;
import org.example.game.requirement.subrequirement.IsWeaponCardRequirement;
import org.example.game.role.Role;
import org.example.game.logic.Action;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PunchingStage extends RoleStage {
    public PunchingStage(Role subject) {
        super(subject);
    }

    @Override
    protected void mainLogic(Action from) {
        tryToSUS07();
        tryToSB03();
        tryToSUS10();
        tryToSUS05();
        tryToSUS06();
        tryToSUS04();
        tryToCarryWeapon();
        tryToWearArmor();
        tryToMount();
        tryToSUS01();
        tryToSUS02();
        tryToSUS03();
        tryToSUS08();
        tryToSB01();
        tryToSDS01();
        tryToSDS02();
    }

    private void tryToSB01(){
        Deck handDeck = this.subject.getHandDeck();
        Deck cardDeck = handDeck.getCardDeckIfContain(new IsSpecificCardRequirement("SB01"));
        if(cardDeck != null){
            List<Role> allTargets = FilterTable.getAvailableTargets(this.subject, "SB01");
            if(allTargets.isEmpty()){
               return;
            }
            List<Role> targets = allTargets.subList(0, 1);
            new UseSB01Action(this.subject, targets, new LogicCard(cardDeck, CardIdentifier.SB01)).process(this);
        }
    }

    private void tryToSB03(){
        Deck handDeck = this.subject.getHandDeck();
        Deck cardDeck = handDeck.getCardDeckIfContain(new IsSpecificCardRequirement("SB03"));
        if(cardDeck != null){
            List<Role> allTargets = FilterTable.getAvailableTargets(this.subject, "SB03");
            if(allTargets.isEmpty()){
                return;
            }
            List<Role> targets = allTargets.subList(0, 1);
            new UseSB03Action(this.subject, targets, new LogicCard(cardDeck, CardIdentifier.SB03)).process(this);
        }
    }

    private void tryToSUS01(){
        Deck handDeck = this.subject.getHandDeck();
        Deck cardDeck = handDeck.getCardDeckIfContain(new IsSpecificCardRequirement("SUS01"));
        if(cardDeck != null){
            List<Role> allTargets = FilterTable.getAvailableTargets(this.subject, "SUS01");
            new UseSUS01Action(this.subject, allTargets, new LogicCard(cardDeck, CardIdentifier.SUS01)).process(this);
        }
    }

    private void tryToSUS02(){
        Deck handDeck = this.subject.getHandDeck();
        Deck cardDeck = handDeck.getCardDeckIfContain(new IsSpecificCardRequirement("SUS02"));
        if(cardDeck != null){
            List<Role> allTargets = FilterTable.getAvailableTargets(this.subject, "SUS02");
            new UseSUS02Action(this.subject, allTargets, new LogicCard(cardDeck, CardIdentifier.SUS02)).process(this);
        }
    }

    private void tryToSUS03(){
        Deck handDeck = this.subject.getHandDeck();
        Deck cardDeck = handDeck.getCardDeckIfContain(new IsSpecificCardRequirement("SUS03"));
        if(cardDeck != null){
            List<Role> allTargets = FilterTable.getAvailableTargets(this.subject, "SUS03");
            if(allTargets.isEmpty()){
                return;
            }
            List<Role> targets = allTargets.subList(0, 1);
            new UseSUS03Action(this.subject, targets, new LogicCard(cardDeck, CardIdentifier.SUS03)).process(this);
        }
    }

    private void tryToSUS04(){
        Deck handDeck = this.subject.getHandDeck();
        Deck cardDeck = handDeck.getCardDeckIfContain(new IsSpecificCardRequirement("SUS04"));
        if(cardDeck != null){
            List<Role> allTargets = FilterTable.getAvailableTargets(this.subject, "SUS04");
            if(allTargets.isEmpty()){
                return;
            }
            List<Role> targets = allTargets.subList(0, 1);
            new UseSUS04Action(this.subject, targets, new LogicCard(cardDeck, CardIdentifier.SUS04)).process(this);
        }
    }

    private void tryToSUS05(){
        Deck handDeck = this.subject.getHandDeck();
        Deck cardDeck = handDeck.getCardDeckIfContain(new IsSpecificCardRequirement("SUS05"));
        if(cardDeck != null){
            List<Role> allTargets = FilterTable.getAvailableTargets(this.subject, "SUS05");
            new UseSUS05Action(this.subject, allTargets, new LogicCard(cardDeck, CardIdentifier.SUS05)).process(this);
        }
    }

    private void tryToSUS06(){
        Deck handDeck = this.subject.getHandDeck();
        Deck cardDeck = handDeck.getCardDeckIfContain(new IsSpecificCardRequirement("SUS06"));
        if(cardDeck != null){
            List<Role> allTargets = FilterTable.getAvailableTargets(this.subject, "SUS06");
            if(allTargets.isEmpty()){
                return;
            }
            List<Role> targets = allTargets.subList(0, 1);
            new UseSUS06Action(this.subject, targets, new LogicCard(cardDeck, CardIdentifier.SUS06)).process(this);
        }
    }

    private void tryToSUS07(){
        Deck handDeck = this.subject.getHandDeck();
        Deck cardDeck = handDeck.getCardDeckIfContain(new IsSpecificCardRequirement("SUS07"));
        if(cardDeck != null){
            List<Role> allTargets = FilterTable.getAvailableTargets(this.subject, "SUS07");
            if(allTargets.isEmpty()){
                return;
            }
            List<Role> targets = allTargets.subList(0, 1);
            new UseSUS07Action(this.subject, targets, new LogicCard(cardDeck, CardIdentifier.SUS07)).process(this);
        }
    }

    private void tryToSUS08(){
        Deck handDeck = this.subject.getHandDeck();
        Deck cardDeck = handDeck.getCardDeckIfContain(new IsSpecificCardRequirement("SUS08"));
        if(cardDeck != null){
            List<Role> allTargets = FilterTable.getAvailableTargets(this.subject, "SUS08");
            new UseSUS08Action(this.subject, allTargets, new LogicCard(cardDeck, CardIdentifier.SUS08)).process(this);
        }
    }

    private void tryToSUS10(){
        Deck handDeck = this.subject.getHandDeck();
        Deck cardDeck = handDeck.getCardDeckIfContain(new IsSpecificCardRequirement("SUS10"));
        if(cardDeck != null){
            List<Role> allTargets = FilterTable.getAvailableTargets(this.subject, "SUS10");
            if(allTargets.isEmpty()){
                return;
            }
            for(Role role : allTargets){
                List<Role> killTargets = FilterTable.getAvailableTargets(role, "SB01");
                if(killTargets.isEmpty()){
                    continue;
                }
                List<List<Role>> roleTarget = new ArrayList<>();
                roleTarget.add(new ArrayList<>(Arrays.asList(
                        role, killTargets.get(0)
                )));
                new UseSUS10Action(this.subject, roleTarget, new LogicCard(cardDeck, CardIdentifier.SUS10)).process(this);
                return;
            }
        }
    }

    private void tryToSDS01(){
        Deck handDeck = this.subject.getHandDeck();
        Deck cardDeck = handDeck.getCardDeckIfContain(new IsSpecificCardRequirement("SDS01"));
        if(cardDeck != null){
            List<Role> allTargets = FilterTable.getAvailableTargets(this.subject, "SDS01");
            if(allTargets.isEmpty()){
                return;
            }
            Role target = allTargets.get(0);
            new UseSDS01Action(this.subject, target, new LogicCard(cardDeck, CardIdentifier.SDS01)).process(this);
        }
    }

    private void tryToSDS02(){
        Deck handDeck = this.subject.getHandDeck();
        Deck cardDeck = handDeck.getCardDeckIfContain(new IsSpecificCardRequirement("SDS02"));
        if(cardDeck != null){
            List<Role> allTargets = FilterTable.getAvailableTargets(this.subject, "SDS02");
            if(allTargets.isEmpty()){
                return;
            }
            Role target = allTargets.get(0);
            new UseSDS02Action(this.subject, target, new LogicCard(cardDeck, CardIdentifier.SDS02)).process(this);
        }
    }

    private void tryToCarryWeapon(){
        Deck handDeck = this.subject.getHandDeck();
        Deck cardDeck = handDeck.getCardDeckIfContain(new IsWeaponCardRequirement());
        if(cardDeck != null){
            new UseWeaponAction(this.subject, cardDeck).process(this);
        }
    }

    private void tryToWearArmor(){
        Deck handDeck = this.subject.getHandDeck();
        Deck cardDeck = handDeck.getCardDeckIfContain(new IsArmorCardRequirement());
        if(cardDeck != null){
            new UseArmorAction(this.subject, cardDeck).process(this);
        }
    }

    private void tryToMount(){
        Deck handDeck = this.subject.getHandDeck();
        Deck cardDeck = handDeck.getCardDeckIfContain(new IsMountCardRequirement());
        if(cardDeck != null){
            new UseMountAction(this.subject, cardDeck).process(this);
        }
    }
}

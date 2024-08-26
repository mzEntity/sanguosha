package org.example.game.logic.action.role;

import org.example.Main;
import org.example.game.board.card.Card;
import org.example.game.board.card.deck.Deck;
import org.example.game.role.Role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class ChooseFromPlayerAreaProcess {
    private final Role by;
    private final Role to;

    private final int count;
    private final HashMap<Deck, Deck> cards;

    public ChooseFromPlayerAreaProcess(Role subject, Role target, int count) {
        super();
        this.by = subject;
        this.to = target;
        this.count = count;
        this.cards = new HashMap<>();
    }

    public void process(){
        int need = this.count;
        if(!Main.SGS_DEBUG){
            // TODO: for user
            return;
        } else {
            List<Deck> divinationDecks = this.to.getPlayerArea().getDivinationArea().getDeck();
            List<Deck> seq = new ArrayList<>(Arrays.asList(
                    this.to.getHandDeck(),
                    this.to.getPlayerArea().getWeaponArea().getDeck(),
                    this.to.getPlayerArea().getArmorArea().getDeck(),
                    this.to.getPlayerArea().getRetreatMountArea().getDeck(),
                    this.to.getPlayerArea().getMarchMountArea().getDeck()
            ));
            seq.addAll(divinationDecks);
            for(Deck d : seq){
                if(need <= 0) break;
                need -= selectSome(d, need);
            }
        }
    }

    // helper
    private int selectSome(Deck target, int count){
        int targetDeckSize = target.size();
        if(targetDeckSize == 0){
            return 0;
        }
        int chooseCount = Math.min(targetDeckSize, count);
        Deck deck = target.selectSomeAsDeck(0, chooseCount);
        this.cards.put(target, deck);
        return chooseCount;
    }

    public Deck getResult(){
        Deck result = new Deck();
        for(Deck target : this.cards.keySet()){
            Deck r = this.cards.get(target);
            r.moveAllToBack(result);
        }
        return result;
    }
}

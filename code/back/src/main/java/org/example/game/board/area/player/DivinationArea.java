package org.example.game.board.area.player;

import org.example.game.board.card.Card;
import org.example.game.board.card.concrete.skill.delayed.DelayedSkillType;
import org.example.game.board.card.deck.Deck;
import org.example.game.board.card.deck.LogicCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DivinationArea {
    private HashMap<DelayedSkillType, LogicCard> tasks;

    public DivinationArea() {
        this.tasks = new HashMap<>();
        this.tasks.put(DelayedSkillType.SDS01, null);
        this.tasks.put(DelayedSkillType.SDS02, null);
    }

    public void addTask(DelayedSkillType type, LogicCard card) {
        if(this.containTask(type)){
            System.err.println("该种类的延时锦囊已存在");
            return;
        }
        this.tasks.put(type, card);
    }

    public boolean containTask(DelayedSkillType type) {
        LogicCard task = this.tasks.get(type);
        if(task == null) {
            return false;
        }
        Deck d = task.getDeck();
        if(d.isEmpty()){
            this.tasks.put(type, null);
            return false;
        }
        return true;
    }

    public boolean isEmpty(){
        return tasks.isEmpty();
    }

    public List<Deck> getDeck(){
        List<Deck> decks = new ArrayList<>();
        for(DelayedSkillType type : tasks.keySet()){
            LogicCard card = tasks.get(type);
            if(card != null){
                Deck d = card.getDeck();
                if(!d.isEmpty()){
                    decks.add(d);
                }
            }
        }
        return decks;
    }

    public LogicCard getNextTask(){
        for(DelayedSkillType type : tasks.keySet()){
            LogicCard card = tasks.get(type);
            if(card != null){
                Deck d = card.getDeck();
                if(!d.isEmpty()){
                    return card;
                }
            }
        }
        return null;
    }

    public void finishTask(DelayedSkillType type){
        this.tasks.put(type, null);
    }

    public Deck combineDeck(){
        Deck result = new Deck();
        for(DelayedSkillType type : tasks.keySet()){
            LogicCard card = tasks.get(type);
            if(card != null){
                Deck d = card.getDeck();
                if(!d.isEmpty()){
                    d.moveAllToBack(result);
                }
            }
        }
        return result;
    }
}

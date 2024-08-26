package org.example.game.board.card.deck;

import org.example.game.board.card.Card;
import org.example.game.board.card.CardBuilder;
import org.example.game.board.card.Suit;
import org.example.game.requirement.CardRequirement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
    }

    private Deck(List<Card> cards) {
        this.cards = cards;
    }

    public int size(){
        return this.cards.size();
    }

    public boolean isEmpty(){
        return this.cards.isEmpty();
    }

    public void shuffle(){
        Collections.shuffle(this.cards);
    }

    public int moveAllToFront(Deck target){
        int insertCount = target.insertFront(this);
        int clearCount = this.clear();
        assert insertCount == clearCount;
        return insertCount;
    }

    public int moveAllToBack(Deck target){
        int insertCount = target.insertBack(this);
        int clearCount = this.clear();
        assert insertCount == clearCount;
        return insertCount;
    }

    public Deck selectSomeAsDeck(int from, int to){
        Deck selected = this.subDeck(from, to);
        return splitSubDeck(selected);
    }

    public int moveFrontToFront(Deck target, int count){
        int totalBefore = this.size() + target.size();
        Deck subDeck = this.selectSomeAsDeck(0, count);
        int insertCount = subDeck.moveAllToFront(target);
        assert totalBefore == this.size() + target.size();
        return insertCount;
    }

    public int moveFrontToBack(Deck target, int count){
        int totalBefore = this.size() + target.size();
        Deck subDeck = this.selectSomeAsDeck(0, count);
        int insertCount = subDeck.moveAllToBack(target);
        assert totalBefore == this.size() + target.size();
        return insertCount;
    }

    public int moveBackToFront(Deck target, int count){
        int totalBefore = this.size() + target.size();
        int startIndex = this.size() - count;
        Deck subDeck = this.selectSomeAsDeck(startIndex, this.size());
        int insertCount = subDeck.moveAllToFront(target);
        assert totalBefore == this.size() + target.size();
        return insertCount;
    }

    public int moveBackToBack(Deck target, int count){
        int totalBefore = this.size() + target.size();
        Deck subDeck = this.selectSomeAsDeck(0, count);
        int insertCount = subDeck.moveAllToBack(target);
        assert totalBefore == this.size() + target.size();
        return insertCount;
    }

    public Card getCard(int index){
        return this.cards.get(index);
    }

    public Suit getSuitOfDeck(){
        Suit suit = null;
        for(Card c: this.cards){
            if(suit == null || suit.equals(c.getSuit())){
                suit = c.getSuit();
            } else if(suit.getColor() == c.getSuit().getColor()){
                suit = suit.removeColor();
            } else {
                suit = Suit.None;
            }
        }
        return suit;
    }

    public int getPointOfDeck(){
        if(this.size() == 1) return this.cards.get(0).getPoint();
        return 0;
    }

    private Deck subDeck(int from, int to){
        return new Deck(this.cards.subList(from, to));
    }

    private Deck subDeck(Card card){
        int index = this.cards.indexOf(card);
        assert index >= 0;
        return this.subDeck(index, index+1);
    }

    private Deck splitSubDeck(Deck subDeck){
        Deck newDeck = new Deck();
        subDeck.moveAllToBack(newDeck);
        return newDeck;
    }

    private int clear(){
        int count = this.size();
        this.cards.clear();
        return count;
    }

    private boolean containCard(Card card){
        return this.cards.contains(card);
    }

    private boolean containDeckSome(Deck target){
        for(Card c: target.cards){
            if(this.containCard(c)){
                return true;
            }
        }
        return false;
    }

    private int insertBack(Deck from){
        if(containDeckSome(from)){
            return 0;
        }
        this.cards.addAll(from.cards);
        return from.size();
    }

    private int insertFront(Deck from){
        if(containDeckSome(from)){
            return 0;
        }
        Deck newDeck = new Deck();
        newDeck.insertBack(from);
        newDeck.insertBack(this);
        this.clear();
        this.insertBack(newDeck);
        return from.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Deck(");
        for(Card c: this.cards){
            stringBuilder.append("\n\t").append(c);
        }
        stringBuilder.append("\n)");
        return stringBuilder.toString();
    }

    public String toStringInLine(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Card c: this.cards){
            stringBuilder.append(c.toStringInLine());
        }
        return stringBuilder.toString();
    }

    public static Deck prepareDeck(List<Card> cardList){
        return new Deck(cardList);
    }

    // 仅测试用
    public Deck getCardDeckIfContain(CardRequirement cr){
        for(Card c: this.cards){
            Deck subDeck = this.subDeck(c);
            LogicCard logicCard = new LogicCard(subDeck, c.getCid());
            if(cr.isMet(logicCard)){
                return this.splitSubDeck(subDeck);
            }
        }
        return null;
    }
}

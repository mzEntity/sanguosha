package org.example.game.board.card;

import org.example.game.board.card.concrete.DefaultCard;
import org.example.game.board.card.concrete.basic.SB01;
import org.example.game.board.card.concrete.basic.SB02;
import org.example.game.board.card.concrete.basic.SB03;
import org.example.game.board.card.concrete.equipment.armor.SEA01;
import org.example.game.board.card.concrete.equipment.mount.*;
import org.example.game.board.card.concrete.equipment.weapon.*;
import org.example.game.board.card.concrete.skill.delayed.SDS01;
import org.example.game.board.card.concrete.skill.delayed.SDS02;
import org.example.game.board.card.concrete.skill.undelayed.*;
import org.example.tools.FileOperator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class CardBuilder {
    private static HashMap<CardIdentifier, BiFunction<Suit, Integer, Card>> allCards;

    static {
        allCards = new HashMap<>();
        allCards.put(CardIdentifier.DEFAULT, (suit, point) -> new DefaultCard(suit, point));
        allCards.put(CardIdentifier.SB01, (suit, point) -> new SB01(suit, point));
        allCards.put(CardIdentifier.SB02, (suit, point) -> new SB02(suit, point));
        allCards.put(CardIdentifier.SB03, (suit, point) -> new SB03(suit, point));
        allCards.put(CardIdentifier.SUS01, (suit, point) -> new SUS01(suit, point));
        allCards.put(CardIdentifier.SUS02, (suit, point) -> new SUS02(suit, point));
        allCards.put(CardIdentifier.SUS03, (suit, point) -> new SUS03(suit, point));
        allCards.put(CardIdentifier.SUS04, (suit, point) -> new SUS04(suit, point));
        allCards.put(CardIdentifier.SUS05, (suit, point) -> new SUS05(suit, point));
        allCards.put(CardIdentifier.SUS06, (suit, point) -> new SUS06(suit, point));
        allCards.put(CardIdentifier.SUS07, (suit, point) -> new SUS07(suit, point));
        allCards.put(CardIdentifier.SUS08, (suit, point) -> new SUS08(suit, point));
        allCards.put(CardIdentifier.SUS09, (suit, point) -> new SUS09(suit, point));
        allCards.put(CardIdentifier.SUS10, (suit, point) -> new SUS10(suit, point));
        allCards.put(CardIdentifier.SDS01, (suit, point) -> new SDS01(suit, point));
        allCards.put(CardIdentifier.SDS02, (suit, point) -> new SDS02(suit, point));
        allCards.put(CardIdentifier.SEW01, (suit, point) -> new SEW01(suit, point));
        allCards.put(CardIdentifier.SEW02, (suit, point) -> new SEW02(suit, point));
        allCards.put(CardIdentifier.SEW03, (suit, point) -> new SEW03(suit, point));
        allCards.put(CardIdentifier.SEW04, (suit, point) -> new SEW04(suit, point));
        allCards.put(CardIdentifier.SEW05, (suit, point) -> new SEW05(suit, point));
        allCards.put(CardIdentifier.SEW06, (suit, point) -> new SEW06(suit, point));
        allCards.put(CardIdentifier.SEW07, (suit, point) -> new SEW07(suit, point));
        allCards.put(CardIdentifier.SEW08, (suit, point) -> new SEW08(suit, point));
        allCards.put(CardIdentifier.SEA01, (suit, point) -> new SEA01(suit, point));
        allCards.put(CardIdentifier.SEM01, (suit, point) -> new SEM01(suit, point));
        allCards.put(CardIdentifier.SEM02, (suit, point) -> new SEM02(suit, point));
        allCards.put(CardIdentifier.SEM03, (suit, point) -> new SEM03(suit, point));
        allCards.put(CardIdentifier.SEM04, (suit, point) -> new SEM04(suit, point));
        allCards.put(CardIdentifier.SEM05, (suit, point) -> new SEM05(suit, point));
        allCards.put(CardIdentifier.SEM06, (suit, point) -> new SEM06(suit, point));
    }

    public static Card buildCard(Suit suit, int point, CardIdentifier cid){
        if(!allCards.containsKey(cid)){
            System.err.println("error in table pair " + cid.getId());
            return new DefaultCard(suit, point);
        }
        return allCards.get(cid).apply(suit, point);
    }

    public static Card buildCard(Suit suit, int point, String cardId){
        CardIdentifier cid = CardIdentifier.getCardIdentifier(cardId);
        return buildCard(suit, point, cid);
    }

    public static List<Card> buildDeck(){
        List<String> lines = FileOperator.readFile("./src/main/resources/table.txt");
        int lineNum = lines.size();
        if(lineNum % 2 != 0){
            System.err.println("error in table.txt");
            return null;
        }
        int pairNum = lineNum / 2;
        List<Card> cardList = new ArrayList<>();

        String regexStr = "\\((\\d+),([CDHS])\\)";
        Pattern pattern = Pattern.compile(regexStr);
        for(int i = 0; i < pairNum; i++){
            String cardId = lines.get(i * 2);
            String cardInstanceListStr = lines.get(i * 2 + 1);
            Matcher matcher = pattern.matcher(cardInstanceListStr);
            while(matcher.find()){
                Suit suit = Suit.getSuit(matcher.group(2));
                int point = Integer.parseInt(matcher.group(1));
                Card card = buildCard(suit, point, cardId);
                cardList.add(card);
            }
        }

        cardList.sort(new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o1.getPoint() - o2.getPoint();
            }
        });
        return cardList;
    }
}

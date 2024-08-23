package org.example.game.distance;

import org.example.game.board.card.deck.Deck;
import org.example.game.board.card.concrete.equipment.WeaponCard;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/14
 */
public class AttackRangeTable {
    public static int getAttackRange(Role r){
        Deck weaponDeck = r.getPlayerArea().getWeaponArea().getDeck();
        if(weaponDeck.isEmpty()){
            return 1;
        }
        WeaponCard weapon = (WeaponCard) weaponDeck.getCard(0);
        return weapon.getAttackRange();
    }
}

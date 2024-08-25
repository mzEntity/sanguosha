package org.example.game.board.card.concrete.equipment;

import org.example.game.board.card.CardIdentifier;
import org.example.game.board.card.Suit;
import org.example.game.board.card.concrete.EquipmentCard;
import org.example.game.board.card.concrete.equipment.mount.MountType;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class MountCard extends EquipmentCard {
    private final MountType mountType;

    public MountCard(Suit suit, int point, CardIdentifier cid, MountType type) {
        super(suit, point, cid);
        this.mountType = type;
    }

    public MountType getMountType() {
        return mountType;
    }
}

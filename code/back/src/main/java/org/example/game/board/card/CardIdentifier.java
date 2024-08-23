package org.example.game.board.card;

import java.util.HashMap;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public enum CardIdentifier {
    DEFAULT("default", "未知"),
    SB01("SB01", "杀"),
    SB02("SB02", "闪"),
    SB03("SB03", "桃"),
    SUS01("SUS01", "桃园结义"),
    SUS02("SUS02", "万箭齐发"),
    SUS03("SUS03", "决斗"),
    SUS04("SUS04", "顺手牵羊"),
    SUS05("SUS05", "五谷丰登"),
    SUS06("SUS06", "过河拆桥"),
    SUS07("SUS07", "无中生有"),
    SUS08("SUS08", "南蛮入侵"),
    SUS09("SUS09", "无懈可击"),
    SUS10("SUS10", "借刀杀人"),
    SDS01("SDS01", "闪电"),
    SDS02("SDS02", "乐不思蜀"),
    SEW01("SEW01", "诸葛连弩"),
    SEW02("SEW02", "雌雄双股剑"),
    SEW03("SEW03", "青钢剑"),
    SEW04("SEW04", "青龙偃月刀"),
    SEW05("SEW05", "丈八蛇矛"),
    SEW06("SEW06", "贯石斧"),
    SEW07("SEW07", "方天画戟"),
    SEW08("SEW08", "麒麟弓"),
    SEA01("SEA01", "八卦阵"),
    SEM01("SEM01", "的卢"),
    SEM02("SEM02", "绝影"),
    SEM03("SEM03", "爪黄飞电"),
    SEM04("SEM04", "赤兔"),
    SEM05("SEM05", "紫骍"),
    SEM06("SEM06", "大宛");

    private String id;
    private String name;

    private static HashMap<String, CardIdentifier> allCardIdentifier;

    static {
        allCardIdentifier = new HashMap<>();
        allCardIdentifier.put("SB01", CardIdentifier.SB01);
        allCardIdentifier.put("SB02", CardIdentifier.SB02);
        allCardIdentifier.put("SB03", CardIdentifier.SB03);
        allCardIdentifier.put("SUS01", CardIdentifier.SUS01);
        allCardIdentifier.put("SUS02", CardIdentifier.SUS02);
        allCardIdentifier.put("SUS03", CardIdentifier.SUS03);
        allCardIdentifier.put("SUS04", CardIdentifier.SUS04);
        allCardIdentifier.put("SUS05", CardIdentifier.SUS05);
        allCardIdentifier.put("SUS06", CardIdentifier.SUS06);
        allCardIdentifier.put("SUS07", CardIdentifier.SUS07);
        allCardIdentifier.put("SUS08", CardIdentifier.SUS08);
        allCardIdentifier.put("SUS09", CardIdentifier.SUS09);
        allCardIdentifier.put("SUS10", CardIdentifier.SUS10);
        allCardIdentifier.put("SDS01", CardIdentifier.SDS01);
        allCardIdentifier.put("SDS02", CardIdentifier.SDS02);
        allCardIdentifier.put("SEW01", CardIdentifier.SEW01);
        allCardIdentifier.put("SEW02", CardIdentifier.SEW02);
        allCardIdentifier.put("SEW03", CardIdentifier.SEW03);
        allCardIdentifier.put("SEW04", CardIdentifier.SEW04);
        allCardIdentifier.put("SEW05", CardIdentifier.SEW05);
        allCardIdentifier.put("SEW06", CardIdentifier.SEW06);
        allCardIdentifier.put("SEW07", CardIdentifier.SEW07);
        allCardIdentifier.put("SEW08", CardIdentifier.SEW08);
        allCardIdentifier.put("SEA01", CardIdentifier.SEA01);
        allCardIdentifier.put("SEM01", CardIdentifier.SEM01);
        allCardIdentifier.put("SEM02", CardIdentifier.SEM02);
        allCardIdentifier.put("SEM03", CardIdentifier.SEM03);
        allCardIdentifier.put("SEM04", CardIdentifier.SEM04);
        allCardIdentifier.put("SEM05", CardIdentifier.SEM05);
        allCardIdentifier.put("SEM06", CardIdentifier.SEM06);
    }

    CardIdentifier(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static CardIdentifier getCardIdentifier(String cardId){
        if(!allCardIdentifier.containsKey(cardId)){
            return DEFAULT;
        }
        return allCardIdentifier.get(cardId);
    }
}

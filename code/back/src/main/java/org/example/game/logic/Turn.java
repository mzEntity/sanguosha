package org.example.game.logic;

import org.example.game.logic.action.stage.*;
import org.example.game.role.Role;
import org.example.log.Logger;


public class Turn extends Action {
    private Role subject;
    private boolean isSkipped;

    private final TurnStartStage turnStartStage;
    private final PreparationStage preparationStage;
    private final DivinationStage divinationStage;
    private final DrawStage drawStage;
    private final PunchingStage punchingStage;
    private final DiscardingStage discardingStage;
    private final TurnFinishStage turnFinishStage;

    public int handLimit;

    public Turn(Role subject) {
        super();
        this.subject = subject;
        this.turnStartStage = new TurnStartStage(subject);
        this.preparationStage = new PreparationStage(subject);
        this.divinationStage = new DivinationStage(subject);
        this.drawStage = new DrawStage(subject);
        this.punchingStage = new PunchingStage(subject);
        this.discardingStage = new DiscardingStage(subject, this);
        this.turnFinishStage = new TurnFinishStage(subject);

        this.handLimit = subject.condition.hp;
        this.isSkipped = false;
    }


    @Override
    protected void mainLogic(Action from) {
        if(this.subject.isAlive() && !this.turnStartStage.isSkipped()){
            this.turnStartStage.process(this);
        } else {
            Logger.printf("%s跳过回合开始阶段\n", this.subject.code);
        }
        if(this.subject.isAlive() && !this.preparationStage.isSkipped()){
            this.preparationStage.process(this);
        } else {
            Logger.printf("%s跳过准备阶段\n", this.subject.code);
        }
        if(this.subject.isAlive() && !this.divinationStage.isSkipped()){
            this.divinationStage.process(this);
        } else {
            Logger.printf("%s跳过判定阶段\n", this.subject.code);
        }
        if(this.subject.isAlive() && !this.drawStage.isSkipped()){
            this.drawStage.process(this);
        } else {
            Logger.printf("%s跳过摸牌阶段\n", this.subject.code);
        }
        if(this.subject.isAlive() && !this.punchingStage.isSkipped()){
            this.punchingStage.process(this);
        } else {
            Logger.printf("%s跳过出牌阶段\n", this.subject.code);
        }
        if(this.subject.isAlive() && !this.discardingStage.isSkipped()){
            this.discardingStage.process(this);
        } else {
            Logger.printf("%s跳过弃牌阶段\n", this.subject.code);
        }
        if(this.subject.isAlive() && !this.turnFinishStage.isSkipped()){
            this.turnFinishStage.process(this);
        } else {
            Logger.printf("%s跳过回合结束阶段\n", this.subject.code);
        }
    }

    public TurnStartStage getTurnStartStage() {
        return turnStartStage;
    }

    public PreparationStage getPreparationStage() {
        return preparationStage;
    }

    public DivinationStage getDivinationStage() {
        return divinationStage;
    }

    public DrawStage getDrawStage() {
        return drawStage;
    }

    public PunchingStage getPunchingStage() {
        return punchingStage;
    }

    public DiscardingStage getDiscardingStage() {
        return discardingStage;
    }

    public TurnFinishStage getTurnFinishStage() {
        return turnFinishStage;
    }
}

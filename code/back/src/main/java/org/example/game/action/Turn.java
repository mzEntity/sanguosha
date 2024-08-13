package org.example.game.action;

import org.example.game.Game;
import org.example.game.action.stage.*;
import org.example.game.role.Role;


public class Turn extends Action {
    private final TurnStartStage turnStartStage;
    private final PreparationStage preparationStage;
    private final DivinationStage divinationStage;
    private final DrawStage drawStage;
    private final PunchingStage punchingStage;
    private final DiscardingStage discardingStage;
    private final TurnFinishStage turnFinishStage;

    public int handLimit;

    public Turn(Role subject) {
        super(subject);
        this.turnStartStage = new TurnStartStage(subject);
        this.preparationStage = new PreparationStage(subject);
        this.divinationStage = new DivinationStage(subject);
        this.drawStage = new DrawStage(subject);
        this.punchingStage = new PunchingStage(subject);
        this.discardingStage = new DiscardingStage(subject, this);
        this.turnFinishStage = new TurnFinishStage(subject);
        this.handLimit = subject.condition.hp;
    }


    @Override
    protected void mainLogic(Action from) {
        this.turnStartStage.process(this);
        this.preparationStage.process(this);
        this.divinationStage.process(this);
        this.drawStage.process(this);
        this.punchingStage.process(this);
        this.discardingStage.process(this);
        this.turnFinishStage.process(this);
    }
}

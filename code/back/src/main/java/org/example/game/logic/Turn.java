package org.example.game.logic;

import org.example.game.logic.stage.*;
import org.example.game.role.Role;


public class Turn extends Action {
    private Role subject;
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
    }


    @Override
    protected void mainLogic(Action from) {
        if(this.subject.isAlive()){
            this.turnStartStage.process(this);
        }
        if(this.subject.isAlive()){
            this.preparationStage.process(this);
        }
        if(this.subject.isAlive()){
            this.divinationStage.process(this);
        }
        if(this.subject.isAlive()){
            this.drawStage.process(this);
        }
        if(this.subject.isAlive()){
            this.punchingStage.process(this);
        }
        if(this.subject.isAlive()){
            this.discardingStage.process(this);
        }
        if(this.subject.isAlive()){
            this.turnFinishStage.process(this);
        }
    }
}

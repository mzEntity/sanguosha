package org.example.game.action;

import org.example.game.Game;
import org.example.game.action.stage.*;
import org.example.game.role.Role;


public class Turn extends Action {
    public TurnStartStage turnStartStage;
    public PreparationStage preparationStage;
    public DivinationStage divinationStage;
    public DrawStage drawStage;
    public PunchingStage punchingStage;
    public DiscardingStage discardingStage;
    public TurnFinishStage turnFinishStage;

    public Turn(Role subject) {
        super("Turn", subject);
    }


    @Override
    protected void mainLogic(Action from) {
        Game game = Game.getGame();
        game.activeRole = this.subject;
        this.turnStartStage.process(this);
        this.preparationStage.process(this);
        this.divinationStage.process(this);
        this.drawStage.process(this);
        this.punchingStage.process(this);
        this.discardingStage.process(this);
        this.turnFinishStage.process(this);
    }
}

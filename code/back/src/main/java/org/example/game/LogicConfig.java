package org.example.game;

import org.example.game.filter.DefaultFilter;
import org.example.game.filter.FilterTable;
import org.example.game.filter.card.SB01_TargetFilter;
import org.example.game.role.Role;

import java.util.List;

public class LogicConfig {
    private List<Role> roles;

    public LogicConfig(List<Role> roles) {
        this.roles = roles;
    }

    public void initLogic(){
        this.initActionTrigger();
        this.initTargetFilter();
    }

    public void initActionTrigger(){
        Game.getGame().registerBefore(new InitDrawDeckAction());
    }

    public void initTargetFilter(){
        FilterTable.setFilter("SB01", new SB01_TargetFilter());
        FilterTable.setFilter("Default", new DefaultFilter());
    }
}

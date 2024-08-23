package org.example.game;

import org.example.game.filter.CompositeFilter;
import org.example.game.filter.DefaultFilter;
import org.example.game.filter.FilterTable;
import org.example.game.filter.TargetFilter;
import org.example.game.filter.subfilter.AliveFilter;
import org.example.game.filter.subfilter.DistanceWithinAttackRangeFilter;
import org.example.game.filter.subfilter.NotSelfFilter;
import org.example.game.role.Role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LogicConfig {

    public LogicConfig(){
    }

    public void initLogic(){
        this.initActionTrigger();
        this.initTargetFilter();
        this.initCardRequirement();
    }

    public void initActionTrigger(){
    }

    public void initTargetFilter(){
        CompositeFilter SB01_filter = new CompositeFilter(
                new ArrayList<>(Arrays.asList(
                        new AliveFilter(),
                        new NotSelfFilter(),
                        new DistanceWithinAttackRangeFilter()
                ))
        );
        FilterTable.setFilter("SB01", SB01_filter);
        FilterTable.setFilter("SUS03", new AliveFilter());
    }

    public void initCardRequirement(){

    }
}

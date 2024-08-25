package org.example.game;

import org.example.game.board.card.concrete.skill.delayed.DelayedSkillType;
import org.example.game.filter.CompositeAndFilter;
import org.example.game.filter.FilterTable;
import org.example.game.filter.subfilter.*;

import java.util.ArrayList;
import java.util.Arrays;

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
        FilterTable.setFilter("SB01", new CompositeAndFilter(
                new ArrayList<>(Arrays.asList(
                        new AliveFilter(),
                        new NotSelfFilter(),
                        new DistanceWithinAttackRangeFilter()
                ))
        ));
        FilterTable.setFilter("SB03", new CompositeAndFilter(
                new ArrayList<>(Arrays.asList(
                        new AliveFilter(),
                        new SelfFilter(),
                        new InjuredFilter()
                ))
        ));
        FilterTable.setFilter("SUS01", new AliveFilter());
        FilterTable.setFilter("SUS02", new CompositeAndFilter(
                new ArrayList<>(Arrays.asList(
                        new AliveFilter(),
                        new NotSelfFilter()
                ))
        ));
        FilterTable.setFilter("SUS03", new CompositeAndFilter(
                new ArrayList<>(Arrays.asList(
                        new AliveFilter(),
                        new NotSelfFilter()
                ))
        ));
        FilterTable.setFilter("SUS04", new CompositeAndFilter(
                new ArrayList<>(Arrays.asList(
                        new AliveFilter(),
                        new NotSelfFilter(),
                        new WithinDistanceFilter(1),
                        new WithCardInAreaFilter()
                ))
        ));
        FilterTable.setFilter("SUS05", new AliveFilter());
        FilterTable.setFilter("SUS06", new CompositeAndFilter(
                new ArrayList<>(Arrays.asList(
                        new AliveFilter(),
                        new NotSelfFilter(),
                        new WithCardInAreaFilter()
                ))
        ));
        FilterTable.setFilter("SUS07", new CompositeAndFilter(
                new ArrayList<>(Arrays.asList(
                        new AliveFilter(),
                        new SelfFilter()
                ))
        ));
        FilterTable.setFilter("SUS08", new CompositeAndFilter(
                new ArrayList<>(Arrays.asList(
                        new AliveFilter(),
                        new NotSelfFilter()
                ))
        ));
        FilterTable.setFilter("SUS10", new CompositeAndFilter(
                new ArrayList<>(Arrays.asList(
                        new AliveFilter(),
                        new NotSelfFilter(),
                        new WithWeaponCardFilter()
                ))
        ));
        FilterTable.setFilter("SDS01", new CompositeAndFilter(
                new ArrayList<>(Arrays.asList(
                        new AliveFilter(),
                        new SelfFilter(),
                        new NotWithSpecificDivinationTaskFilter(DelayedSkillType.SDS01)
                ))
        ));
        FilterTable.setFilter("SDS02", new CompositeAndFilter(
                new ArrayList<>(Arrays.asList(
                        new AliveFilter(),
                        new NotSelfFilter(),
                        new NotWithSpecificDivinationTaskFilter(DelayedSkillType.SDS02)
                ))
        ));
    }

    public void initCardRequirement(){

    }
}

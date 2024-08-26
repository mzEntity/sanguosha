package org.example.game.logic;

import org.example.view.Viewer;
import org.example.view.concrete.LogViewer;

import java.util.ArrayList;
import java.util.List;

public abstract class Action {

    protected static List<Viewer> viewers;

    static {
        viewers = new ArrayList<>();
        viewers.add(new LogViewer());
    }

    public Action() {
    }

    public void process(Action from){
        this.updateViewer();
        this.mainLogic(from);
    }

    abstract protected void mainLogic(Action from);

    private void updateViewer(){
        for(Viewer viewer : viewers){
            viewer.display(this);
        }
    }
}

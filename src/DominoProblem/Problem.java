package DominoProblem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Problem {

    public ArrayList<ArrayList<String>> dominoes;
    public State initialState;
    public ArrayList<Action> actions;

    public Problem(ArrayList<ArrayList<String>> dominoes, State initialState, ArrayList<Action> actions) {
        this.dominoes = dominoes;
        this.initialState = initialState;
        this.actions = actions;
    }

    public State getInitialState() {
        return initialState;
    }

    public boolean goalTest(State s) {
        if (s.getTop().equals(s.getBottom()) && s.getTop() != "" && s.getBottom() != "") {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Action> getActions(State s, ArrayList<ArrayList<String>> dominoes) {

        ArrayList<Action> actions = new ArrayList<>();

        for (int i = 0; i < dominoes.size(); i++) {
            //System.out.println("Top Existing: " + s.getTop() + "Top New: " + dominoes.get(i).get(0) + "   ||   " + "Bottom Existing: " + s.getBottom() + "Bottom New: " + dominoes.get(i).get(1));
            if (checkActionValidity(s.getTop() + dominoes.get(i).get(0), s.getBottom() + dominoes.get(i).get(1))) {
                Action newAction = new Action(dominoes.get(i).get(0), dominoes.get(i).get(1));
                //System.out.println(newAction.topAddition + " " + newAction.bottomAddition);
                actions.add(newAction);
            }
        }
        return actions;
    }

    public boolean checkActionValidity(String top, String bottom) {
        if (top.startsWith(bottom) || bottom.startsWith(top)) {
            return true;
        } else {
            //System.out.println("Action Exists");

            return false;
        }
    }
}

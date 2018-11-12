package DominoProblem;

import java.util.ArrayList;
import java.util.List;

public class Search {

    public boolean cutoffOccurred;

    public Node depthLimitedSearch(Problem problem, int limit, ArrayList<ArrayList<String>> dominoes) throws SearchCutoff, SearchFailure, Exception {
        Node initialNode = new Node(problem.getInitialState(), null, null, 0);
        return recursiveDLS(initialNode, problem, limit, dominoes);
    }

    public Node recursiveDLS(Node node, Problem problem, int limit, ArrayList<ArrayList<String>> dominoes) throws SearchCutoff, SearchFailure, Exception {
        if (problem.goalTest(node.state)) {
            return node;
        } else if (limit == 0) {
            throw new SearchCutoff();
        } else {
            cutoffOccurred = false;
            ArrayList<Action> list = problem.getActions(node.state, problem.dominoes);
            //System.out.println(actionPrinter(list));
            for (int i = 0; i < list.size(); i++) {
                //System.out.println(list.get(i).topAddition + " " + list.get(i).bottomAddition);
                Node child = new Node(result(node.state, list.get(i), dominoes), node, list.get(i), 0);
                try {
                    Node result = recursiveDLS(child, problem, limit - 1, dominoes);
                    return result;
                } catch (SearchCutoff s) {
                    cutoffOccurred = true;
                } catch (SearchFailure s) {
                }
            }
            if (cutoffOccurred) {
                throw new SearchCutoff();
            } else {
                throw new SearchFailure();
            }
        }
    }

    public Node iterativeDeepeningSearch(Problem p, int maxDepth, ArrayList<ArrayList<String>> dominoes) throws SearchCutoff, SearchFailure, Exception {
        int infinity = maxDepth;
        for (int d = 0; d < infinity; d++) {
            try {
                Node r = depthLimitedSearch(p, d, dominoes);
                return r;
            } catch (SearchCutoff s) {
                cutoffOccurred = true;
            }
    }

        if (cutoffOccurred == true) {
            throw new SearchCutoff();
        } else {
            throw new SearchFailure();
        }
    }

    public Node initialStateToNode(State state) {
        Node node = new Node(state, null, null, 0);
        return node;
    }

    public State result(State s, Action a, ArrayList<ArrayList<String>> dominoes) throws Exception {
        ArrayList<String> doms = new ArrayList<>();
        for (int z = 0; z < s.getDominoes().size(); z++) {
            doms.add(s.getDominoes().get(z));
        }
        doms.add(dominoMatcher(a.topAddition, a.bottomAddition, dominoes));
        State newState = new State(s.getTop() + a.topAddition, s.getBottom() + a.bottomAddition, doms);
      //  System.out.println("Top Addition: " + a.topAddition + " || " + "Bottom Addition: " + a.bottomAddition);
      //  System.out.println("Current Top: " + newState.top + " || " + "Current Bottom: " + newState.bottom);
        return newState;
    }

    public String dominoMatcher(String domTop, String domBottom, ArrayList<ArrayList<String>> dominoes) throws Exception {

        for (int i = 0; i < dominoes.size(); i++) {
            if (domTop == dominoes.get(i).get(0) && domBottom == dominoes.get(i).get(1)) {
                return "D" + (i+1);
            }
        }
        throw new Exception();
    }
}
package DominoProblem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class main {

    static Search search = new Search();
    static Problem myProblem;
    static int maxDepth;
    static String path = "src\\DominoProblem\\data.txt";

    public static void main(String[] args) throws SearchCutoff, SearchFailure, IOException {

        ArrayList<ArrayList<String>> doms = new ArrayList<>();

        doms = dominoInitializer(dataParser(path));
        maxDepth = Integer.valueOf(dataParser(path).get(0));
        ArrayList<String> noDominoesYet = new ArrayList<>();

        State initialState = new State("", "", noDominoesYet);

        ArrayList<Action> firstActions = new ArrayList<>();
        firstActions = getFirstActions(initialState, doms);

        myProblem = new Problem(doms, initialState, firstActions);

        Node completed = new Node(null, null, null, 0);

        try {
            System.out.println("Testing if a solution exists within the limits of the search...");
            completed = search.iterativeDeepeningSearch(myProblem, maxDepth, doms);
            System.out.println("The solution is: " + printAllDominoNames(completed.state.dominoesNamed) + "|| " + completed.state.top);
        } catch (SearchFailure e) {
            System.out.println("No solution exists within the limits of the search");
            System.out.println();
            try {
                System.out.println("Testing if a solution exists at all...");
                completed = search.iterativeDeepeningSearch(myProblem, 999999999, doms);
                System.out.println("The solution is: " + printAllDominoNames(completed.state.dominoesNamed) + "|| " + completed.state.top);
            } catch (SearchFailure zz) {
                System.out.println("No solution exists at all");
            } catch (SearchCutoff b) {
                System.out.println("No solution exists at all");
            } catch (Exception aa) {
            }
        } catch (SearchCutoff z) {
            System.out.println("No solution exists within the limits of the search");
            System.out.println();
            try {
                System.out.println("Testing if a solution exists at all...");
                completed = search.iterativeDeepeningSearch(myProblem, 999999999, doms);
                System.out.println("The solution is: " + printAllDominoNames(completed.state.dominoesNamed) + "|| " + completed.state.top);
            } catch (SearchFailure zz) {
                System.out.println("No solution exists at all");
            } catch (SearchCutoff b) {
                System.out.println("No solution exists at all");
            } catch (Exception abc) {
            }
        } catch (Exception s) {
        }
    }

    public static ArrayList<Action> getFirstActions(State s, ArrayList<ArrayList<String>> dominoes) {
        ArrayList<Action> actions = new ArrayList<>();
        for (int i = 0; i < dominoes.size(); i++) {
            if (checkActionValidity(s.getTop() + dominoes.get(i).get(0), s.getBottom() + dominoes.get(i).get(1))) {
                Action newAction = new Action(dominoes.get(i).get(0), dominoes.get(i).get(1));
                actions.add(newAction);
            }
        }
        return actions;
    }

    public static boolean checkActionValidity(String top, String bottom) {
        if (top.startsWith(bottom) || bottom.startsWith(top)) {
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<String> dataParser(String p) throws IOException {

        String path = p;
        String limit;
        String numDominoes;
        ArrayList<String> strings = new ArrayList<>();

        BufferedReader in = new BufferedReader(new FileReader(path));
        String str=null;

        limit = in.readLine();
        numDominoes = in.readLine();

        strings.add(limit);
        strings.add(numDominoes);

        for (int i = 0; i < 20; i++) {
            strings.add(in.readLine());
        }

        return strings;
    }

    public static ArrayList<ArrayList<String>> dominoInitializer (ArrayList<String> d) {
        ArrayList<String> data = d;
        d.remove(0);
        d.remove(0);
        ArrayList<ArrayList<String>> dominoes = new ArrayList<>();

        for (int i = 0; i < d.size(); i++) {
            try {
                String[] s = d.get(i).split("\\s+");
                ArrayList<String> temp = new ArrayList<>();
                temp.add(s[1]);
                temp.add(s[2]);
                dominoes.add(temp);
            } catch (NullPointerException e) {

            }
        }
        return dominoes;
    }

    public static String printAllDominoNames(ArrayList<String> dominoNames) {
        String s = "";
        for (String string : dominoNames) {
            s += string + " ";
        }
        return s;
    }
}
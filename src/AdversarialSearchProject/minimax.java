package AdversarialSearchProject;

public class minimax {

    public static int minimax(State state, int depth, boolean  maxIsPlaying) {
        if (depth == state.height)
            return state.values[state.index];

        if (maxIsPlaying)
            return Math.max(minimax(newState(state, 2, 0), depth + 1, false), minimax(newState(state, 2, 1), depth + 1, false));
        else
            return Math.min(minimax(newState(state, 2,0), depth + 1, true), minimax(newState(state, 2,1), depth + 1, true));
    }

    public static State newState(State s, int mult, int add) {
        State ns = new State(((s.index)*mult)+add, s.values,0,0);
        return ns;
    }


    public static void main (String[] args) {

            int values[] = {3, 5, 2, 9, 12, 5, 23, 23};
            int values2[] = {-1, 3, 5, 1, -6, -4, 0, 9};
            int values3[] = {-1, 3, 5, 1, -6, -4, 0, 9, 5, 12, 20, 4};
            int values4[] = {3, 5, 2, 9, 12, 5, 23, 23, -1, 3, 5, 1, -6, -4, 0, 9};
            State startingState = new State(0, values,0,0);

            System.out.println(minimax(startingState, 0, true));

    }
}
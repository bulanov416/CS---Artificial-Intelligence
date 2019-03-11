package AdversarialSearchProject;

public class minimaxAlphaBetaPruning {

    public static int max = 1000;
    public static int min = -1000;

    public static int minimax(State s, int depth, Boolean maxIsPlaying) {

        if (depth == s.height) {
            return s.values[s.index];
        }

        if (maxIsPlaying) {
            int idealValue = min;
            for (int i = 0; i < 2; i++)
            {
                int val = minimax(newState(s, 2, i, s.alphaValue, s.betaValue), depth + 1, false);
                idealValue = Math.max(idealValue, val);
                s.alphaValue = Math.max(s.alphaValue, idealValue);

                if (s.betaValue <= s.alphaValue) {
                    break;
                }
            }
            return idealValue;
        } else {
            int idealValue = max;
            for (int i = 0; i < 2; i++) {
                int currentVal = minimax(newState(s, 2, i, s.alphaValue, s.betaValue), depth + 1, true);
                idealValue = Math.min(idealValue, currentVal);
                s.betaValue = Math.min(s.betaValue, idealValue);

                if (s.betaValue <= s.alphaValue) {
                    break;
                }
            }
            return idealValue;
        }
    }

    public static State newState(State s, int mult, int add, int alpha, int beta) {
        State ns = new State(((s.index)*mult)+add, s.values, alpha, beta);
        return ns;
    }

    public static void main (String[] args) {
        int values[] = {3, 5, 6, 9, 1, 2, 0, -1};
        int values2[] = {3, 5, 2, 9, 12, 5, 23, 23};
        int values3[] = {-1, 3, 5, 1, -6, -4, 0, 9, 5, 12, 20, 4};
        int values4[] = {3, 5, 2, 9, 12, 5, 23, 23, -1, 3, 5, 1, -6, -4, 0, 9};
        State startingState = new State(0, values2, min, max);
        System.out.println(minimax(startingState, 0, true));
    }
}
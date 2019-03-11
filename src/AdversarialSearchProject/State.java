package AdversarialSearchProject;

public class State {

    public int index;
    public int[] values;
    double height;
    int alphaValue;
    int betaValue;

    public State(int ind, int[] vals, int alpha, int beta) {
        this.index = ind;
        this.values = vals;
        this.height = Math.log(vals.length)/Math.log(2);
        this.alphaValue = alpha;
        this.betaValue = beta;
    }
}

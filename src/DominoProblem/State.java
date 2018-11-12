package DominoProblem;

import java.util.ArrayList;

public class State {

    public String top;
    public String bottom;
    public ArrayList<String> dominoesNamed = new ArrayList<>();

    public State(String top, String bottom, ArrayList<String> dominoesNamed) {
        this.top = top;
        this.bottom = bottom;
        this.dominoesNamed = dominoesNamed;
    }

    //Getter Functions
    public String getTop() {
        return top;
    }

    public String getBottom() {
        return bottom;
    }

    //Setter Functions
    public void setTop(String top) {
        this.top = top;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public ArrayList<String> getDominoes() { return dominoesNamed; }

    public void setDominoes(ArrayList<String> dominoes) { this.dominoesNamed = dominoes; }

}
package FailedAttempts.Domino;

import FailedAttempts.Domino.Generic.State;

public class DominoState implements State {

    public String top;
    public String bottom;

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

    public String toString(String s) {

        return s.toString();

    }

}

package FailedAttempts.Domino.Generic;

import java.util.ArrayList;

public interface Problem {

    State getInitialState();
    boolean goalTest();
    ArrayList<Action> getActions();
    void result();

}

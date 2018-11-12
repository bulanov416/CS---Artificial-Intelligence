package DominoProblem;

public class Node {

    public State state = null;
    public Node parent = null;
    public Action action = null;
    public int pathCost = 0;

    //Constructor
    public Node(State state, Node parent, Action action, int pathCost) {
        this.state = state;
        this.parent = parent;
        this.action = action;
        this.pathCost = pathCost;
    }

    //Getter Functions
    public State getState() {
        return state;
    }

    public Node getParent() {
        return parent;
    }

    public Action getAction() {
        return action;
    }

    public int getPathCost() {
        return pathCost;
    }

    //Setter Functions
    public void setState(State state) {
        this.state = state;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public void setPathCost(int pathCost) {
        this.pathCost = pathCost;
    }

}

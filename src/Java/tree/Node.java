package tree;

import java.util.ArrayList;

public class Node {

    private int identifier;
    private ArrayList<Integer> children;


    public Node(int identifier) {
        this.identifier = identifier;
        children = new ArrayList<Integer>();
    }

    // Properties
    public int getIdentifier() {
        return identifier;
    }

    public ArrayList<Integer> getChildren() {
        return children;
    }

    // Public interface
    public void addChild(int identifier) {
        children.add(identifier);
    }

}
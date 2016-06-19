package tree;

/**
 * Created by Jilliankim on 6/1/16.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Tree {

    private final static int ROOT = 0;

    private HashMap<Integer, Node> nodes;
    private TraversalStrategy traversalStrategy;

    // Constructors
    public Tree() {
        this(TraversalStrategy.DEPTH_FIRST);
    }

    public Tree(TraversalStrategy traversalStrategy) {
        this.nodes = new HashMap<Integer, Node>();
        this.traversalStrategy = traversalStrategy;
    }

    // Properties
    public HashMap<Integer, Node> getNodes() {
        return nodes;
    }

    public TraversalStrategy getTraversalStrategy() {
        return traversalStrategy;
    }

    public void setTraversalStrategy(TraversalStrategy traversalStrategy) {
        this.traversalStrategy = traversalStrategy;
    }

    // Public interface
    public Node addNode(Integer identifier) {
        return this.addNode(identifier, null);
    }

    public Node addNode(Integer identifier, Integer parent) {
        Node node = new Node(identifier);
        nodes.put(identifier, node);

        if (parent != null) {
            nodes.get(parent).addChild(identifier);
        }

        return node;
    }

    public void display(Integer identifier) {
        this.display(identifier, ROOT);
    }

    public void display(Integer identifier, int depth) {
        ArrayList<Integer> children = nodes.get(identifier).getChildren();

        if (depth == ROOT) {
            System.out.println(nodes.get(identifier).getIdentifier());
        } else {
            String tabs = String.format("%0" + depth + "d", 0).replace("0", "    "); // 4 spaces
            System.out.println(tabs + nodes.get(identifier).getIdentifier());
        }
        depth++;
        for (int child : children) {

            // Recursive call
            this.display(child, depth);
        }
    }

    public Iterator<Node> iterator(Integer identifier) {
        return this.iterator(identifier, traversalStrategy);
    }

    public Iterator<Node> iterator(Integer identifier, TraversalStrategy traversalStrategy) {
        return traversalStrategy == TraversalStrategy.BREADTH_FIRST ?
                new BreathFirstTreeIterator(nodes, identifier) :
                new DepthFirstTreeIterator(nodes, identifier);
    }
}


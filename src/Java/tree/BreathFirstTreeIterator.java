package tree;

/**
 * Created by Jilliankim on 6/1/16.
 */
import java.util.*;

/*
 * See URL: http://en.wikipedia.org/wiki/Breadth-first_search
 */

public class BreathFirstTreeIterator implements Iterator<Node> {

    private static final int ROOT = 0;

    private LinkedList<Node> list;
    private HashMap<Integer, ArrayList<Integer>> levels;

    public BreathFirstTreeIterator(HashMap<Integer, Node> tree, Integer identifier) {
        list = new LinkedList<Node>();
        levels = new HashMap<Integer, ArrayList<Integer>>();

        if (tree.containsKey(identifier)) {
            this.buildList(tree, identifier, ROOT);

            for (Map.Entry<Integer, ArrayList<Integer>> entry : levels.entrySet()) {
                for (int child : entry.getValue()) {
                    list.add(tree.get(child));
                }
            }
        }
    }

    private void buildList(HashMap<Integer, Node> tree, Integer identifier, int level) {
        if (level == ROOT) {
            list.add(tree.get(identifier));
        }

        ArrayList<Integer> children = tree.get(identifier).getChildren();

        if (!levels.containsKey(level)) {
            levels.put(level, new ArrayList<Integer>());
        }
        for (int child : children) {
            levels.get(level).add(child);

            // Recursive call
            this.buildList(tree, child, level + 1);
        }
    }

    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }

    @Override
    public Node next() {
        return list.poll();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

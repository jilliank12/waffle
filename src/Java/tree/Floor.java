package tree;

import java.util.Iterator;

/**
 * Created by Jilliankim on 5/31/16.
 */
public class Floor {
    public static void main(String[] args) {

        Tree tree = new Tree();

        /*
         * The second parameter for the addNode method is the identifier
         * for the node's parent. In the case of the root node, either
         * null is provided or no second parameter is provided.
         */
        tree.addNode(3);
        tree.addNode(9, 3);
        tree.addNode(4, 3);
        tree.addNode(2, 9);
        tree.addNode(8, 2);
        tree.addNode(1, 8);
        tree.addNode(10, 4);
        tree.addNode(6, 4);
        tree.addNode(5, 4);
        tree.addNode(7, 6);


        tree.display(3);

        System.out.println("\n***** DEPTH-FIRST ITERATION *****");

        // Default traversal strategy is 'depth-first'
        Iterator<Node> depthIterator = tree.iterator(3);

        while (depthIterator.hasNext()) {
            Node node = depthIterator.next();
            System.out.println(node.getIdentifier());
        }

        System.out.println("\n***** BREADTH-FIRST ITERATION *****");

        Iterator<Node> breadthIterator = tree.iterator(3, TraversalStrategy.BREADTH_FIRST);

        while (breadthIterator.hasNext()) {
            Node node = breadthIterator.next();
            System.out.println(node.getIdentifier());
        }
    }
}

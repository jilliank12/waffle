package DSinsight.chapter6;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Jilliankim on 11/2/15.
 *
 */
public class InOrderIterative {

    public ArrayList<Integer> inorderTraversal(BinaryTreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<BinaryTreeNode> treeStack = new Stack<BinaryTreeNode>();
        BinaryTreeNode currentNode = root;
        boolean done = false;
        while (!done) {
            if (currentNode != null) {
                treeStack.push(currentNode);
                currentNode = currentNode.getLeft();
            } else {
                if (treeStack.isEmpty()) {
                    done = true;
                } else {
                    currentNode = treeStack.pop();
                    result.add(currentNode.data);
                    currentNode = currentNode.right;
                }
            }
        }
        return result;
    }

}

package DSinsight.chapter6;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Jilliankim on 11/2/15.
 */
public class PostorderIterative {
    public ArrayList<Integer> postorderTraversal(BinaryTreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<BinaryTreeNode> treeStack = new Stack<BinaryTreeNode>();
        treeStack.push(root);
        BinaryTreeNode previous = null;
        while (!treeStack.isEmpty()) {
            BinaryTreeNode currentNode = treeStack.peek();
            //traverse from top to bottom, and if current node has left or right child,
            //push into the stack; otherwise, pop
            if (previous == null || previous.getLeft() == currentNode || previous.right == currentNode) {
                if (currentNode.getLeft() != null) {
                    treeStack.push(currentNode.getLeft());
                } else if (currentNode.right != null) {
                    treeStack.push(currentNode.right);
                }
            } else if (currentNode.getLeft() == previous) {
                if (currentNode.right != null) {
                    treeStack.push(currentNode.right);
                }
            } else {
                result.add(currentNode.data);
                treeStack.pop();
            }
            previous = currentNode;
        }
        return result;
    }

}

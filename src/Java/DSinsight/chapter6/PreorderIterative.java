package DSinsight.chapter6;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Jilliankim on 11/2/15.
 * requires a stack implementation
 * iterative preorder search requires the information about the node
 */
public class PreorderIterative {

    public ArrayList<Integer> preorderTraversal(BinaryTreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<BinaryTreeNode> treeStack = new Stack<BinaryTreeNode>();
        treeStack.push(root);
        while (!treeStack.isEmpty()) {
            BinaryTreeNode temp = treeStack.pop();
            result.add(temp.data);
            if (temp.right != null) {
                treeStack.push(temp.right);
            }
            if (temp.getLeft() != null) {
                treeStack.push(temp.getLeft());
            }
        }
        return result;
    }

}

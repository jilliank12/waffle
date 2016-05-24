package DSinsight.chapter6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Jilliankim on 11/2/15.
 * level order traversal
 * visit root
 * while visiting level l, push all nodes in level l+1
 * go to the next level, and visit all nodes in that level
 * repeat until the end of levels
 */
public class LevelOrder {
    public ArrayList<ArrayList<Integer>> levelOrder(BinaryTreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.offer(root);
        queue.offer(null);
        ArrayList<Integer> current = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            BinaryTreeNode temp = queue.poll();
            if (temp != null) {
                current.add(temp.data);
                if (temp.getLeft() != null) {
                    queue.offer(temp.getLeft());
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            } else {
                ArrayList<Integer> c_curr = new ArrayList<Integer>(current);
                result.add(c_curr);
                current.clear();
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            }
        }
        return result;
    }

}

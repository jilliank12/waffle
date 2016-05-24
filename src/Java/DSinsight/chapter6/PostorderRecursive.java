package DSinsight.chapter6;

/**
 * Created by Jilliankim on 11/2/15.
 * post order tree traversal method
 * visit left, right, then the node
 */
public class PostorderRecursive {
    public void postorder(BinaryTreeNode root) {
        if (root != null) {
            postorder(root.getLeft());
            postorder(root.getRight());
            System.out.println(root.getData());
        }
    }
}

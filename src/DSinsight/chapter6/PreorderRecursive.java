package DSinsight.chapter6;

/**
 * Created by Jilliankim on 11/2/15.
 * Visit root, then search for the left side and the right side
 */
public class PreorderRecursive {

    public void PreOrder(BinaryTreeNode root) {
        if (root != null) {
            System.out.println(root.data);
            PreOrder(root.getLeft());
            PreOrder(root.getRight());
        }
    }

}

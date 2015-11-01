package DSinsight.chapter6;

/**
 * Created by Jilliankim on 11/2/15.
 * In order recursive search
 * visit left first, root, then the right leaf
 */
public class InOrderRecursive {

    public void inOrder(BinaryTreeNode root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.println(root.getData());
            inOrder(root.getRight());
        }

    }
}

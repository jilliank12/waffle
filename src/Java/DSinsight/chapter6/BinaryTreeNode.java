package DSinsight.chapter6;

/**
 * Created by Jilliankim on 11/1/15.
 */
public class BinaryTreeNode {
    public int data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    //default constructor
    public BinaryTreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public String toString1() {
        return Integer.toString(data);
    }

    public void setValue(int data) {
        this.data = data;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    //find if the root contains the data argument within itself
    public static boolean findInTree(BinaryTreeNode root, int data) {
        if (root == null) {
            return false;
        }
        if (root.getData() == data) {
            return true;
        }
        return findInTree(root.getLeft(), data) || findInTree(root.getRight(), data);
    }

    //return the string representation of this tree
    public String toString() {
        if (isLeaf()) {
            return this.toString1();
        } else {
            String root, left = "null", right = "null";
            root = this.toString1();
            if (getLeft() != null) {
                left = getLeft().toString();
            }
            if (getRight() != null) {
                right = getRight().toString();
            }
            return root + " (" + left + ", " + right + ")";
        }
    }

    public int hashCode() {
        int result = this.hashCode();
        if (left != null) {
            result += 3 * left.hashCode();
        }
        if (right != null) {
            result += 7 * right.hashCode();
        }
        return result;
    }

    public int numberOfNodes() {
        int leftCount = this.left == null ? 0 : left.numberOfNodes();
        int rightCount = this.right == null ? 0 : right.numberOfNodes();
        return 1 + leftCount + rightCount;
    }

    //copy to make an identical tree
    public BinaryTreeNode copy() {
        BinaryTreeNode left = null, right = null;
        if (this.left != null) {
            left = this.left.copy();
        }
        if (this.right != null) {
            right = this.right.copy();
        }
        return new BinaryTreeNode(this.data, left, right);
    }

    public BinaryTreeNode reverse() {
        BinaryTreeNode left = null, right = null;
        if (this.left != null) {
            left = this.left.reverse();
        }
        if (this.right != null) {
            right = this.right.reverse();
        }
        return new BinaryTreeNode(this.data, right, left);
    }

    public void reverseInPlace() {
        if (this.left != null) {
            left.reverseInPlace();
        }
        if (this.right != null) {
            right.reverseInPlace();
        }
        BinaryTreeNode temp = this.left;
        this.setLeft(this.right);
        this.setRight(temp);
    }





}

package geeksforgeeks;

/**
 * Created by Jilliankim on 6/21/16.
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        Node n1 = new Node(5);
        root.left.left = n1;
        root.left.right = new Node(13);
        Node n2 = new Node(14);
        root.left.right.right = n2;
        root.left.right.left = new Node(12);

        LowestCommonAncestor i = new LowestCommonAncestor();
        System.out.println("Recursive-Lowest Common Ancestor of Nodes "
                + n1.data + " and " + n2.data + " is : "
                + i.lca(root, n1, n2).data);

        Node x = i.lcaIterative(root, n1, n2);
        System.out.println("Iterative-Lowest Common Ancestor of Nodes "
                + n1.data + " and " + n2.data + " is : " + x.data);

    }

    public static Node lcaIterative(Node root, Node n1, Node n2) {
        while (root != null) {
            if (root.data > n1.data && root.data > n2.data) {
                root = root.left;
            } else if (root.data < n1.data && root.data < n2.data) {
                root = root.right;
            } else {
                return root;
            }
        }
        return root;
    }

    public static Node lca(Node root, Node n1, Node n2) {
        if (root == null) return root;
        if (root.data > n1.data && root.data > n2.data) {
            return lca(root.left, n1, n2);
        } else if (root.data <= n1.data && root.data <= n2.data) {
            return lca(root.right, n1, n2);
        }
        return root;
    }
}

class Node {
    int data;
    Node left;
    Node right;
    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

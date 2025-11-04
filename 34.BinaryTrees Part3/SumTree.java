class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class SumTree {

    public static int transform(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = transform(root.left);
        int rightSum = transform(root.right);

        int oldValue = root.data;

        // Set current node to sum of left and right subtrees
        root.data = leftSum + rightSum;

        // Return total sum of subtree (including original node value)
        return oldValue + root.data;
    }

    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(-2);
        root.right = new Node(6);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);
        root.right.left = new Node(7);
        root.right.right = new Node(5);

        System.out.println("Inorder traversal before transformation:");
        inorder(root);

        transform(root);

        System.out.println("\nInorder traversal after transformation:");
        inorder(root);
    }
}

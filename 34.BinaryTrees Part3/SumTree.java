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

        // Store old value
        int old_val = root.data;

        // Recursively transform left and right subtrees
        int left_sum = transform(root.left);
        int right_sum = transform(root.right);

        // Update current node's data
        root.data = left_sum + right_sum;

        // Return sum of values under this subtree including the node's original value
        return root.data + old_val;
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

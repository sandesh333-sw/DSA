class Node {
    int val;
    Node left, right;

    Node(int value) {
        this.val = value;
        left = right = null;
    }
}

public class Diameter {

    // Helper class to store both diameter and height
    static class Info {
        int diam;
        int ht;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    // Optimized recursive function to compute diameter and height
    public static Info diameter(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht+ rightInfo.ht  +1 );
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diam, ht);
    }

    public static void main(String[] args) {
        // Build the tree:
        //         1
        //        / \
        //       2   3
        //      / \     
        //     4   5
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Diameter of the tree: " + diameter(root).diam);
    }
}

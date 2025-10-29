public class KthAncestor {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static int KAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0; // found the node
        }

        int leftDist = KAncestor(root.left, n, k);
        int rightDist = KAncestor(root.right, n, k);

        if (leftDist == -1 && rightDist == -1) {
            return -1; // node not found in either subtree
        }

        int max = Math.max(leftDist, rightDist);

        // when the current node is the kth ancestor
        if (max + 1 == k) {
            System.out.println("Kth ancestor is: " + root.data);
        }

        return max + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Example:
        // Tree:
        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    4  5  6  7
        //
        // 2nd ancestor of 4 = 1

        KAncestor(root, 4, 2);
    }
}

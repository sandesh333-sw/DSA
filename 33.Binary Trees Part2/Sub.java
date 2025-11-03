class Node {
    int val;
    Node left, right;

    Node(int value) {
        this.val = value;
        left = right = null;
    }
}

public class Sub {


    //to check if two trees are identical or not
    public static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        }
        if (node == null || subRoot == null || node.val != subRoot.val) {
            return false;
        }

        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }

        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }

        return true;
    }


    //to find the subroot in main tree
    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }
        if (root.val == subRoot.val) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        boolean leftAns = isSubtree(root.left, subRoot);
        boolean rightAns = isSubtree(root.right, subRoot);

        return leftAns || rightAns;
    }

    public static void main(String[] args) {
        // Main tree:
        //         1
        //        / \
        //       2   3
        //      / \  / \  
        //     4   5 6  7
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Subtree:
        //     2  
        //    / \    
        //   4   5
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        // Test
        System.out.println("Is subtree: " + isSubtree(root, subRoot));  // Expected: true
    }
}

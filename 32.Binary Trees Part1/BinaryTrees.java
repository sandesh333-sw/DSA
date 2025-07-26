import java.util.*;


public class BinaryTrees {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Binary {
        static int idx = -1;

        // Build tree from array
        public static Node buildTree(int[] nodes) {
            idx++;
            if (idx >= nodes.length || nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        // Preorder Traversal
        public static void preorder(Node root) {
            if (root == null) {
                return;
            }

            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        //Inorder Traversal
        public static void inorder(Node root){
            if(root == null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        //Postorder Traversal
        public static void postorder(Node root) {
           if (root == null) {
             return;
             }

             postorder(root.left);
             postorder(root.right);
             System.out.print(root.data + " ");
            }

            //Level Order Traversal
            // Level Order Traversal
public static void levelOrder(Node root) {
    if (root == null) {
        return;
    }

    Queue<Node> q = new LinkedList<>();
    q.add(root);
    q.add(null); // Marker for end of level

    while (!q.isEmpty()) {
        Node currNode = q.remove();

        if (currNode == null) {
            System.out.println(); // End of current level
            if (q.isEmpty()) {
                break;
            } else {
                q.add(null); // Add marker for next level
            }
        } else {
            System.out.print(currNode.data + " ");
            if (currNode.left != null) {
                q.add(currNode.left);
            }
            if (currNode.right != null) {
                q.add(currNode.right);
            }
        }
    }
}


    }

    public static void main(String args[]) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Binary.idx = -1; // reset index before building
        Node root = Binary.buildTree(nodes);

        System.out.println("Preorder traversal:");
        //Binary.preorder(root);
        Binary.inorder(root);
    }
}

import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class LowestCA1 {

    // Finds path from root to the node n and stores the path in the ArrayList
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }

        path.add(root);

        if (root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if(foundLeft || foundRight){
            return true;
        }

        path.remove(path.size() - 1); // backtrack
        return false;
    }

    // LCA using path comparison
    
    public static Node Lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        boolean getPath1 = getPath(root, n1, path1);
        boolean getPath2 = getPath(root, n2, path2);

        if(!getPath1 || !getPath2){
            return null;
        }

        // Compare the paths to find the last common node
        int i = 0;
        while (i < path1.size() && i < path2.size()) {
            if (path1.get(i).data != path2.get(i).data) {
                break;
            }
            i++;
        }

        return path1.get(i - 1); // Last common ancestor
    }
  
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node lca = Lca(root, 4, 5);
        if (lca != null) {
            System.out.println("LCA of 4 and 5 is: " + lca.data);
        } else {
            System.out.println("LCA not found.");
        }
    }
}

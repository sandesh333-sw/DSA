
import java.util.ArrayList;

class Node{
    int data;
    Node left, right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}


public class Build{

    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            //left subtree
            root.left = insert(root.left, val);

        } else {
            //right subtree
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }

        if(root.data > key){
            return search(root.left, key);
        }
        else {
            return search(root.right, key);
        }
    }


    public static void printInRange(Node root, int k1, int k2){

        if(root == null){
            return;
        }
        if(root.data >= k1 && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+ " ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data < k1){
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    public static void printPath(ArrayList<Integer> path){
        for(int i=0; i<path.size(); i++){
            System.out.print(path.get(i)+ "-->");
        }
        System.out.println("Null");
    }

    public static void printRoot2leef(Node root, ArrayList<Integer> path){

        if (root == null){
            return;
        }
        if(root.left == null && root.right == null){
            printPath(path);
        }
        path.add(root.data);
        printRoot2leef(root.left, path);
        printRoot2leef(root.right, path);
        path.remove(path.size()-1);
    }


    public static boolean isValidBST(Node root, Node min, Node max){
        if(root == null){
            return true;
        }
        if(min != null && root.data <= min.data){
            return false;
        }
        else if(max != null && root.data >= max.data){
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
    public static void main(String args[]){
        int[] values = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for(int i=0; i<values.length; i++){
            root = insert(root, values[i]);
        }
        inorder(root);
        // if(search(root, 8)){
        //     System.out.println("Found");
        // } else {
        //     System.out.println("Not found");
        // }
        //printRoot2leef(root, new ArrayList<>());

        if(isValidBST(root, null, null)){
            System.out.println("valid");
        } else {
            System.out.println("not valid");
        }
    }
}
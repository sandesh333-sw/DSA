public class Height {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    //find height of tree
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        int maxH = Math.max(lh, rh) + 1;
        return maxH;
    }

    //find count of tree
    public static int count(Node root){
        if(root == null){
            return 0;
        }

        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount+rightCount+1;
    }

    //sum of tree
    public static int sum(Node root){
        if(root == null){
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSumn = sum(root.right);
        return leftSum+rightSumn+root.data;
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(height(root));
    }
}

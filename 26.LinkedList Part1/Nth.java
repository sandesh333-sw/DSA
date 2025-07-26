public class Nth {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int sz;

    public void addFirst(int data){

        Node newNode = new Node(data);
        sz++;

        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void printLL(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println();
    }

    public static int removeNth(int n){
        
    }
    public static void main(String args[]){
        Nth pr = new Nth();
        pr.addFirst(1);
        pr.addFirst(2);
        pr.addFirst(3);
        pr.addFirst(4);
        pr.addFirst(5);
        pr.printLL();
    }
}

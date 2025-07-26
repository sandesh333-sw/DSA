public class Practise {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;
    

    //Add First
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    //Add Last
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    //Print LL
    public void printL(){
        if(head == null){
            System.out.println("LL is empty");
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "-->");

            temp = temp.next;
        }
        System.out.println();
    }

    //Add in the midddle
    public void addMiddle(int data, int idx){
        if (idx == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i =0;
        while( i < idx - 1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    //Remove first 
    public int removeFirst(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1){
            int val = head.data;
            head = tail = null;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public static int SearchLL(int key){

        Node itr = head;
        int i = 0;
        while( itr != null){
            if( itr.data == key){
                return i;
            }
            itr = itr.next;
            i++;
        }
        return -1;
    }

    public static void main(String args[]){
        Practise ll = new Practise();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        System.out.println("Before adding in middle");
        ll.printL();
        
        ll.addMiddle(9, 1);
        System.out.println("After adding in middle");
        ll.printL();
       System.out.println(SearchLL(9));

    }
}

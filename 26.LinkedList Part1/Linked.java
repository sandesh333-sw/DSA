
public class Linked {
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
    public static int size;

    //Methods

    //Adding a linked list in front
    public void addFirst(int data){

        //step1= create new node
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail= newNode;
            return;
        }

        //step2
        newNode.next = head;

        //step3
        head = newNode;
    }

    //Adding in last
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

    //Print a linked list
    public void print(){
        if(head == null){
            System.out.println("LL is empty");
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+ " -->");
            temp = temp.next;
        }
        System.out.println();
    }
    //Add in the middle
    public void add(int idx, int data){
        if(idx ==0){
            addFirst(data);
            return;  
        }

        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i=0;

        while(i < idx-1){
            temp = temp.next;
            i++;
        }
        //i = idx-1; temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    //Remove First Element
    public int removeFirst(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    //Remove last
    public int removeLast(){
        if(size ==0){
            System.out.println("LL is empty");
             return Integer.MIN_VALUE;

        } else if(size ==1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for(int i=0; i<size-2; i++){
            prev = prev.next;
        }

        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int itrSearch(int key){
        Node temp = head;
        int i = 0;

        while(temp != null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    //reverse
    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        head = prev;
    }

        //Remove nth from end
        public void deleteNth(int n){
            int sz = 0;
            Node temp = head;
            while(temp != null){
                temp = temp.next;
                sz++;
            }
            if(n == sz){
                head = head.next;
                return;
            }
            //sz-n
            int i= 1;
            Node nod = head;
            int iToFind = sz-n;
            while( i< iToFind){
                nod = nod.next;
                i++;
            }
            nod.next = nod.next.next;
            return;
        }
    //Palindrome

    //Slow-Fast Approach
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow;
    }

    public boolean CPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        //step1-find mid
        Node midNode = findMid(head);


        //step2 - reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;

        //step3-check left half and right half
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;

    }
     
    public static void main(String args[]){
        Linked ll = new Linked();
    
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(1);
        ll.addLast(3);
        
        ll.print();
        System.out.println(ll.CPalindrome());
       

        
    }
}
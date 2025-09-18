class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class MergeSort {
    Node head; // class-level head

    public Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;  
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node merge(Node head1, Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;  
            }
            temp = temp.next;
        }

        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public Node mergeSort(Node head){
        if(head == null || head.next == null){ 
            return head;
        }

        Node mid = getMid(head);

        Node rightHead = mid.next;
        mid.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(rightHead);

        return merge(left, right);
    }

    // Zig-Zag Reordering
    public void zigZag(){
        if (head == null || head.next == null) return;

        // find mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        // merge in zigzag fashion
        while(left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeSort ll = new MergeSort();

        // Create linked list: 4 -> 2 -> 1 -> 3
        ll.head = new Node(4);
        ll.head.next = new Node(2);
        ll.head.next.next = new Node(1);
        ll.head.next.next.next = new Node(3);

        // Sort the linked list
        ll.head = ll.mergeSort(ll.head);
        System.out.print("Sorted: ");
        printList(ll.head);

        // ZigZag reorder
        ll.zigZag();
        System.out.print("ZigZag: ");
        printList(ll.head);
    }
}

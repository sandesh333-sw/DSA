
class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class MergeSort {

    public Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;  // start fast at head.next to get first middle node for even length
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
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;  // FIXED this line
                temp = temp.next;
            }
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
        if(head == null || head.next == null){  // FIXED base case condition
            return head;
        }

        // find mid node
        Node mid = getMid(head);

        // split into two halves
        Node rightHead = mid.next;
        mid.next = null;

        // recursive calls for left and right halves
        Node left = mergeSort(head);
        Node right = mergeSort(rightHead);

        // merge sorted halves
        return merge(left, right);
    }

    public static void main(String[] args) {
    MergeSort ll = new MergeSort();

    // Create linked list: 4 -> 2 -> 1 -> 3
    Node head = new Node(4);
    head.next = new Node(2);
    head.next.next = new Node(1);
    head.next.next.next = new Node(3);

    // Sort the linked list
    Node sortedHead = ll.mergeSort(head);

    // Print sorted list
    printList(sortedHead);
}

// Helper function to print the list
public static void printList(Node head) {
    Node curr = head;
    while (curr != null) {
        System.out.print(curr.data + " ");
        curr = curr.next;
    }
    System.out.println();
}

}

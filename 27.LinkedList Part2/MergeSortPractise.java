class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeSortPractise {

    // Merge two sorted linked lists
    public static Node merge(Node h1, Node h2) {
        Node mergeLL = new Node(-1); // dummy node
        Node temp = mergeLL;

        while (h1 != null && h2 != null) {
            if (h1.data <= h2.data) {
                temp.next = h1;
                h1 = h1.next;
            } else {
                temp.next = h2;
                h2 = h2.next;
            }
            temp = temp.next;
        }

        // Attach remaining nodes
        while (h1 != null) {
            temp.next = h1;
            h1 = h1.next;
            temp = temp.next;
        }

        while (h2 != null) {
            temp.next = h2;
            h2 = h2.next;
            temp = temp.next;
        }

        return mergeLL.next;
    }

    // Find the middle node
    public static Node midNode(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Merge Sort on linked list
    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Find mid
        Node mid = midNode(head);

        // Split into two halves
        Node rightHalf = mid.next;
        mid.next = null;

        // Recursively sort both halves
        Node left = mergeSort(head);
        Node right = mergeSort(rightHalf);

        // Merge the sorted halves
        return merge(left, right);
    }

    // Print linked list
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        // Create linked list: 4 -> 2 -> 1 -> 3
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);

        // Sort list
        head = mergeSort(head);

        // Print result
        printList(head); // Output: 1 2 3 4
    }
}

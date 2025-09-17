public class List {
    // Node class
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Linked List fields
    public static Node head;
    public static Node tail;
    public static int size;

    // ================================
    // Methods
    // ================================

    // Add node at the front
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Add node at the end
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // Print linked list
    public void print() {
        if (head == null) {
            System.out.println("LL is empty");
            return; // stop here
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Detect cycle using Floyd’s algorithm
    public boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // cycle found
            }
        }
        return false;
    }

    // Remove cycle if present
    public static void removeCycle() {
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        // 1. Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        if (!cycle) return; // no cycle

        // 2. Find start of cycle
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // 3. Break the cycle
        prev.next = null;
    }

    // ================================
    // Main (Demo)
    // ================================
    public static void main(String[] args) {
        List ll = new List();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        // Create a cycle manually: tail → node with value 3
        ll.tail.next = ll.head.next.next; // 5 → 3

        System.out.println("Cycle present? " + ll.isCycle()); // true

        removeCycle();

        System.out.println("Cycle present after removal? " + ll.isCycle()); // false

        ll.print(); // 1 --> 2 --> 3 --> 4 --> 5 --> null
    }
}

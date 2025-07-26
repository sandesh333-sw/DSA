public class QLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty(){
            return head == null && tail == null;
        }

        // Add (enqueue)
        public static void add(int data){
            Node newNode = new Node(data); // fixed variable name
            if (head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        // Remove (dequeue)
        public static int remove(){
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int front = head.data;
            if (head == tail) { // only one element
                head = tail = null;
            } else {
                head = head.next;
            }
            return front;
        }

        // Peek (front)
        public static int peek(){
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data;
        }

        // Display
        public static void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            Node current = head;
            System.out.print("Queue: ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Queue.add(10);
        Queue.add(20);
        Queue.add(30);
        Queue.display(); // Queue: 10 20 30

        System.out.println("Peek: " + Queue.peek()); // Peek: 10

        System.out.println("Removed: " + Queue.remove()); // Removed: 10
        Queue.display(); // Queue: 20 30
    }
}

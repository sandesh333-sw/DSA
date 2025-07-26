import java.util.Stack;

public class QueueTwoStack {
    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        // Check if the queue is empty
        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        // Enqueue: Costly enqueue approach
        public static void add(int data) {
            // Move all elements from s1 to s2
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            // Push new data to s1
            s1.push(data);

            // Move everything back to s1
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        // Dequeue: remove from front of queue
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.pop();
        }

        // Peek: get the front element
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.peek();
        }
    }

    public static void main(String[] args) {
        Queue.add(10);
        Queue.add(20);
        Queue.add(30);

        System.out.println("Peek: " + Queue.peek());   // 10
        System.out.println("Removed: " + Queue.remove()); // 10
        System.out.println("Peek after remove: " + Queue.peek()); // 20
    }
}

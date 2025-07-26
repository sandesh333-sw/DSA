public class Arrays {

    static class LinearQueue {
        int[] queue;
        int front, rear, size;

        public LinearQueue(int size) {
            this.size = size;
            queue = new int[size];
            front = 0;
            rear = -1;
        }

        public boolean isFull() {
            return rear == size - 1;
        }

        public boolean isEmpty() {
            return front > rear;
        }

        public void enqueue(int value) {
            if (isFull()) {
                System.out.println("Queue is full");
            } else {
                queue[++rear] = value;
            }
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            } else {
                return queue[front++];
            }
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
            } else {
                for (int i = front; i <= rear; i++) {
                    System.out.print(queue[i] + " ");
                }
                System.out.println();
            }
        }
    
    static class CircularQueue {
        int[] queue;
        int front, rear, size;
        int count;

        public CircularQueue(int size) {
            this.size = size;
            queue = new int[size];
            front = 0;
            rear = -1;
            count = 0;
        }

        public boolean isFull() {
            return count == size;
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public void enqueue(int value) {
            if (isFull()) {
                System.out.println("Circular Queue is full");
            } else {
                rear = (rear + 1) % size;
                queue[rear] = value;
                count++;
            }
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Circular Queue is empty");
                return -1;
            } else {
                int val = queue[front];
                front = (front + 1) % size;
                count--;
                return val;
            }
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Circular Queue is empty");
            } else {
                System.out.print("Circular Queue: ");
                for (int i = 0; i < count; i++) {
                    System.out.print(queue[(front + i) % size] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Linear Queue Demo:");
        LinearQueue lq = new LinearQueue(5);
        lq.enqueue(10);
        lq.enqueue(20);
        lq.enqueue(30);
        lq.display();
        lq.dequeue();
        lq.display();

        System.out.println("\nCircular Queue Demo:");
        CircularQueue cq = new CircularQueue(5);
        cq.enqueue(1);
        cq.enqueue(2);
        cq.enqueue(3);
        cq.enqueue(4);
        cq.enqueue(5);
        cq.display();
        cq.dequeue();
        cq.dequeue();
        cq.enqueue(6);
        cq.enqueue(7);
        cq.display();
    }
}
}

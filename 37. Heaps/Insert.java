import java.util.*;

public class Insert {

    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        //1. Add a new element to the heap last 
        public void add(int data) {
            arr.add(data);
            int x = arr.size() - 1; // child index
            int par = (x-1)/2;

            while(arr.get(x) < arr.get(par)){
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
            }
        }

        //2.  Peek (get min value)
        public int peek() {
            return arr.get(0);
        }

        // Heapify to maintain min-heap property 2
        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if (left < arr.size() && arr.get(left) < arr.get(minIdx)) {
                minIdx = left;
            }
            if (right < arr.size() && arr.get(right) < arr.get(minIdx)) {
                minIdx = right;
            }

            if (minIdx != i) {
                // Swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                // Recursively heapify the affected subtree
                heapify(minIdx);
            }
        }

        //3 Remove and return the smallest element 1
        public int remove() {
            if (arr.isEmpty()) {
                throw new NoSuchElementException("Heap is empty.");
            }

            int data = arr.get(0);

            // Swap root with last element step1
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // Remove last element step2
            arr.remove(arr.size() - 1);

            // Heapify from root
            if (!arr.isEmpty()) {
                heapify(0);
            }

            return data;
        }

        // Check if heap is empty
        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    // Main method to test heap
    public static void main(String[] args) {
        Heap heap = new Heap();

        // Insert elements
        heap.add(3);
        heap.add(4);
        heap.add(1);
        heap.add(5);
        heap.add(2);

        // Remove elements (should come out in sorted order)
        System.out.println("Heap elements in ascending order:");
        while (!heap.isEmpty()) {
            System.out.print(heap.remove() + " ");
        }
    }
}

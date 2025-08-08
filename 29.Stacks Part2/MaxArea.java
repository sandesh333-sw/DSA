import java.util.Stack;

public class MaxArea {

    public static void maxArea(int[] arr) {
        int n = arr.length;
        int maxArea = 0;
        int[] nsr = new int[n];
        int[] nsl = new int[n];

        // Next Smaller Right
        Stack<Integer> stackRight = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stackRight.isEmpty() && arr[stackRight.peek()] >= arr[i]) {
                stackRight.pop();
            }
            if (stackRight.isEmpty()) {
                nsr[i] = n; // boundary
            } else {
                nsr[i] = stackRight.peek();
            }
            stackRight.push(i);
        }

        // Next Smaller Left
        Stack<Integer> stackLeft = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stackLeft.isEmpty() && arr[stackLeft.peek()] >= arr[i]) {
                stackLeft.pop();
            }
            if (stackLeft.isEmpty()) {
                nsl[i] = -1; // boundary
            } else {
                nsl[i] = stackLeft.peek();
            }
            stackLeft.push(i);
        }

        // Calculate max area
        for (int i = 0; i < n; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(maxArea, currArea);
        }

        System.out.println("Max Area = " + maxArea);
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        maxArea(arr); // Expected: 10
    }
}

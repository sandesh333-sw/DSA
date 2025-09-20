import java.util.*;

public class Practise {

    // Pushes an element at the bottom of the stack
    public static void pushBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushBottom(s, data);
        s.push(top);
    }

    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();

        // Push some elements
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("Original stack: " + s);

        // Push 0 at the bottom
        pushBottom(s, 0);

        System.out.println("After pushing 0 at bottom: " + s);
    }
}

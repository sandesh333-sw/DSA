import java.util.Stack;

public class PushBottom {
    public static void Bottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();
        Bottom(s, data);
        s.push(top); 
    }
    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2); 

        System.out.println("Original Stack: " + s);

        Bottom(s, 0);

        System.out.println("After pushing to bottom: " + s);
    }
}

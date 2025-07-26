import java.util.ArrayList;

public class Stack {

    static class Stacks {
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty() {
            return list.size() == 0;
        }

        // push
        public static void push(int data) {
            list.add(data);
        }

        // pop
        public static int pop() {
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        // peek
        public static int peek() {
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }

    public static void main(String args[]) {
        // Call static methods of Stacks directly
        Stacks.push(1);
        Stacks.push(2);
        Stacks.push(3);

        while (!Stacks.isEmpty()) {
            System.out.println(Stacks.peek());
            Stacks.pop();
        }
    }
}

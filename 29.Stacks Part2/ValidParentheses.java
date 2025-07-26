import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                if (s.isEmpty()) {
                    return false;
                }
                if ((s.peek() == '(' && ch == ')') ||
                    (s.peek() == '{' && ch == '}') ||
                    (s.peek() == '[' && ch == ']')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }

        return s.isEmpty(); // Return true if stack is empty at the end
    }

   public static boolean isDuplicate(String str) {
    Stack<Character> s = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);

        // closing bracket
        if (ch == ')') {
            int count = 0;
            while (!s.isEmpty() && s.peek() != '(') {
                s.pop();
                count++;
            }

            if (!s.isEmpty()) {
                s.pop(); // pop the opening '('
            }

            if (count < 1) {
                return true; // duplicate found
            }

        } else {
            // opening bracket or any character
            s.push(ch);
        }
    }

    return false; // no duplicate found
}


    public static void main(String[] args) {
        String str = "({})[]";
        System.out.println("Is valid? " + isValid(str)); // Output: true

        String str1 = "({})[]";
        System.out.println("Is valid? " + isValid(str1)); // true

        String str2 = "((a+b))";
        System.out.println("Has duplicate? " + isDuplicate(str2)); // true

       String str3 = "(a+(b)/c)";
       System.out.println("Has duplicate? " + isDuplicate(str3)); // false
    }
}

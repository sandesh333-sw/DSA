import java.util.Stack;

public class ReverseS {

    public static void PushBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        PushBottom(s, data);
        s.push(top);
    }
    public static void Reverse(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        Reverse(s);
        PushBottom(s, top);
    }
    public static void main(String args[]){
         Stack<Integer> s = new Stack<>();

         s.push(1);
         s.push(2);
         s.push(3);
         
    }
}

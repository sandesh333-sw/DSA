import java.util.Stack;

public class NextGreater {
    public static void main(String args[]){
        int[] arr = {6,8,0,1,3};
        Stack<Integer> s = new Stack<>();
        int[] nGreater = new int[arr.length];

        for(int i=arr.length-1; i>=0; i--){
            //while
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }


            //if else
            if(s.isEmpty()){
                nGreater[i] = -1;

            } else {
                nGreater[i] = arr[s.peek()];
            }

            //push in stack
            s.push(i);
        }

        for(int i=0; i<nGreater.length; i++){
            System.out.print(nGreater[i] + " ");
        }
    }
}

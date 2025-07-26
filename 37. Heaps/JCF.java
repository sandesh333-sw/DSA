
import java.util.PriorityQueue;

public class JCF{
    public static void mainn(String args[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(3);
        pq.add(2);
        pq.add(5);

        while(!pq.isEmpty()){
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
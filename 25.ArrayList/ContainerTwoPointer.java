import java.util.*;
public class ContainerTwoPointer {
    public static int Water(ArrayList<Integer> height){
        int maxW = 0;
        int lp = 0;
        int rp = height.size() - 1;
        while(lp < rp){
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp - lp;
            int currW = ht * width;
            maxW = Math.max(maxW, currW);

            if(height.get(lp) < height.get(rp)){
                lp++;
            } else {
                rp--;
            }
        }
        return maxW;

    }
    public static void main(String args[]){
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        int result = Water(height);
        System.out.println("Maximum water that can be stored: " + result);
    }
}

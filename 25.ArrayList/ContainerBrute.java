import java.util.*;

public class ContainerBrute {
    public static int StoreWater(ArrayList<Integer> height){
        int maxheight = 0;
        for(int i = 0; i < height.size(); i++){
            for(int j = i + 1; j < height.size(); j++){
                int ht = Math.min(height.get(i), height.get(j));
                int wd = j - i; 
                int currWater = ht * wd;
                maxheight = Math.max(maxheight, currWater);
            }
        }
        return maxheight;
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

        int maxWater = StoreWater(height);
        System.out.println("Maximum water that can be stored: " + maxWater);
    }
}

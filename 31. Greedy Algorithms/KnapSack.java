import java.util.Arrays;
import java.util.Comparator;

public class KnapSack {
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int W = 50; // capacity

        double[][] ratio = new double[val.length][2]; // [index, ratio]

        // Calculate ratio = value/weight
        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i];
        }

        // Sort by ratio (ascending)
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        double finalVal = 0;
        int capacity = W;

        // Pick items from highest ratio
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) {
                // Take whole item
                capacity -= weight[idx];
                finalVal += val[idx];
            } else {
                // Take fraction of item
                finalVal += val[idx] * (capacity / (double) weight[idx]);
                break;
            }
        }

        System.out.println("Maximum value in Knapsack = " + finalVal);
    }
}

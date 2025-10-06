import java.util.*;

public class Pairs {
    public static void main(String args[]) {
        int[][] pairs = { {5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90} };

        // Sort pairs by the second element
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));

        int chainLen = 1;
        int chainEnd = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > chainEnd) {
                chainLen++;
                chainEnd = pairs[i][1];
            }
        }

        System.out.println("Max length is " + chainLen);
    }
}

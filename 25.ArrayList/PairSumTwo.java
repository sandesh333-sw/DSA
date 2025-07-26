import java.util.ArrayList;

public class PairSumTwo {
    public static boolean Pair(ArrayList<Integer> list, int target) {
        int bp = -1; // breaking point
        int n = list.size();

        // Find the index where the sorted array was rotated
        for (int i = 0; i < n - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                bp = i;
                break;
            }
        }

        int lp = (bp + 1) % n; // index of smallest element
        int rp = bp;           // index of largest element

        // Use two pointers to find the target sum
        while (lp != rp) {
            int sum = list.get(lp) + list.get(rp);

            if (sum == target) {
                return true;
            }

            if (sum < target) {
                lp = (lp + 1) % n;
            } else {
                rp = (n + rp - 1) % n;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        int target = 16;
        boolean result = Pair(list, target);
        System.out.println("Pair with sum " + target + " exists: " + result);
    }
}

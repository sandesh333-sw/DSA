import java.util.*;

public class ThreeSums {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); // Sort the array first
        Set<List<Integer>> set = new HashSet<>(); // Use a Set to avoid duplicates
        List<List<Integer>> result = new ArrayList<>();

        for (int high = n - 1; high >= 2; high--) {
            int low = 0;
            int mid = high - 1;

            while (low < mid) {
                int sum = nums[low] + nums[mid] + nums[high];

                if (sum == 0) {
                    set.add(Arrays.asList(nums[low], nums[mid], nums[high]));
                    low++;
                    mid--;
                } else if (sum > 0) {
                    mid--; // Decrease the mid pointer for a smaller sum
                } else {
                    low++; // Increase the low pointer for a larger sum
                }
            }
        }

        // Add all unique triplets from the Set to the result list
        result.addAll(set);
        return result;
    }

    public static void main(String[] args) {
        ThreeSums ts = new ThreeSums();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println("Unique triplets that sum to 0: " + ts.threeSum(nums));
    }
}

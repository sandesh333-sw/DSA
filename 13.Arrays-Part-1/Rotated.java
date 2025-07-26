public class Rotated {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
 
        while (low <= high) {
            int mid = (low + high) / 2;

            // Check if mid is the target
            if (nums[mid] == target) {
                return mid;
            }

            // Determine which part is sorted
            if (nums[low] <= nums[mid]) {
                // Left part is sorted
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1; // Target is in the left sorted part
                } else {
                    low = mid + 1; // Target is in the right part
                }
            } else {
                // Right part is sorted
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1; // Target is in the right sorted part
                } else {
                    high = mid - 1; // Target is in the left part
                }
            }
        }

        // If we exit the loop, the target was not found
        return -1;
    }

    public static void main(String[] args) {
        Rotated rotated = new Rotated();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        //int[] nums = {40, 50, 10, 20, 30};
        int target = 0;
        System.out.println("Index of target: " + rotated.search(nums, target)); // Output: 4
    }
}

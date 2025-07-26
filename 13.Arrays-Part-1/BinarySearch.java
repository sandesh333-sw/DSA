public class BinarySearch {
    public static int binary(int nums[], int key){
        int start = 0, end = nums.length-1;
        while(start <= end){
            int mid = (start + end)/2;

            if(nums[mid] == key){
                return mid;
            } if(nums[mid] < key){
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        int nums[] = {2,4,6,8,10};
        int key = 10;
        System.out.println("Key is at index: " + binary(nums, key));
    }
}

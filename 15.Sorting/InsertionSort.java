public class InsertionSort {

    public static void insertion(int[] arr){
        for(int i=1; i<arr.length; i++){ // Start from index 1
            int curr = arr[i];
            int prev = i-1;

            // Finding the correct position to insert
            while(prev >= 0 && arr[prev] > curr){ // Compare with 'curr' instead of 'arr[curr]'
                arr[prev+1] = arr[prev]; // Shift elements to the right
                prev--;
            }

            // Insertion
            arr[prev+1] = curr;
        }
    }

    public static void printArr(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " "); // Add space for readability
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        insertion(arr);
        printArr(arr);
    }
}

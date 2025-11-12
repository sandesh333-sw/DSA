public class MergeSort {

    public static void mergeSort(int[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }
        //kaam
        int mid = si + (ei - si) / 2;

        //left part
        mergeSort(arr, si, mid);

        //right part
        mergeSort(arr, mid + 1, ei);

        merge(arr, si, mid, ei);
    }

    public static void merge(int[] arr, int si, int mid, int ei) {
        //left(0,3) right (4,6)
        int[] temp = new int[ei - si + 1];

        int i = si; //iterator for left part
        int j = mid + 1; //iterator for right part
        int k = 0; //iterator for temp array

        // Merge the two halves
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else { 
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of the left half, if any
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy the remaining elements of the right half, if any
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // Copy the merged subarray into the original array
         k = 0;
         for(i=si; i<=ei; i++){
            arr[i] = temp[k];
            k++;
         }

    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        System.out.println("Given Array:");
        printArray(arr);

        mergeSort(arr, 0, n - 1);

        System.out.println("\nSorted Array:");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class One {
    public static void Occurence(int[] arr, int key, int i){
        if(i == arr.length){
            return;
        }
        if(arr[i] == key){
            System.out.print(i + " ");
        }
        Occurence(arr, key, i+1);
    }
    public static void main(String args[]){
        int[] arr = {3,2,4,5,6,7,2};
        int key = 2;
        Occurence(arr, key, 0);
        System.out.println();
    }
}

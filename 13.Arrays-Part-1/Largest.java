public class Largest {
    public static int printLargest(int num[]){
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<num.length; i++){
            if(num[i] > largest){
                largest = num[i];
            }
        }
        return largest;
    }
    public static void main(String args[]){
        int num[] = { 1,2,6,3,5};
    }
}

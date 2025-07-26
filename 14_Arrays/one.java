

//Given an integer array nums, return true if any 
//value appears at least twice in the array,
// and return false if every element is distinct.

public class one {

    public static boolean check(int numbers[]){
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                if(numbers[i]== numbers[j]){
                return true;
                }
            }
        }
        return false;

    }
    public static void main(String args[]){
        int numbers[] = {1,3,4,5,2};
        System.out.println("answer is: "+ check(numbers));
    }
}
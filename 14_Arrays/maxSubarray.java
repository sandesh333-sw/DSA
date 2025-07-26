
public class maxSubarray{
    public static void maxSum(int numbers[]){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<numbers.length; i++){
            int start =i;
            for(int j=1; j<numbers.length; j++){
                int end = j;
                currSum = 0;
                for(int k=start; k<=end; k++){
                    currSum += numbers[k];
                }
                System.out.println(currSum);
                if(maxSum < currSum){
                    maxSum = currSum;
                }

            }
        }
        System.out.println("max sum = " + maxSum);

    }
    public static void main(String args[]) {
        int numbers[] = {1,-2,-6,-1,3};
        maxSum(numbers);

    }
}
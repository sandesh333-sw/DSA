/*
 * You  are  given  an  array prices where prices[i] is  the  price  of  a  given  stock  on  the ith day.
 * Return the maximum profit you can achieve from this transaction.
 * If you cannot achieve any profit, return 0. 
 */
public class three {
    public static int maxProfit(int prices[]){
        int buy = prices[0];
        int profit = 0;

        for(int i=1; i<prices.length; i++){
            if(buy < prices[i]){
                profit = Math.max(prices[i] - buy,profit);
            } else {
                buy = prices[i];
            }
        }
        return profit;
    }

    public static void main(String args[]){
        int prices[] = {1,3,4,6,7};

    }
    
}

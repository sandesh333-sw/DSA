public class PairPractise {
    public static int  PairWays(int n){
        //base case
        if(n == 1 || n == 2){
            return n;
        }

        //staying single
        int fnm1 = PairWays(n-1);

        //pair
        int fnm2 = PairWays(n-2);
        int pairWays = (n-1) * fnm2;


        int totWays = fnm1 + pairWays;

        return totWays;

    }
    public static void main(String args[]){
        System.out.println(PairWays(3));
    }
}

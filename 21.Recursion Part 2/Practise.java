public class Practise {
    public static int PairWays(int n){
        //base case
        if(n == 1 || n==2){
            return n;
        }

        //work
        int fnm1 = PairWays(n-1);
        int pair = fnm1 * PairWays(n-2);
        int totWays = fnm1 + pair;

        return totWays;
    }
    public static void main(String args[]){

        PairWays(3);
    }
}

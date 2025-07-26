public class Tiling {
    public static int tiling(int n){

        if( n == 0 || n ==1){
            return 1;
        }
        //vertical choice
        int fnm1 = tiling(n-1);

        //horizontal
        int fnm2 = tiling(n-2);

        int totWays = fnm1 + fnm2;
        return totWays;
    }
    public static void main(String args[]){
        System.out.println(tiling(4));
    }  
}
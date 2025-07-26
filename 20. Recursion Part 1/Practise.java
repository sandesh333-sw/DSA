public class Practise {
   public static void decreasing(int n){
    //base case
    if(n == 1){
        System.out.print(n);
        return;
    }
    System.out.print(n);
    decreasing(n-1);;
   }

   public static void increasing(int n){
    if(n == 1){
        System.out.print(n);
        return ;
    }
    increasing(n-1);
    System.out.print(n);
   }

   public static int fact(int n){
    if(n == 0){
        return 1;
    }
    int fnm1 = fact(n-1);
    int fn = n * fnm1;
    return fn;
   }
    public static void main(String args[]){     
        increasing(5);
    }
}

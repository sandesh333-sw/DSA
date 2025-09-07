public class BinaryStrings {
    public static void printBinary(int n, int lastPlace, String str){
        // base case
        if(n == 0){
            System.out.println(str);
            return;
        }

        if(lastPlace == 0){
            printBinary(n-1, 0, str + "0");
            printBinary(n-1, 1, str + "1");
        } else {
            printBinary(n-1, 0, str + "0");
        }
    }

    public static void main(String[] args) {
        printBinary(3, 0, "");
    }
}

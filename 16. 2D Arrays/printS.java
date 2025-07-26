public class printS {

    public static void PrintS(int[][] mat){

        int counter = 0;
        for(int i=0; i<mat.length; i++){
            for(int j=0; i<mat[0].length-1; j++){
                if(mat[i][j] == 7){
                    counter++;
                }
            }
        }
        System.out.println("Number of seven are :"+ counter);
    }
    public static void main(String args[]){
        int [][] matrix = {
            {4, 7, 8},
            {8, 8, 7}
        };
        PrintS(matrix);
    }
}

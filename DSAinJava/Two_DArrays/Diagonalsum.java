package Two_DArrays;

public class Diagonalsum {
    public static void diagonal_sum(int matrix[][]) {
        int sum = 0;
        /*BRUTE FORCE , TC=O(N)^2
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j<matrix[0].length;j++) {
                if(i==j) {
                    //primary diagonal
                    sum+=matrix[i][j];
                }
                 else if(i+j==matrix.length-1){
                     //secondary diagonal
                     sum+=matrix[i][j];

                }
            }
        }*/
        //optimized , TC=O(N)
        for (int i = 0; i < matrix.length; i++) {
            //pd
            sum += matrix[i][i];
            //overlapping condition i.e. i==j,j=n-1-i
            if (i ==matrix.length-1-i) {
                //sd
                sum += matrix[i][matrix.length - 1 - i];
            }
        }


        System.out.println(sum);
    }
    public static void main(String args[]){
        int matrix[][]={{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
        diagonal_sum(matrix);
    }
}



package DSAinJava.Two_DArrays;

public class ScoreFlip {
    /*
   if first col of any row is 0 , flip that row(msb should be 1)
   now , we need max ones , for every col , if countZerosCol>countOnesCol , then flip col
   but this will modify matrix
   */
    public int matrixScore(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        //every row's msb will be converted to one
        int score=m*(1<<(n-1));
        for(int j=1;j<n;j++){
            int countOnes=0;
            for (int[] ints : grid) {
                if (ints[0] == ints[j]) {
                    //{0,0} then flipped->1 , {1,1} then ->1 , {0,1} then flipped -> 0 {1,0} ->0
                    countOnes++;
                }
            }
            countOnes=Math.max(countOnes,m-countOnes);//flip or original
            score+=countOnes*(1<<(n-1-j));
        }
        return score;
    }
}

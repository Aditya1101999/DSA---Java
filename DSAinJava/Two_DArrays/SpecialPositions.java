package DSAinJava.Two_DArrays;

public class SpecialPositions {
    public int numSpecial(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;

        int[] rowOnes=new int[m];
        int[] colOnes=new int[n];


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    rowOnes[i]++;
                    colOnes[j]++;
                }
            }
        }
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1 && rowOnes[i]==1 && colOnes[j]==1)
                    ans++;
            }
        }
        return ans;
    }
    public int[][] onesMinusZeros(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;

        int[] rowOnes=new int[m];
        int[] colOnes=new int[n];


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    rowOnes[i]++;
                    colOnes[j]++;
                }
            }
        }
        int[][] ans=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //subtract ones in that row and column respectively to get no. of zeros
                ans[i][j]=rowOnes[i]+colOnes[j]-(m-rowOnes[i])-(n-colOnes[j]);
            }
        }
        return ans;
    }
}

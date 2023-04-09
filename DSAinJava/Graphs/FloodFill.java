package DSAinJava.Graphs;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor=image[sr][sc];
        int[][] ans=image;
        dfs(image,sr,sc,color,initialColor,ans);
        return ans;
    }
    private void dfs(int[][] image,int row,int col,int newColor,int initialColor,int[][] ans){
        ans[row][col]=newColor;
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];
            if(nrow>=0 && nrow<image.length && ncol>=0 && ncol<image[0].length &&
                    image[nrow][ncol]==initialColor && ans[nrow][ncol]!=newColor){//connected & not visited
                dfs(image,nrow,ncol,newColor,initialColor,ans);
            }
        }
    }
}

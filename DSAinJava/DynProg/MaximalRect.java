package DSAinJava.DynProg;
import java.util.*;
public class MaximalRect {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[] dp=new int[m];
        //row 1
        for(int j=0;j<m;j++){
            dp[j]= matrix[0][j]=='0' ? 0 : 1;
        }
        int ans=findArea(dp);
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1') dp[j]++;
                else dp[j]=0;
            }
            ans=Math.max(ans,findArea(dp));
        }
        return ans;
    }
    public int findArea(int[] arr) {
        int maxArea=0;
        int[] nsr=new int[arr.length];
        int[] nsl=new int[arr.length];
        //next smaller right
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length-1;i>=0;i--){
            while(!s.isEmpty() &&arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=arr.length;
            }
            else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }
        //next smaller left
        s = new Stack<>();
        for (int i =0;i< arr.length;i++){
            while(!s.isEmpty() &&arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=-1;
            }
            else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }
        //current area
        for(int i=0;i<arr.length;i++){
            int height=arr[i];
//width=j-i-1=nsr[i]-nsl[i]-1
            int width=nsr[i]-nsl[i]-1;
            int currArea=height*width;
            maxArea=Math.max(currArea,maxArea);
        }
        return maxArea;
    }
}

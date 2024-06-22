package DSAinJava.arrays;
import java.util.Arrays;
public class MaxTip {
    public static long maxTip(int n, int x, int y, int[] arr, int[] brr) {
        int[][] mergedArr=new int[n][2];
        for(int i=0;i<n;i++){
            mergedArr[i][0]=arr[i];
            mergedArr[i][1]=brr[i];
        }
        Arrays.sort(mergedArr,(a,b)->Math.abs(b[0]-b[1])-Math.abs(a[0]-a[1]));
        long ans=0;
        for(int[] pair : mergedArr){
            if(y==0||pair[0]>pair[1] && x>0){//x will take the order
                ans+=pair[0];
                x--;
            }
            else{// y will take the order
                ans+=pair[1];
                y--;
            }
        }
        return ans;
    }
}

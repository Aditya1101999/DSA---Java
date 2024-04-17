package DSAinJava.Two_DArrays;

public class BusiestTime {
    static int findBusiestPeriod(int[][] data) {
        int n=data.length;
        int ans=0;
        int maxVis=0;
        int curr=0;
        for(int i=0;i<n;i++){
            int[] point=data[i];
            int timestamp=point[0];
            int visitors=point[1];
            int inOut=point[2];
            if(inOut==0){
                curr-=visitors;
            }
            else{
                curr+=visitors;
            }
            if(i<n-1 && data[i][0]==data[i+1][0]){
                continue;
            }
            if(curr>maxVis){
                maxVis=curr;
                ans=timestamp;
            }
        }
        return ans;
    }
}

package DSAinJava.arrays;

public class MaxOccElements {
    public static int maxOccured(int n, int l[], int r[], int maxx) {
        int[] prefix=new int[maxx+2];
        for(int i=0;i<n;i++){
            prefix[l[i]]++;
            prefix[r[i]+1]--;
        }
        int prefixSum=0;
        int maxFreq=0;
        int maxEl=0;
        for(int i=0;i<maxx+1;i++){
            prefixSum+=prefix[i];
            if(prefixSum>maxFreq){
                maxFreq=prefixSum;
                maxEl=i;
            }
        }
        return maxEl;
    }
}

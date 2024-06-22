package DSAinJava.arrays;

public class SpArray {
    public int specialArray(int[] nums) {
        int n=nums.length;
        int[] freq=new int[n+1];
        for(int el : nums){
            freq[Math.min(n,el)]++;
        }
        int frequency=0;
        for(int x=n;x>=0;x--){
            frequency+=freq[x];
            if(x==frequency) return x;
        }
        return -1;
    }
}

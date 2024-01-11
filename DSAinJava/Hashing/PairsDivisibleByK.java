package DSAinJava.Hashing;

public class PairsDivisibleByK {
    public boolean canArrange(int[] nums, int k) {
        if(nums.length%2!=0) return false;
        int[] freq=new int[k];
        for(int el : nums){
            int num=el%k;
            if(num<0) num+=k;
            freq[num]++;
        }
        if(freq[0]%2!=0) return false;
        for(int i=1;i<=k/2;i++){
            if(freq[i]!=freq[k-i]) return false;
        }
        return true;
    }
}

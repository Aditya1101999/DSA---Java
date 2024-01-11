package DSAinJava.BitManipulation;

public class XOREqualsK {
    public int minOperations(int[] nums, int k) {
        int ans=0;
        for(int num : nums){
            ans^=num;
        }
        ans^=k;
        //now the different bits(or the no of bits required to be flipped will be set)
        return Integer.bitCount(ans);
        /* while(ans!=0){
        if(ans & 1!=0) count++
        ans>>>=1//unsigned
        }
        */
    }
}

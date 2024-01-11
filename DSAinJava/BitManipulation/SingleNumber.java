package DSAinJava.BitManipulation;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ans=0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
    public int singleNumber2(int[] nums) {
        int ans=0;
        for(int k=0;k<=31;k++){
            int mask=(1<<k);
            int countOnes=0;
            for(int el : nums){
                //check ith bit is set
                if((el&mask)!=0) countOnes++;
            }
            if(countOnes%3!=0){//part of single number
                ans|=(1<<k);
            }
            //we don't require to count zeros , as all the bits are by default 0 in ans
        }
        return ans;
    }
    public int[] singleNumber3(int[] nums) {//2 single no.s
        int xor=0;
        for(int num : nums){
            xor^=num;
        }
        int k=1;//or can also use Integer.lowestOneBit(xor)
        while((xor & k) == 0){
            k<<=1;
        }
        //now divide the numbers on the basis of kth bit
        int[] ans=new int[2];
        for(int num : nums){
            if((num & k) == 0 ){
                ans[0]^=num;
            }
            else{
                ans[1]^=num;
            }
        }
        return ans;
    }
}

package arrays;

public class MaxConsecOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int max=0;
        for(int el:nums){
            if(el==1){
                count++;
            }
            else{
                count=0;
            }
            max=Math.max(max,count);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr={1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
}

package DSAinJava.arrays;

public class NonDecreasingArr {
    public boolean checkPossibility(int[] nums) {
        boolean isModified=false;
        for(int i=1;i<nums.length;i++){//the priority is to decrease the numbers
            if(nums[i-1]>nums[i]){
                if(isModified) return false;
                else{
                    if(i>=2 && nums[i-2]>nums[i]){//then decreasing previous number will not be of any use
                        nums[i]=nums[i-1];//increase the current number
                    }
                    else{
                        nums[i-1]=nums[i];//decrease the previous number
                    }
                    isModified=true;
                }
            }
        }
        return true;
    }
}

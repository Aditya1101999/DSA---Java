package DSAinJava.arrays;
import java.util.Random;
public class ShuffleArray {
        private static int[] nums;
        Random rand;
        public ShuffleArray(int[] nums) {
            ShuffleArray.nums =nums;
            rand=new Random();
        }

        public int[] reset() {
            return nums;

        }

        public int[] shuffle() {
            int[] copy=nums.clone();
            for(int i=copy.length-1;i>0;i--){//we can't swap 0 with 0
                int j=rand.nextInt(i+1);//any index till now from the unshuffled array
                swap(copy,i,j);
            }
            return copy;
        }
        private void swap(int[] a, int i, int j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    public int[] shuffle(int[] nums, int n) {
        int[] ans=new int[2*n];
        for(int i=0;i<n;i++){
            ans[2*i]=nums[i];
            ans[2*i+1]=nums[n+i];
        }
        return ans;
    }
}

package DSAinJava.arrays;
import java.util.Arrays;
public class ProductExceptSelf {
    public int[] productExceptSelfPrefix(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suff = new int[n];
        pre[0] = 1;
        suff[n - 1] = 1;

        for(int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for(int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i + 1];
        }

        int ans[] = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = pre[i] * suff[i];
        }
        return ans;
    }
    //brute force approaches ->two loops(check if i!=j , and multiple the elements)
    // or , make two arrays , prefixProduct and suffixProduct
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        Arrays.fill(ans,1);
        int left=1;
        for(int i=0;i<n;i++){
            ans[i]*=left;
            left*=nums[i];
        }
        int right=1;
        for(int i=n-1;i>=0;i--){
            ans[i]*=right;
            right*=nums[i];
        }
        return ans;
    }
}

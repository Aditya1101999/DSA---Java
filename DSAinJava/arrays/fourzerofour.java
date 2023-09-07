package DSAinJava.arrays;
import java.util.*;
public class fourzerofour {
    private static long count4_0_4(int[] nums){
        long one=0;
        long two=0;
        long ans=0;
        for(int el:nums){
            if(el==4){
                one++;
                ans+=two;
            }
            else if(el==0){
                two+=one;
            }
        }
        return ans;
    }
    private static long count40_4(int[] nums){
        long one=0;
        long ans=0;
        for(int el:nums){
            if(el==40){
                one++;
            }
            else if(el==4){
                ans+=one;
            }
        }
        return ans;
    }
    private static long count404(int[] nums){
        long ans=0;
        for(int el:nums){
            if(el==404) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        //4 0 4 , 40 4 , 404
        long ans=count4_0_4(nums)+count40_4(nums)+count404(nums);
        System.out.println(ans);
    }
}

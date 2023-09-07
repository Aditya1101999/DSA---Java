package DSAinJava.Recursion;
import java.util.Scanner;
public class Inverse {
    private static void Helper(int[] nums,int index,int[] ans){
        if(index==nums.length) return;
        int number=nums[index];
        ans[number]=index;
        Helper(nums,index+1,ans);
    }
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        int[] ans=new int[n];
        Helper(nums,0,ans);
        for(int el:ans){
            System.out.print(el+" ");
        }
    }
}

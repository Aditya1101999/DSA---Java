package DSAinJava.arrays;
import java.util.Scanner;
public class NextPermutation {
    public static void nextPermutation(int[] A) {
        int i = A.length - 2;
        while(i >= 0 && A[i] >= A[i + 1]) i--; // Find 1st id i that breaks descending order
        if(i==-1){
            reverse(A,0,A.length-1);
        }
        if(i >= 0) {                           // If not entirely descending
            int j = A.length - 1;              // Start from the end
            while(A[j] <= A[i]) j--;           // Find rightmost first larger id j
            swap(A, i, j);                     // Switch i and j
        }
        reverse(A, i + 1, A.length - 1);       // Reverse the descending sequence
    }

    public static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] nums=new int[n];
            for(int i=0;i<n;i++){
                nums[i]=sc.nextInt();
            }
            int bp=-1;
            for(int i=n-2;i>=0;i--){
                if(nums[i]<nums[i+1]){
                    bp=i;
                    break;
                }
            }
            if(bp==-1){
                reverse(nums,0,n-1);
            }
            else{
                int bp2=-1;
                for(int i=n-1;i>=0;i--){
                    if(nums[i]>nums[bp]){
                        bp2=i;
                        break;
                    }
                }
                swap(nums,bp,bp2);
                reverse(nums,bp+1,n-1);
            }
            for(int el:nums){
                System.out.print(el+" ");
            }
            System.out.println();
        }
        int[] nums = {1,2,3};
        nextPermutation(nums);
    }
}

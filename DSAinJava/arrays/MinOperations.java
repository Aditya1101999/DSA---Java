package arrays;

public class MinOperations {
    public static long minOperations(int[] nums1, int[] nums2, int k) {
        int n=nums1.length;
        if(k==0){
            for(int i=0;i<n;i++){
                if(nums1[i]!=nums2[i])
                    return -1;
            }
            return 0;
        }
        long add=0;
        long sub=0;
        for(int i=0;i<n;i++){
            int diff=nums2[i]-nums1[i];
            if(diff%k!=0) return -1;
            if(diff<0) sub+=Math.abs(diff/k);
            if(diff>0) add+=Math.abs(diff/k);

        }
        if(sub==add){
            return sub;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums1 = {3, 8, 5, 2};
        int[] nums2 = {2, 4, 1, 6};
        int k = 1;
        System.out.println(minOperations(nums1,nums2,k));
    }

}

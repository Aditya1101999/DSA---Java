package DSAinJava.DivideAndConq;

public class MedianofArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        if(n1>n2) return findMedianSortedArrays(nums2,nums1);
        int low=0;
        int high=n1;
        while(low<=high){
            int cut1=(low+high)/2;
            int cut2=(n1+n2+1)/2-cut1;//+1 is for odd cases,it won't affect even cases

            //if no more elements are to the left/right , assign them to infinity
            int left1=cut1==0 ? Integer.MIN_VALUE : nums1[cut1-1];
            int left2=cut2==0 ? Integer.MIN_VALUE : nums2[cut2-1];

            int right1=cut1==n1 ? Integer.MAX_VALUE: nums1[cut1];
            int right2=cut2==n2 ? Integer.MAX_VALUE: nums2[cut2];

            //since arrays are sorted , left1<right1 and left2<right2 always
            if(left1<=right2 && left2<=right1){
                if((n1+n2)%2==0){//no. of elements are even =>median=(leftmax+rightmin)/2
                    return (Math.max(left1,left2)+Math.min(right1,right2))/2.0;
                }
                else{
                    return Math.max(left1,left2);//last element of left half
                }
            }
            else if(left1>right2){
                high=cut1-1;//reduce left1
            }
            else{//left2>right1
                low=cut1+1;//increase right1
            }

        }
        return 0.0;
    }
}

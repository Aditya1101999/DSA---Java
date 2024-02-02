package DSAinJava.Stack;
import java.util.Stack;
public class SubarrayMin {
    /*
we need to make one (nsl or nsr) strictly increasing , and other not
to handle cases like this :
{2,3,4,2}
in order to ensure that the subarray {2,3,4,2} is not taken by both 2s
*/
    //next smaller left
    private int[] nextSmallerLeft(int[] arr){
        int n=arr.length;
        int[] result=new int[n];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                result[i]=-1;
            }
            else{
                result[i]=st.peek();
            }
            st.push(i);
        }
        return result;
    }
    //next smaller right
    private int[] nextSmallerRight(int[] arr){
        int n=arr.length;
        int[] result=new int[n];
        Stack<Integer>st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]<arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                result[i]=n;
            }
            else{
                result[i]=st.peek();
            }
            st.push(i);
        }
        return result;
    }
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int mod=(int)1e9+7;
        long sum=0;
        int[] nsl=nextSmallerLeft(arr);
        int[] nsr=nextSmallerRight(arr);
        for(int i=0;i<n;i++){
            long leftEl=i-nsl[i];
            long rightEl=nsr[i]-i;
            long totalSubarrays=leftEl*rightEl;
            long currSum=totalSubarrays*arr[i];
            sum=(sum+currSum)%mod;
        }
        return (int)sum;
    }
}

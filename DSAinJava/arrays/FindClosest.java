package DSAinJava.arrays;

public class FindClosest {
    public static int findClosest(int n, int k, int[] arr) {
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // After the loop, start might be out of bounds
        if (start >= n) {
            return end;
        }
        // Similarly, end might be out of bounds
        if (end < 0) {
            return start;
        }

        if (Math.abs(arr[start] - k) < Math.abs(arr[end] - k)) {
            return start;
        } else if (Math.abs(arr[start] - k) > Math.abs(arr[end] - k)) {
            return end;
        } else {
            return Math.max(arr[start], arr[end])==arr[start] ? start : end;
        }


    }
    int[] printKClosest(int[] arr, int n, int k, int x) {
        int[] ans=new int[k];
        int i=0;
        int index=findClosest(n,x,arr);
        int low=(arr[index]==x) ? index-1 : index;
        int high=index+1;
        while(i<k && low>=0 && high<n){
            if(Math.abs(arr[low]-x) < Math.abs(arr[high]-x)){
                ans[i++]=arr[low--];
            }
            else{
                ans[i++]=arr[high++];
            }
        }
        //out of bounds
        while(i<k && low>=0){
            ans[i++]=arr[low--];
        }
        while(i<k && high<n){
            ans[i++]=arr[high++];
        }
        return ans;
    }

}

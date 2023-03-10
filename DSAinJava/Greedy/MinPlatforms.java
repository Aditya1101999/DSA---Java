package Greedy;
import java.util.Arrays;
public class MinPlatforms {
    static int findPlatform(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int curr=0;
        int max=0;
        int i=0;
        int j=0;
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                curr++;
                i++;
            }
            else if(arr[i]>dep[j]){
                curr--;
                j++;
            }
            max=Math.max(max,curr);
        }
        return max;

    }
}

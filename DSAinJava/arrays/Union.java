package DSAinJava.arrays;
import java.util.*;
public class Union {
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        ArrayList<Integer>ans=new ArrayList<>();
        int i=0;
        int j=0;
        while(i<n && j<m){
            while(i+1<n && arr1[i]==arr1[i+1]) i++;
            while(j+1<m && arr2[j]==arr2[j+1]) j++;
            //elements are equal
            if(arr1[i]==arr2[j]){
                ans.add(arr1[i]);
                i++;
                j++;
            }
            // i>j
            else if(arr1[i]>arr2[j]){
                ans.add(arr2[j]);
                j++;
            }
            //i<j
            else{
                ans.add(arr1[i]);
                i++;
            }

        }
        while(i<n){
            while(i+1<n && arr1[i]==arr1[i+1]) i++;
            ans.add(arr1[i++]);

        }
        while(j<m){
            while(j+1<m && arr2[j]==arr2[j+1]) j++;
            ans.add(arr2[j++]);

        }

        return ans;
    }
}

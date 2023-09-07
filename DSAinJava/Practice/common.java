package DSAinJava.Practice;

import java.util.ArrayList;
import java.util.List;

public class common {
    private static List<Integer> findCommon(int[] arr1,int[] arr2,int[] arr3){
        List<Integer>ans=new ArrayList<>();
        int a=0;
        int b=0;
        int c=0;
        while(a<arr1.length && b<arr2.length && c< arr3.length){
            if(arr1[a]==arr2[b] && arr2[b]==arr3[c]){
                ans.add(arr1[a]);
                a++;b++;c++;
            }
            else{
               int min=Math.min(arr1[a],Math.min(arr2[b],arr3[c]));
               if(min==arr1[a]) a++;
               else if(min==arr2[b]) b++;
               else c++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,4,6,8,10,12};
        int[] arr2= {3,6,9,12,15};
        int[] arr3 = {6,12,18};
        List<Integer>ans=findCommon(arr1,arr2,arr3);
        for(int el:ans){
            System.out.print(el+" ");
        }
    }
}

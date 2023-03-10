package Arraylist;
import java.util.*;
public class MigratoryBirds {
    public static int migratoryBirds(List<Integer> arr) {
        int ar[]=new int[5];//storing frequency of each element
        for(int i=0;i<arr.size();i++){
            ar[arr.get(i)-1]++;//increasing frequency (-1 coz we start from 1 not 0)
        }
        int max=0;
        int ans=0;
        for(int i=0;i<ar.length;i++){
            if(ar[i]>max){
                max=ar[i];
                ans=i+1;//index is already decremented above by 1 so adding 1
            }
        }
        return ans;
    }
    public static void main(String[] args){
        ArrayList<Integer>arr=new ArrayList<>();
        arr.add(1);
        arr.add(4);
        arr.add(4);
        arr.add(4);
        arr.add(5);
        arr.add(3);
        System.out.println(migratoryBirds(arr));
    }
}

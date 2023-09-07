package DSAinJava.Arraylist;
import java.util.*;
public class minOperations {
    static int findMin(int[] arr, int n) {
        int odd=0;
        int even=0;
        List<Integer>evenElements=new ArrayList<>();
        for(int el: arr){
            if(el%2==1) odd++;
            else{
                even++;
                evenElements.add(el);
            }
        }
        if(odd%2==0) return 0;
        else if(even==0) return -1;

        int ans=Integer.MAX_VALUE;
        for(int el: evenElements){
            int curr=0;
            while(el%2==0){
                el/=2;
                curr++;
            }
            ans=Math.min(ans,curr);
        }
        return ans;
    }
}

package DSAinJava.Arraylist;
import java.util.*;
public class PoliceThieves {
    static int catchThieves(char arr[], int n, int k) {
        List<Integer>police=new ArrayList<>();
        List<Integer>theives=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(arr[i]=='P') police.add(i);
            else if(arr[i]=='T') theives.add(i);
        }
        //two-pointers
        int p=0;
        int t=0;
        int ans=0;
        while(p<police.size() && t<theives.size()){
            if(Math.abs(police.get(p)-theives.get(t))<=k){//can be caught
                ans++;
                p++;
                t++;
            }
            else if(police.get(p)<theives.get(t)){
                p++;
            }
            else{
                t++;
            }
        }
        return ans;
    }
}

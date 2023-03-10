package Greedy;
import java.util.*;
public class MaxPartitions {
    public static int maxPartitions(String str){
        if(str.length()==0){
            return 0;
        }
        int r=0,l=0;
        int ans=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='L'){
                l++;
            }
            else if(str.charAt(i)=='R'){
                r++;
            }
            if(l==r){
                ans++;
            }
        }
        return ans;

    }
    public static void main(String[] args){
        String str="LRRRRLLRLLRL";
        System.out.println(maxPartitions(str));
    }
}

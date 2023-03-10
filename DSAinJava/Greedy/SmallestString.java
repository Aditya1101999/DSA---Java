package Greedy;
import java.util.*;
public class SmallestString {
    public static char[] lexoSmall(int n,int k){
        char[] arr=new char[n];
        //filling the array with a
        Arrays.fill(arr,'a');
        for(int i=n-1;i>=0;i--){
//subtracting previous element value
            k-=i;
            if(k>=0){
                if(k>=26){
                    arr[i]='z';
                    k-=26;
                }
                else{//a depicts 1,minus 1 equalizes value
                    arr[i]=(char)('a'+k-1);
                    k-=arr[i]-'a'+1;
                }
            }
            else{
                break;
            }
            //adding previous element value again
            k+=i;
        }
        return arr;
    }
    public static void main(String[] args) {
        int n = 5, k = 73;
        char arr[] = lexoSmall(n, k);
        System.out.print(new String(arr));
    }
}

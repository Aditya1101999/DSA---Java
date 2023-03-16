package DSAinJava.Backtracking;
import java.util.*;
public class KthPermutation {
    public static String getPermutation(int n, int k) {
        int fact=1;
        List<Integer>numbers=new ArrayList<>();
        for(int i=1;i<n;i++){//calculate (n-1)!
            fact*=i;
            numbers.add(i);
        }
        numbers.add(n);
        String ans="";
        k-=1;//0-based indexing
        while(true){
            ans+=numbers.get(k/fact);
            numbers.remove(k/fact);
            if(numbers.size()==0) break;
            k=k%fact;
            fact=fact/numbers.size();
        }
        return ans;
    }

    public static void main(String[] args) {
        int n=4;
        int k=15;
        System.out.println(getPermutation(n,k));
    }
}

package DSAinJava.Two_DArrays;
import java.util.*;
public class RepeatedRows {
    public static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n)
    {
        Set<String>set=new HashSet<>();
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=0;i<m;i++){
            String hash=hashFunction(matrix[i]);
            if(set.contains(hash)) ans.add(i);
            else set.add(hash);
        }
        return ans;
    }
    private static String hashFunction(int[] arr){
        StringBuilder sb=new StringBuilder();
        for(int el : arr){
            sb.append(el);
        }
        return sb.toString();
    }
}

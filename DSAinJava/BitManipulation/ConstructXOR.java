package DSAinJava.BitManipulation;
import java.util.*;
public class ConstructXOR {
    public static ArrayList<Integer> constructList(int q, int[][] queries) {
        ArrayList<Integer>ans=new ArrayList<>();
        int temp=0;
        for(int i=q-1;i>=0;i--){
            if(queries[i][0]==0){
                ans.add(queries[i][1]^temp);
            }
            else{
                temp^=queries[i][1];
            }
        }
        ans.add(temp);//xor with the first single value 0
        Collections.sort(ans);
        return ans;
    }
}

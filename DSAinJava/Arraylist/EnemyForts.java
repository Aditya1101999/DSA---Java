package Arraylist;
import java.util.*;
public class EnemyForts {
    public int captureForts(int[] forts) {
        ArrayList<Integer>ans=new ArrayList<>();
        int n=forts.length;
        for(int i=0;i<n;i++){
            if(forts[i]==1||forts[i]==-1){
                ans.add(i);
            }
        }
        int res=0;
        if(ans.size()>0){
            for(int i=0;i<ans.size()-1;i++){
                if(forts[ans.get(i)]*forts[ans.get(i+1)]==-1){
                    res=Math.max(res,Math.abs(ans.get(i+1)-ans.get(i))-1);
                }
            }
        }
        return res;
    }
}

package Greedy;
import java.util.*;
public class MinRounds {
    public static int minimumRounds(int[] tasks) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int task:tasks){//building map-updating key by 1 ,or default key val is 0
            map.put(task,map.getOrDefault(task,0)+1);
        }
        int ans=0;
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){//each entry val
            int freq=entry.getValue();
            if(freq==1){
                return -1;
            }
            //F=2x+3y
            if(freq%3==0){
                ans+=freq/3;
            }
            else{
                ans+=freq/3+1;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] tasks ={2,2,3,3,2,4,4,4,4,4};
        System.out.println(minimumRounds(tasks));
    }
}

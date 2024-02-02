package DSAinJava.Greedy;
import java.util.*;
public class minTaps {
    public int minTapsOverLappingArea(int n, int[] ranges) {
        int[] arr=new int[n+1];
        for(int i=0;i<n+1;i++){
            //if(ranges[i]==0) continue;
            int left=Math.max(0,i-ranges[i]);
            int right=Math.min(n,i+ranges[i]);
            arr[left]=Math.max(arr[left],right);
        }
        int taps=0;
        int currEnd=0;
        int maxEnd=0;
        for(int i=0;i<n+1;i++){
            if(i>maxEnd){
                return -1;
            }
            if(i>currEnd){
                taps++;
                currEnd=maxEnd;
            }
            maxEnd=Math.max(maxEnd,arr[i]);
        }
        return taps;
    }
    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    int min_sprinklers(int [] ranges, int n) {//for individual divisions
        List<Pair>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(ranges[i]==-1) continue;
            int left=Math.max(0,i-ranges[i]);
            int right=Math.min(n-1,i+ranges[i]);
            list.add(new Pair(left,right));
        }
        list.sort((a, b) -> a.first - b.first);
        int taps=0;
        int target=0;
        int i=0;
        while(target<n){
            int maxRight=-1;
            while(i<list.size()){
                if(list.get(i).first<=target){
                    maxRight=Math.max(maxRight,list.get(i).second);
                    i++;
                }
                else break;
            }
            if(maxRight<target){
                return -1;
            }
            taps++;
            target=maxRight+1;
        }
        return taps;
    }
}

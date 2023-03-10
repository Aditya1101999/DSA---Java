package Hashing;
import java.util.*;
public class JobScheduling {
    private class Job{
        int start;
        int end;
        int profit;
        public Job(int st,int ed,int p){
            this.start=st;
            this.end=ed;
            this.profit=p;
        }

    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job>jobs=new ArrayList<>();
        int n=startTime.length;
        for(int i=0;i<n;i++){
            jobs.add(new Job(startTime[i],endTime[i],profit[i]));
        }
        Collections.sort(jobs,(a,b)->a.end-b.end);
        //<EndTime,MaxProfit till that time>
        TreeMap<Integer,Integer>map=new TreeMap<>();
        int ans=0;
        for(Job curr : jobs){
//floorkey function will return the greatest key less than or equal to given key(curr)
            Integer entryTillStartTime=map.floorKey(curr.start);
            Integer maxProfitTillTime=entryTillStartTime==null ? 0 : map.get(entryTillStartTime);
            ans=Math.max(ans,maxProfitTillTime+curr.profit);
            map.put(curr.end,ans);
        }
        return ans;
    }
}

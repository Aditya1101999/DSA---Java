package Greedy;
import java.util.*;
public class JobSequencing {
    static class Job{
        int id;
        int deadline;
        int profit;
        public Job(int i,int d,int p){
            id=i;
            deadline=d;
            profit=p;
        }
    }
    static int[] JobScheduling(Job[] arr, int n) {
        Arrays.sort(arr,(a,b)->(b.profit-a.profit));
        int jobs=0;
        int profit=0;
        int maxDeadline=0;
        for(int i=0;i<n;i++){
            maxDeadline=Math.max(maxDeadline,arr[i].deadline);
        }
        int[] visited=new int[maxDeadline+1];//no job done at 0
        Arrays.fill(visited,-1);
        for(int i=0;i<n;i++){//for each job
            Job curr=arr[i];
            for(int j=curr.deadline;j>0;j--){//time slots(deadline)
                if(visited[j]==-1){//slot available
                    visited[j]=i;
                    jobs++;
                    profit+=curr.profit;
                    break;//only 1 job on a given day
                }
            }
        }
        return new int[]{jobs,profit};
    }
    public static void main(String[] args){
        int[][] jobsInfo={{4,20},{1,10},{1,40},{1,40}} ;
        System.out.println("maximum profit seq is ");
        ArrayList<Job> jobs=new ArrayList<>();
        for(int i=0;i< jobsInfo.length;i++){
            jobs.add(new Job(i,jobsInfo[i][0],jobsInfo[i][1]));
        }
        //descending order of profit
        Collections.sort(jobs,(a,b)->b.profit-a.profit);
        ArrayList<Integer>seq=new ArrayList<>();
        int time=0;
        for(int i=0;i<jobs.size();i++){
            Job curr=jobs.get(i);
            if(curr.deadline>time){
                seq.add(curr.id);
                time++;
            }
        }
        System.out.print("max jobs = "+seq.size());
        for(int i=0;i<seq.size();i++){
            System.out.print(seq.get(i)+" ");
        }
        System.out.println();
    }

}

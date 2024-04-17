package DSAinJava.Graphs;
import java.util.*;
public class PeopleSecret {
    class Pair{
        int node;
        int time;
        Pair(int node,int time){
            this.node=node;
            this.time=time;
        }
    }
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<List<Pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] meet : meetings){
            adj.get(meet[0]).add(new Pair(meet[1],meet[2]));
            adj.get(meet[1]).add(new Pair(meet[0],meet[2]));
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.time-b.time);
        boolean[] visited=new boolean[n];
        pq.add(new Pair(0,0));
        pq.add(new Pair(firstPerson,0));
        while(!pq.isEmpty()){
            int node=pq.peek().node;
            int time=pq.peek().time;
            pq.poll();
            if(!visited[node]){
                visited[node]=true;
                for(Pair it : adj.get(node)){
                    int newNode=it.node;
                    int meetingTime=it.time;
                    if(!visited[newNode] && time<=meetingTime){
                        pq.add(new Pair(newNode,meetingTime));
                    }
                }
            }
        }
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(visited[i]) ans.add(i);
        }
        return ans;
    }
}

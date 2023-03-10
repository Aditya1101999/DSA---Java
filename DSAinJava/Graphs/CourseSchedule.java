package Graphs;
import java.util.*;
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int n=prerequisites.length;
        for(int i=0;i<n;i++){
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);//directed graph
        }
        int[] inDegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int node: graph.get(i)){
                inDegree[node]++;//increasing freq
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.remove();
            ans.add(node);
            for(int i :graph.get(node)){
                inDegree[i]--;//decreasing the freq of removed nodes
                if(inDegree[i]==0){
                    q.add(i);
                }
            }
        }
        if(ans.size()==numCourses) return true;
        return false;

    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int n=prerequisites.length;
        for(int i=0;i<n;i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);//directed graph in reverse order
        }
        int[] inDegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int node: graph.get(i)){
                inDegree[node]++;//increasing freq
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        int[] ans=new int[numCourses];
        int index=0;
        while(!q.isEmpty()){
            int node=q.remove();
            ans[index++]=node;
            for(int i :graph.get(node)){
                inDegree[i]--;//decreasing the freq of removed nodes
                if(inDegree[i]==0){
                    q.add(i);
                }
            }
        }
        if(index==numCourses){
            return ans;
        }
        return new int[]{};//else return empty array

    }
}


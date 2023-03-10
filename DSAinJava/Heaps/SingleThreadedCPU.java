package Heaps;
import java.util.*;
import java.util.PriorityQueue;

public class SingleThreadedCPU {
    public static int[] getOrder(int[][] tasks) {
        int n=tasks.length;
        int[][] allTasks=new int[n][3];//index , start time and process time
        for(int i=0;i<n;i++){
            allTasks[i][0]=i;
            allTasks[i][1]=tasks[i][0];//available time
            allTasks[i][2]=tasks[i][1];//process time
        }
        //sort on basis of duration then index
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a, b)->a[2]-b[2]==0 ?a[0]-b[0]:a[2]-b[2]);
        //sorting on basis of availability
        Arrays.sort(allTasks,(a,b)->a[1]-b[1]);
        int i=0,index=0,currTime=0;
        int[] result=new int[n];
        while(i<n){
//check if ith task starting time is smaller than or equal to currTime i.e. whether it can be started or not
            while(i<n&&currTime>=allTasks[i][1]){//add in PQ
                minHeap.add(allTasks[i]);
                i++;
            }
            if(minHeap.isEmpty()){//initiation
                currTime=allTasks[i][1];//update currTime to whatever task available
            }
            if(!minHeap.isEmpty()){
                int[] currTask=minHeap.remove();
                result[index]=currTask[0];
                index++;
                currTime+=currTask[2];
            }
        }
        while(!minHeap.isEmpty()){
            int[] currTask=minHeap.remove();
            result[index]=currTask[0];
            index++;
        }
        return result;
    }
    public static void main(String[] args){
        int[][] tasks = {{1,2},{2,4},{3,2},{4,1}};
        int[] result=getOrder(tasks);
        for(int el:result){
            System.out.print(el+" ");
        }
    }
}

package Graphs;
import java.util.*;
public class JumpGame {
    public boolean canReach(int[] arr, int start) {//reach any index with value 0
        Queue<Integer>q=new LinkedList<>();
        boolean[] visited=new boolean[arr.length];
        q.add(start);
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int curr=q.remove();
                if(arr[curr]==0){
                    return true;
                }
                if(!visited[curr]){
                    int forwardIndex=curr+arr[curr];
                    if(forwardIndex>=0 && forwardIndex<arr.length){
                        q.add(forwardIndex);
                    }
                    int backwardIndex=curr-arr[curr];
                    if(backwardIndex>=0 && backwardIndex<arr.length){
                        q.add(backwardIndex);
                    }
                }
                visited[curr]=true;
            }
        }
        return false;
    }
    public int minJumps(int[] arr) {
        Queue<Integer>q=new LinkedList<>();
        HashMap<Integer,List<Integer>>map=new HashMap<>();//<elements,indices where elements occured>
        boolean[] visited=new boolean[arr.length];
        for(int i=0;i<arr.length;i++){
            List<Integer>indices=map.getOrDefault(arr[i],new ArrayList<>());
            indices.add(i);
            map.put(arr[i],indices);
        }
        q.add(0);
        int count=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int curr=q.remove();
                if(curr==arr.length-1){
                    return count;
                }
                if(!visited[curr]){
                    int forwardIndex=curr+1;
                    if(forwardIndex<arr.length){
                        q.add(forwardIndex);
                    }
                    int backwardIndex=curr-1;
                    if(backwardIndex>=0){
                        q.add(backwardIndex);
                    }
                    if(map.containsKey(arr[curr])){
                        for(int index : map.get(arr[curr])){
                            if(index>=0 && index<arr.length){
                                q.add(index);
                            }
                        }
                        map.remove(arr[curr]);//optimize space
                    }
                }
                visited[curr]=true;
            }
            count++;
        }
        return -1;
    }
}

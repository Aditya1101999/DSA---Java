package Graphs;
import java.util.*;
public class KeysRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited=new boolean[rooms.size()];
        dfs(rooms.get(0),0,rooms,visited);
        for(int i=0;i<rooms.size();i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
    private void dfs(List<Integer>keys,int room,List<List<Integer>> rooms, boolean[] visited){
        visited[room]=true;
        for(int i:keys){
            if(!visited[i]){
                dfs(rooms.get(i),i,rooms,visited);
            }
        }
    }
}

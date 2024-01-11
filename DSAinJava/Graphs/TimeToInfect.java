package DSAinJava.Graphs;
import DSAinJava.BinaryTree.SearchTree;

import java.util.*;
public class TimeToInfect {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
    static class Pair{
        Integer key;
        Integer value;
        Pair(Integer key,Integer value){
            this.key=key;
            this.value=value;
        }
        public Integer getKey(){
            return key;
        }
        public int getValue(){
            return value;
        }
    }
    public int amountOfTimeBFS(TreeNode root, int start) {
        Map<Integer,List<Integer>>graph=new HashMap<>();
        getGraph(root,-1,graph);
        int ans=0;
        Queue<Pair>q=new LinkedList<>();
        Set<Integer>visited=new HashSet<>();
        q.add(new Pair(start,0));
        visited.add(start);
        while(!q.isEmpty()){
            int n=q.size();
            while(n-->0){
                int currNode=q.peek().getKey();
                int currTime=q.peek().getValue();
                q.poll();
                ans=Math.max(ans,currTime);
                for(int neighbour : graph.getOrDefault(currNode,Collections.emptyList())){
                    if(!visited.contains(neighbour)){
                        visited.add(neighbour);
                        q.add(new Pair(neighbour,currTime+1));
                    }
                }
            }
        }
        return ans;
    }
    private void getGraph(TreeNode curr,int parent, Map<Integer,List<Integer>>graph){
        if(curr==null){
            return;
        }
        if(parent!=-1){
            graph.computeIfAbsent(curr.val,k->new ArrayList<>()).add(parent);
        }
        if(curr.left!=null){
            graph.computeIfAbsent(curr.val,k->new ArrayList<>()).add(curr.left.val);
        }
        if(curr.right!=null){
            graph.computeIfAbsent(curr.val,k->new ArrayList<>()).add(curr.right.val);
        }
        getGraph(curr.left,curr.val,graph);
        getGraph(curr.right,curr.val,graph);
    }
    public int amountOfTime(TreeNode root, int start) {
        int[] result=new int[1];
        DFS(root,start,result);
        return result[0];
    }
    private int DFS(TreeNode root, int start,int[] result){
        if(root==null){
            return 0;
        }
        int left=DFS(root.left,start,result);
        int right=DFS(root.right,start,result);

        if(root.val==start){
            result[0]=Math.max(left,right);
            return -1;
        }
        else if(left>=0 && right>=0){//strt not included
            return Math.max(left,right)+1;
        }
        //one is negative and start is included
        int distance=Math.abs(left)+Math.abs(right);//calculating distance from start
        result[0]=Math.max(result[0],distance);
        return Math.min(left,right)-1;//negative value(start) with an extra distance unit
    }
}

package DSAinJava.BinaryTree;
import java.util.*;
public class VerticalOrderTraversal {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
  }
    class Pair{
        int row;
        int col;
        TreeNode node;
        public Pair(int row,int col,TreeNode node){
            this.row=row;
            this.col=col;
            this.node=node;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair>q=new LinkedList<>();
        Map<Integer,PriorityQueue<Pair>>map=new TreeMap<>();//vertical level , nodes(PQ to keep smaller values first)

        q.add(new Pair(0,0,root));
        while(!q.isEmpty()){//level-order traversal
            Pair curr=q.remove();
            if(map.containsKey(curr.col)){//different nodes at same vertical level(column)
                map.get(curr.col).add(curr);
            }
            else{
                PriorityQueue<Pair>temp=new PriorityQueue<>((a,b)->{
                    if(a.row==b.row){//small element in same horizontal level
                        return a.node.val-b.node.val;
                    };
                    return a.row-b.row;
                });
                temp.add(curr);
                map.put(curr.col,temp);
            }
            if(curr.node.left!=null){
                q.add(new Pair(curr.row+1,curr.col-1,curr.node.left));
            }
            if(curr.node.right!=null){
                q.add(new Pair(curr.row+1,curr.col+1,curr.node.right));
            }
        }
        List<List<Integer>>ans=new ArrayList<>();
        for(Map.Entry<Integer,PriorityQueue<Pair>>entry:map.entrySet()){
            List<Integer>temp=new ArrayList<>();
            PriorityQueue<Pair> pq = entry.getValue();
            while (!pq.isEmpty()) {
                temp.add(pq.remove().node.val);
            }
            ans.add(temp);
        }
        return ans;
    }
}

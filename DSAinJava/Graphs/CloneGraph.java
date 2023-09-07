package DSAinJava.Graphs;
import java.util.*;
public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
    }
    Map<Node,Node>map=new HashMap<>();
    public Node cloneGraphDFS(Node node) {
        if(node==null){
            return null;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node copy=new Node(node.val);
        map.put(node,copy);

        List<Node>neighbors=new ArrayList<>();
        for(Node neighbor :node.neighbors){
            Node copiedNeighbor=cloneGraphDFS(neighbor);
            neighbors.add(copiedNeighbor);
        }
        copy.neighbors=neighbors;
        return copy;

    }
    public Node cloneGraphBFS(Node node) {
        if(node==null){
            return null;
        }
        Map<Node,Node>map=new HashMap<>();
        Queue<Node>q=new LinkedList<>();
        Node copy=new Node(node.val);
        q.add(node);
        map.put(node,copy);

        while(!q.isEmpty()){
            Node curr=q.remove();
            for(Node neighbor : curr.neighbors){
                if(!map.containsKey(neighbor)){
                    map.put(neighbor,new Node(neighbor.val));
                    q.add(neighbor);
                }
                map.get(curr).neighbors.add(map.get(neighbor));//copy->copy of neighbor
            }
        }
        return copy;
    }
}

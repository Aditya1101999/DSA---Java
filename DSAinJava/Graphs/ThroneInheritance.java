package DSAinJava.Graphs;
import java.util.*;
class ThroneInheritance {
    Map<String,List<String>>graph;
    Set<String>dead;
    String root;

    public ThroneInheritance(String kingName) {
        graph=new HashMap<>();
        dead=new HashSet<>();
        root=kingName;
        graph.put(kingName,graph.getOrDefault(kingName,new ArrayList<>()));
    }

    public void birth(String parentName, String childName) {
        graph.get(parentName).add(childName);
        graph.put(childName,graph.getOrDefault(childName,new ArrayList<>()));
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String>result=new ArrayList<>();
        dfs(root,result);
        return result;
    }
    private void dfs(String root,List<String>result){
        if(!dead.contains(root)){
            result.add(root);
        }
        for(String neighbour : graph.get(root)){
            dfs(neighbour,result);
        }
    }
}


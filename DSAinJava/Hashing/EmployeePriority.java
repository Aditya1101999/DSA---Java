package DSAinJava.Hashing;
import java.util.*;
public class EmployeePriority {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String,List<Integer>>map=new HashMap<>();//employee,access times
        List<String>ans=new ArrayList<>();

        for(List<String>curr:access_times){
            String employee=curr.get(0);
            String accessTime=curr.get(1);

            if(!map.containsKey(employee)){
                map.put(employee,new ArrayList<>());
            }
            int time=Integer.parseInt(accessTime);
            map.get(employee).add(time);
        }
        for(String employee : map.keySet()){
            List<Integer>curr=map.get(employee);
            if(isHighAccess(curr)){
                ans.add(employee);
            }
        }
        return ans;
    }
    private boolean isHighAccess(List<Integer>curr){
        int n=curr.size();
        Collections.sort(curr);
        for(int i=2;i<n;i++){//checking every window of size 3
            int currTime=curr.get(i);
            int prevPrevTime=curr.get(i-2);
            if(prevPrevTime+99>=currTime) return true;
        }
        return false;
    }
}

package DSAinJava.Hashing;
import java.util.*;
public class RandomizedSet {
    Map<Integer,Integer>map;
    List<Integer>list;
    Random rand;
    public RandomizedSet() {
        map=new HashMap<>();
        list=new ArrayList<>();
        rand=new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val,list.size());
        list.add(val);
        return true;
    }
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int last=list.get(list.size()-1);
        if(val==last){
            list.remove(list.size()-1);
            map.remove(val);
            return true;
        }
        int index=map.get(val);
        list.set(index,last);
        map.put(last,index);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int size=list.size();
        int index=rand.nextInt(size);//random no. till range of list's size
        return list.get(index);
    }
}

package DSAinJava.Practice;
import java.util.*;
public class Set {
    static class HashSet{
        Map<Integer,Boolean>set;
        public HashSet(){
            set=new HashMap<>();
        }
        public boolean add(int element){
            if(set.containsKey(element)){
                return false;
            }
            set.put(element,true);
            return true;
        }
        public boolean remove(int element){
            if(!set.containsKey(element)){
                return false;
            }
            set.remove(element);
            return true;
        }
        public boolean contains(int element){
            return set.containsKey(element);
        }
        public int size(){
            return set.size();
        }
        public boolean isEmpty(){
            return set.isEmpty();
        }
        public void clear(){
            set.clear();
        }
    }


}

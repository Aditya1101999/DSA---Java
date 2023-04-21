package DSAinJava.Hashing;
import java.util.*;
public class LRUCache {
    class Node{
        Node prev,next;
        int key,value;
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    Map<Integer,Node>map=new HashMap<>();//key,value
    int capacity;
    Node head=new Node(0,0);
    Node tail=new Node(0,0);
    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node curr=map.get(key);
            remove(curr);
            insert(curr);
            return curr.value;
        }
        else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size()==capacity){
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }
    private void insert(Node curr){//inserting in front of head
        map.put(curr.key,curr);
        curr.next=head.next;
        head.next.prev=curr;
        head.next=curr;
        curr.prev=head;
    }
    private void remove(Node curr){//removing LRU element
        map.remove(curr.key);
        curr.prev.next=curr.next;
        curr.next.prev=curr.prev;
    }
}

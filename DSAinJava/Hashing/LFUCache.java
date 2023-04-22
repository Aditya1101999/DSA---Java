package DSAinJava.Hashing;
import java.util.*;
public class LFUCache {
    int capacity;
    int cacheSize;
    int minFrequency;
    Map<Integer,DLLNode>cache;
    Map<Integer,DoubleLinkedList>freqMap;//all lists by their frequencies

    class DLLNode{
        int key;
        int value;
        int frequency;
        DLLNode prev;
        DLLNode next;

        public DLLNode(int key,int value){
            this.key=key;
            this.value=value;
            this.frequency=1;
        }
    }

    class DoubleLinkedList{
        int llSize;
        DLLNode head;
        DLLNode tail;
        public DoubleLinkedList(){
            this.llSize=0;
            this.head=new DLLNode(0,0);
            this.tail=new DLLNode(0,0);
            head.next=tail;
            tail.prev=head;
        }
        public void addNode(DLLNode curr){
            curr.next=head.next;
            head.next.prev=curr;
            head.next=curr;
            curr.prev=head;
            llSize++;
        }
        public void removeNode(DLLNode curr){
            curr.prev.next=curr.next;
            curr.next.prev=curr.prev;
            llSize--;
        }
    }

    public LFUCache(int capacity) {
        this.capacity=capacity;
        cacheSize=0;
        minFrequency=0;
        cache=new HashMap<>();
        freqMap=new HashMap<>();
    }

    public int get(int key) {
        DLLNode curr=cache.get(key);
        if(curr==null) return -1;
        updateNode(curr);
        return curr.value;
    }

    public void put(int key, int value) {
        if(capacity==0) return;

        if(cache.containsKey(key)){
            DLLNode curr=cache.get(key);
            curr.value=value;
            updateNode(curr);//key accessed ->frequency will increase
        }
        else{//new element
            cacheSize++;
            if(cacheSize>capacity){
                DoubleLinkedList minFreqList=freqMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                cacheSize--;
            }
            minFrequency=1;//new element is added
            DLLNode newNode=new DLLNode(key,value);
            //DLL with frequency==1
            DoubleLinkedList currList=freqMap.getOrDefault(1,new DoubleLinkedList());
            currList.addNode(newNode);
            freqMap.put(1,currList);
            cache.put(key,newNode);
        }

    }
    private void updateNode(DLLNode curr){//increase frequency
        int currFreq=curr.frequency;
        DoubleLinkedList currList=freqMap.get(currFreq);
        currList.removeNode(curr);

        if(currFreq==minFrequency && currList.llSize==0){
            minFrequency++;
        }
        curr.frequency++;
        DoubleLinkedList newList=freqMap.getOrDefault(curr.frequency,new DoubleLinkedList());
        newList.addNode(curr);
        freqMap.put(curr.frequency,newList);
    }
}

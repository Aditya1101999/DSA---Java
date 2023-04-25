package DSAinJava.Heaps;
import java.util.*;
public class MedianDataStream {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianDataStream() {
        maxHeap=new PriorityQueue<>((a,b)->(b-a));
        minHeap=new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(maxHeap.size()==0|| maxHeap.peek()>=num){//adding smaller elements than minHeap
            maxHeap.add(num);
        }
        else{
            minHeap.add(num);
        }
        balance();
    }

    public double findMedian() {
        if(maxHeap.size()>minHeap.size()){
            return maxHeap.peek();
        }
        else if(minHeap.size()>maxHeap.size()){
            return minHeap.peek();
        }
        else{// maxHeap == minHeap size
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }

    }
    private void balance(){
        if(minHeap.size()-maxHeap.size()>1){
            maxHeap.add(minHeap.remove());
        }
        else if(maxHeap.size()-minHeap.size()>1){
            minHeap.add(maxHeap.remove());
        }
    }
}

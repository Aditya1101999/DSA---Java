package Heaps;
import java.util.ArrayList;
public class PriorityQueue {
    static class Heap{
        ArrayList<Integer>arr=new ArrayList<>();
        public void insert(int data){
            arr.add(data);//last index
            int x=arr.size()-1;//x is child index
            int par=(x-1)/2;//par is parent index
            while(arr.get(x)<arr.get(par)){//x>par for max heap
                //swap
                int temp=arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);

                x=par;
                par=(x-1)/2;
            }
        }
        public int peek(){
            return arr.get(0);
        }
        private void heapify(int i){
            int left=2*i+1;
            int right=2*i+2;
            int min=i;
            if(left<arr.size()&&arr.get(min)>arr.get(left)){
                min=left;
            }//reverse signs for max heap at both places
            if(right<arr.size()&&arr.get(min)>arr.get(right)){
                min=right;
            }
            if(min!=i){//minimum value changed
                //swap
                int temp=arr.get(i);
                arr.set(i,arr.get(min));
                arr.set(min,temp);
                //if any bottom nodes affected , then to fix them
                heapify(min);
            }
        }
        public int remove(){
            int data=arr.get(0);
            //swap first and last element
            int temp=arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);
            //delete last element
            arr.remove(arr.size()-1);
            //heapify
            heapify(0);
            return data;
        }
        public boolean isEmpty(){
            return arr.size()==0;
        }
    }
    public static void main(String[] args){
        Heap pq=new Heap();
        pq.insert(3);
        pq.insert(4);
        pq.insert(1);
        pq.insert(5);
        while(!pq.isEmpty()){
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
package Stack;
import java.util.*;
public class NextGreEle {
    public static void main(String[] args) {
        int[] arr = {6, 8, 0, 1, 3};
        Stack<Integer> s = new Stack<>();
        int[] nextGre = new int[arr.length];
//for left greater , go for forward iteration
        for (int i = arr.length-1;i>=0;i--){
         //for next smaller , arr[i]<=arr.[s.peek()]
            while(!s.isEmpty() &&arr[i]>=arr[s.peek()]){
                    s.pop();
            }
            if(s.isEmpty()){
                nextGre[i]=-1;
            }
            else{
                nextGre[i]=arr[s.peek()];
            }
            s.push(i);
        }
        for(int i=0;i< nextGre.length;i++){
            System.out.print(nextGre[i]+" ");
        }

    }
}



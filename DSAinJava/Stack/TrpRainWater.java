package DSAinJava.Stack;
import java.util.*;
public class TrpRainWater {
    public static int maxWater(int[] height){
            Stack<Integer>stack=new Stack<>();
            int n= height.length;
            int ans=0;
            for(int i=0;i<n;i++) {
                while(!stack.isEmpty()
                    && height[stack.peek()]<=height[i]){
                    int cur=stack.pop();
                    if(stack.isEmpty()){//no solution
                        break;
                    }
                    int diff=i-stack.peek()-1;//width
                    //stack.peek will give left wall
                    //height[i] will give right wall
                    int minHeight=Math.min(height[stack.peek()],height[i]-height[cur]);
                    ans+=minHeight*diff;
                }
                stack.push(i);
            }
            return ans;
    }
    public static void main(String[] args){
        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(maxWater(arr));
    }
}

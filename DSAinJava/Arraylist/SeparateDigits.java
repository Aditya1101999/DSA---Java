package Arraylist;
import java.util.*;
public class SeparateDigits {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer>temp=new ArrayList<>();
        int n=nums.length;
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            while(nums[i]>0){
                st.push(nums[i]%10);
                nums[i]/=10;
            }
            while(!st.isEmpty()){
                temp.add(st.pop());
            }
        }
        int[] arr = new int[temp.size()];

        // ArrayList to Array Conversion
        for (int i = 0; i < temp.size(); i++)
            arr[i] = temp.get(i);

        return arr;
    }
}

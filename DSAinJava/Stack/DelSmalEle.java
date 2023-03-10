package Stack;
import java.util.*;
public class DelSmalEle {
    public static ArrayList<Integer> deleteElement (int arr[], int n, int k) {
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() &&st.peek()<arr[i]&&k>0){
                st.pop();
                k--;
            }
            st.push(arr[i]);
        }
        ArrayList<Integer>ans=new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        ans=reverse(ans);
        return ans;
    }
    public static ArrayList<Integer> reverse(ArrayList<Integer> alist)
    {
        // Arraylist for storing reversed elements
        ArrayList<Integer> revArrayList = new ArrayList<Integer>();
        for (int i = alist.size() - 1; i >= 0; i--) {

            // Append the elements in reverse order
            revArrayList.add(alist.get(i));
        }

        // Return the reversed arraylist
        return revArrayList;
    }
    public static void main(String[] args){
        int arr[ ] = {20, 10, 25, 30, 40};
        int K = 2;
        ArrayList<Integer>an=deleteElement(arr,arr.length,K);

    }
}

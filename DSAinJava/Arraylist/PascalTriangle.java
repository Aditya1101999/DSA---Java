package Arraylist;
import java.util.*;
public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer>curr,prev=null;//currRow list and previousRow list
        for(int i=0;i<numRows;i++){
            curr=new ArrayList<>();
            for(int j=0;j<=i;j++){//elements/column
                if(j==0||j==i){
                    curr.add(1);//column starts and end with 1
                }
                else{
                    curr.add(prev.get(j-1)+prev.get(j));//sum of the two numbers directly above it
                }
            }
            prev=curr;
            res.add(curr);
        }
        return res;
    }
    public static void main(String[] args){
        int numRows=5;
        System.out.println(generate(numRows));
    }
}

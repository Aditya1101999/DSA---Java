package Greedy;
import java.util.*;
public class IndianCoins {
    public static void main(String[] args){
        Integer[] curr={1,2,5,10,20,50,100,500,2000};
        Arrays.sort(curr,Comparator.reverseOrder());
        int amount=590;
        int count=0;
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=0;i< curr.length;i++){
            if(amount>=curr[i]){
                while(amount>=curr[i]) {
                    //change
                    count++;
                    ans.add(curr[i]);
                    amount -= curr[i];
                }
            }
        }
        System.out.println("coins used "+count);
        System.out.println("denominations are :"+ans);
    }
}

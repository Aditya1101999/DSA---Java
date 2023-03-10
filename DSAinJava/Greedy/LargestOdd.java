package Greedy;
import java.util.*;
public class LargestOdd {
    public static int KthOdd(int[] range,int K){
        if(K<=0){//invalid input
            return 0;
        }
        int L=range[0];//left limit
        int R=range[1];//right limit
        if((R&1)>0){//R is odd
            int count=(int)Math.ceil((R-L+1)/2);
            //counting no.of odd no.s in range
            if(K>count){
                return 0;
            }
            else{
                return (R-2*K+2);
            }
        }
        else{//R is even
            int count=(R-L+1)/2;
            if(K>count){
                return 0;
            }
            else{
                return (R-2*K+1);
            }
        }
    }
    public static void main(String[] args){
        int[] p={-3,3};
        int k=8;
        System.out.println(KthOdd(p,k));
    }
}
